package Views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.MainSistemaDeVentas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaPasajesView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDesc;
	private JTextField textFieldFecha;
	private JTextField textFieldPrecio;
	private JTextField textFieldAerolinea;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;
	
	private MainSistemaDeVentas sis = MainSistemaDeVentas.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPasajesView frame = new AltaPasajesView();
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
	public AltaPasajesView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcion.setBounds(100, 61, 81, 14);
		contentPane.add(lblDescripcion);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setBounds(178, 58, 154, 20);
		contentPane.add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(100, 111, 56, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblFechaPasaje = new JLabel("Fecha Pasaje: ");
		lblFechaPasaje.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaPasaje.setBounds(100, 86, 71, 14);
		contentPane.add(lblFechaPasaje);
		
		JLabel lblAerolinea = new JLabel("Aerolinea:");
		lblAerolinea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAerolinea.setBounds(100, 136, 69, 14);
		contentPane.add(lblAerolinea);
		
		JLabel lblOrigen = new JLabel("Origen:");
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOrigen.setBounds(100, 161, 46, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDestino.setBounds(100, 186, 46, 14);
		contentPane.add(lblDestino);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(178, 83, 154, 20);
		contentPane.add(textFieldFecha);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(178, 108, 154, 20);
		contentPane.add(textFieldPrecio);
		
		textFieldAerolinea = new JTextField();
		textFieldAerolinea.setColumns(10);
		textFieldAerolinea.setBounds(178, 133, 154, 20);
		contentPane.add(textFieldAerolinea);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setColumns(10);
		textFieldOrigen.setBounds(178, 158, 154, 20);
		contentPane.add(textFieldOrigen);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setColumns(10);
		textFieldDestino.setBounds(178, 183, 154, 20);
		contentPane.add(textFieldDestino);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos para generar el Pasaje");
		lblIngreseLosDatos.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblIngreseLosDatos.setBounds(95, 23, 277, 16);
		contentPane.add(lblIngreseLosDatos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					sis.grabarPasaje(textFieldDesc.getText(),textFieldFecha.getText(),
									  textFieldAerolinea.getText(),textFieldOrigen.getText(),
									  textFieldDestino.getText(),Float.parseFloat(textFieldPrecio.getText()));
					
					JOptionPane pane = new JOptionPane("Pasaje dado de alta de forma correcta");
	            	pane.setBackground(Color.GREEN);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				
				}
				catch(Exception ex)
				{
					JOptionPane pane = new JOptionPane("Ocurrio un error al generar el alta del Pasaje");
	            	pane.setBackground(Color.RED);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
			}
		});
		btnAceptar.setBounds(100, 214, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaPasajesView.this.setVisible(false);
				AltaProductosView view = new AltaProductosView();
         		view.setVisible(true);
			}
		});
		
		btnCancelar.setBounds(243, 213, 89, 23);
		contentPane.add(btnCancelar);
	}
}
