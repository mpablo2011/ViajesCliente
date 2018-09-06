package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.MainSistemaDeVentas;
import cliente.Cliente;
import interfaz.TDAManejoDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaVisitasView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDesc;
	private JTextField textFieldFecha;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private static TDAManejoDatos sistema;
	
	private MainSistemaDeVentas sis = MainSistemaDeVentas.getInstancia();
	private JTextField textFieldUbicacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sistema = Cliente.getInstancia();
					AltaVisitasView frame = new AltaVisitasView();
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
	public AltaVisitasView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcion.setBounds(100, 44, 72, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFecha.setBounds(100, 74, 59, 14);
		contentPane.add(lblFecha);
		
		JLabel lblNombreGuia = new JLabel("Nombre Guia: ");
		lblNombreGuia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombreGuia.setBounds(100, 104, 85, 14);
		contentPane.add(lblNombreGuia);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(100, 164, 72, 14);
		contentPane.add(lblPrecio);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setBounds(180, 41, 142, 20);
		contentPane.add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(180, 69, 142, 20);
		contentPane.add(textFieldFecha);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(180, 99, 142, 20);
		contentPane.add(textFieldNombre);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(180, 159, 142, 20);
		contentPane.add(textFieldPrecio);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos para generar la Visita Turistica");
		lblIngreseLosDatos.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblIngreseLosDatos.setBounds(46, 11, 353, 16);
		contentPane.add(lblIngreseLosDatos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					sistema.grabarVisita(textFieldDesc.getText(),textFieldFecha.getText(),
									 textFieldNombre.getText(),textFieldUbicacion.getText(),Float.parseFloat(textFieldPrecio.getText()));
					
					JOptionPane pane = new JOptionPane("Visita Turistica dado de alta de forma correcta");
	            	pane.setBackground(Color.GREEN);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
				catch(Exception ex)
				{
					JOptionPane pane = new JOptionPane("Ocurrio un error al generar el alta de la Visita Turistica");
	            	pane.setBackground(Color.RED);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
			}
		});
		btnAceptar.setBounds(100, 200, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaVisitasView.this.setVisible(false);
				AltaProductosView view = new AltaProductosView();
         		view.setVisible(true);
			}
		});
		btnCancelar.setBounds(233, 200, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblUbicacion = new JLabel("Ubicacion: ");
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUbicacion.setBounds(100, 134, 73, 14);
		contentPane.add(lblUbicacion);
		
		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setBounds(180, 129, 142, 20);
		contentPane.add(textFieldUbicacion);
		textFieldUbicacion.setColumns(10);
	}
}
