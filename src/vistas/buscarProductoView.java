package vistas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Views.ProductoView;
import cliente.Cliente;
import interfaz.TDAManejoDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class buscarProductoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codProducto;
	private JTextField cantField;
	private JTextField descField;
	private static TDAManejoDatos sistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					buscarProductoView frame = new buscarProductoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public buscarProductoView() {
		sistema = Cliente.getInstancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodProducto = new JLabel("Cod. Producto:");
		lblCodProducto.setBounds(12, 32, 99, 16);
		contentPane.add(lblCodProducto);
		
		codProducto = new JTextField();
		codProducto.setBounds(123, 29, 116, 22);
		contentPane.add(codProducto);
		codProducto.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codprod = Integer.parseInt(codProducto.getText());
				ProductoView pv = null;
				try {
					pv = sistema.getProductoPorCodigo(codprod);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (pv == null)
				{
	            	JOptionPane pane = new JOptionPane("Producto inexistente");
	            	pane.setBackground(Color.RED);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
	                
	                codProducto.setText("");
	                
				}
				else
				{
					descField.setText(pv.getDescripcion());	
				}
				
				
				
			}
		});
		btnBuscar.setBounds(286, 28, 97, 25);
		contentPane.add(btnBuscar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (codProducto.getText().isEmpty() || cantField.getText().isEmpty()) {
	            	JOptionPane pane = new JOptionPane("Complete todos los campos");
	            	pane.setBackground(Color.RED);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
				else {
					int codprod = Integer.parseInt(codProducto.getText());
					int cant = Integer.parseInt(cantField.getText());
					try {
						sistema.agregarProducto(codprod, cant);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					AltaVentasView avv = new AltaVentasView();
					avv.setVisible(true);
					buscarProductoView.this.setVisible(false);
				}
			}
		});
		btnAgregar.setBounds(142, 181, 97, 25);
		contentPane.add(btnAgregar);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(12, 107, 56, 16);
		contentPane.add(lblCantidad);
		
		cantField = new JTextField();
		cantField.setBounds(123, 104, 116, 22);
		contentPane.add(cantField);
		cantField.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(12, 181, 97, 25);
		contentPane.add(btnVolver);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(12, 71, 78, 16);
		contentPane.add(lblDescripcin);
		
		descField = new JTextField();
		descField.setEditable(false);
		descField.setBounds(123, 64, 116, 22);
		contentPane.add(descField);
		descField.setColumns(10);
	}
}
