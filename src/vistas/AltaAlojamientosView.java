package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import interfaz.TDAManejoDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaAlojamientosView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDesc;
	private JTextField textFieldFechaDesde;
	private JTextField textFieldFechaHasta;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JTextField textFieldUbicacion;

	private TDAManejoDatos sistema;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaAlojamientosView frame = new AltaAlojamientosView();
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
	public AltaAlojamientosView() {
		sistema = Cliente.getInstancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcion.setBounds(100, 49, 68, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblFechaDesde = new JLabel("Fecha desde: ");
		lblFechaDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaDesde.setBounds(100, 74, 83, 14);
		contentPane.add(lblFechaDesde);
		
		JLabel lblFechaHasta = new JLabel("Fecha hasta: ");
		lblFechaHasta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaHasta.setBounds(100, 99, 67, 14);
		contentPane.add(lblFechaHasta);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(100, 126, 68, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(100, 151, 73, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblUbicacion = new JLabel("Ubicacion: ");
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUbicacion.setBounds(100, 176, 58, 14);
		contentPane.add(lblUbicacion);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setBounds(191, 45, 144, 20);
		contentPane.add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		textFieldFechaDesde = new JTextField();
		textFieldFechaDesde.setColumns(10);
		textFieldFechaDesde.setBounds(191, 70, 144, 20);
		contentPane.add(textFieldFechaDesde);
		
		textFieldFechaHasta = new JTextField();
		textFieldFechaHasta.setColumns(10);
		textFieldFechaHasta.setBounds(191, 96, 144, 20);
		contentPane.add(textFieldFechaHasta);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(191, 121, 144, 20);
		contentPane.add(textFieldNombre);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(191, 149, 144, 20);
		contentPane.add(textFieldPrecio);
		
		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setColumns(10);
		textFieldUbicacion.setBounds(191, 173, 144, 20);
		contentPane.add(textFieldUbicacion);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos para generar el Alojamiento");
		lblIngreseLosDatos.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblIngreseLosDatos.setBounds(81, 11, 353, 16);
		contentPane.add(lblIngreseLosDatos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					sistema.grabarAlojamiento(textFieldDesc.getText(),textFieldFechaDesde.getText(),
										  textFieldFechaHasta.getText(),textFieldNombre.getText(),
										  Integer.parseInt(textFieldPrecio.getText()),textFieldUbicacion.getText());
					
					JOptionPane pane = new JOptionPane("Alojamiento dado de alta de forma correcta");
	            	pane.setBackground(Color.GREEN);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
				catch(Exception ex)
				{
					JOptionPane pane = new JOptionPane("Ocurrio un error al generar el alta del alojamiento");
	            	pane.setBackground(Color.RED);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
			}
		});
		btnAceptar.setBounds(100, 216, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaAlojamientosView.this.setVisible(false);
				AltaProductosView view = new AltaProductosView();
         		view.setVisible(true);
			}
		});
		btnCancelar.setBounds(246, 216, 89, 23);
		contentPane.add(btnCancelar);
	}

}
