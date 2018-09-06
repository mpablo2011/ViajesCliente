package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.Views.ProductoView;
import cliente.Cliente;
import interfaz.TDAManejoDatos;
import bean.Views.PaqueteView;

public class AltaPaquetesView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField textFieldDesc;
	private TDAManejoDatos sistema;	
	private PaqueteView paqueteView = new PaqueteView();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPaquetesView frame = new AltaPaquetesView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField textFieldDescuento;
	private JTextField textFieldProducto;
	
	private static AltaPaquetesView instancia;
	private JTextField textFieldDescProd;
	public static AltaPaquetesView getInstancia() {
		if (instancia == null)
			instancia = new AltaPaquetesView();
		return instancia;
	}

	/**
	 * Create the frame.
	 */
	public AltaPaquetesView() {
		sistema = Cliente.getInstancia();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlumno = new JLabel("Descripcion:");
		lblAlumno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAlumno.setBounds(117, 60, 61, 16);
		contentPane.add(lblAlumno);

		textFieldDesc = new JTextField();
		textFieldDesc.setBounds(188, 55, 130, 26);
		contentPane.add(textFieldDesc);
		textFieldDesc.setColumns(10);

		JButton btnRealizarAlta = new JButton("Realizar alta");
		btnRealizarAlta.setBounds(76, 229, 117, 29);
		contentPane.add(btnRealizarAlta);
		btnRealizarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if ( !textFieldDesc.getText().equals("") && !textFieldDescuento.getText().equals(""))
					{
						paqueteView.setDescripcion(textFieldDesc.getText());
						paqueteView.setDescuento(Integer.parseInt(textFieldDescuento.getText()));
						sistema.grabarPaquete(paqueteView);
						
						JOptionPane pane = new JOptionPane("Paquete dado de alta de forma correcta");
		            	pane.setBackground(Color.GREEN);
		                JDialog d = pane.createDialog(new JFrame(), "OK");
		                d.setLocation(100,100);
		                d.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(instancia, "Debe Completar el formulario");
				}
				catch(Exception ex)
				{
					JOptionPane pane = new JOptionPane("Ocurrio un error al generar el alta del Paquete");
	            	pane.setBackground(Color.RED);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(228, 229, 117, 29);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView view = new MainView();
				view.setVisible(true);
				AltaPaquetesView.this.setVisible(false);
			}
		});

		JLabel lblCarrera = new JLabel("Descuento:");
		lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCarrera.setBounds(117, 90, 74, 16);
		contentPane.add(lblCarrera);

		textFieldDescuento = new JTextField();
		textFieldDescuento.setBounds(188, 85, 130, 26);
		contentPane.add(textFieldDescuento);
		textFieldDescuento.setColumns(10);

		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos para generar el paquete");
		lblIngreseLosDatos.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblIngreseLosDatos.setBounds(76, 17, 304, 16);
		contentPane.add(lblIngreseLosDatos);

		JButton btnAgregar = new JButton("Agregar Producto");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgregar.setBounds(151, 190, 130, 29);
		contentPane.add(btnAgregar);
		
		JLabel lblProducto = new JLabel("Producto: ");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProducto.setBounds(117, 123, 72, 14);
		contentPane.add(lblProducto);
		
		textFieldProducto = new JTextField();
		textFieldProducto.setColumns(10);
		textFieldProducto.setBounds(188, 115, 130, 26);
		contentPane.add(textFieldProducto);
		
		JLabel lblDescripcionProducto = new JLabel("Descripcion: ");
		lblDescripcionProducto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcionProducto.setBounds(117, 151, 61, 14);
		contentPane.add(lblDescripcionProducto);
		
		textFieldDescProd = new JTextField();
		textFieldDescProd.setEditable(false);
		textFieldDescProd.setBounds(188, 145, 130, 26);
		contentPane.add(textFieldDescProd);
		textFieldDescProd.setColumns(10);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductoView prod = null;
				try {
					prod = sistema.getProductoPorCodigo(Integer.parseInt(textFieldProducto.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (prod != null)				
				{
					if(prod.getEsPaquete())
						JOptionPane.showMessageDialog(instancia, "No es Posible agregar un paquete dentro de otro paquete");
					else
						if (!existeProductoEnPaquete(prod))
						{
							paqueteView.agregarProducto(prod);
							textFieldDescProd.setText(prod.getDescripcion());
							JOptionPane.showMessageDialog(instancia, "Se ha agregado el producto");
						}
						else
							JOptionPane.showMessageDialog(instancia, "El producto ya se encuentra agregado al paquete");	
				}
				else 
					JOptionPane.showMessageDialog(instancia, "El producto no existe");
			}
		});			
	}
	
	private boolean existeProductoEnPaquete(ProductoView prod)
	{
		for(ProductoView prodVw : this.paqueteView.getProductosView())
		{			
			if (prod.getCodigoProducto() == prodVw.getCodigoProducto())
				return true;			
		}
		return false;
	}
}
