package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import interfaz.TDAManejoDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaClienteView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreField;
	private JTextField dniField;
	private JTextField telefonoField;
	private JTextField mailField;
	
	private TDAManejoDatos sistema;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaClienteView frame = new AltaClienteView();
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
	public AltaClienteView() {
		sistema = Cliente.getInstancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(53, 44, 100, 20);
		contentPane.add(lblNombre);
		
		nombreField = new JTextField();
		nombreField.setBounds(135, 44, 180, 20);
		contentPane.add(nombreField);
		nombreField.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(53, 84, 66, 20);
		contentPane.add(lblDNI);
		
		dniField = new JTextField();
		dniField.setColumns(10);
		dniField.setBounds(135, 84, 180, 20);
		contentPane.add(dniField);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(53, 124, 100, 20);
		contentPane.add(lblTelefono);
		
		telefonoField = new JTextField();
		telefonoField.setColumns(10);
		telefonoField.setBounds(135, 124, 180, 20);
		contentPane.add(telefonoField);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(53, 164, 100, 20);
		contentPane.add(lblMail);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(135, 165, 180, 20);
		contentPane.add(mailField);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos para generar el Alta de Cliente");
		lblIngreseLosDatos.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblIngreseLosDatos.setBounds(46, 17, 353, 16);
		contentPane.add(lblIngreseLosDatos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			

			String dniStr = dniField.getText();
			String mail = mailField.getText();
			String nombre = nombreField.getText();
			String telefonoStr = telefonoField.getText();

			if (dniStr.isEmpty() || mail.isEmpty() || nombre.isEmpty() || telefonoStr.isEmpty()) {
            	JOptionPane pane = new JOptionPane("Complete todos los campos");
            	pane.setBackground(Color.RED);
                JDialog d = pane.createDialog(new JFrame(), "OK");
                d.setLocation(100,100);
                d.setVisible(true);
			}
			else {
				
				int dni = Integer.parseInt(dniField.getText());
				int telefono = Integer.parseInt(telefonoField.getText());
				
				int resultado = sistema.altaCliente(dni, nombre, telefono, mail);
				
				if (resultado == 1) {
	            	JOptionPane pane = new JOptionPane("Cliente dado de alta de forma correcta");
	            	pane.setBackground(Color.GREEN);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
				if (resultado == -1) {
	            	JOptionPane pane = new JOptionPane("El cliente ya existe");
	            	pane.setBackground(Color.RED);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
				
			}
			
			}
		});
		btnAceptar.setBounds(218, 207, 97, 25);
		contentPane.add(btnAceptar);
		
		JButton volverButton = new JButton("Volver");
		volverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView mvw = new MainView();
				mvw.setVisible(true);
				AltaClienteView.this.setVisible(false);
			}
		});
		volverButton.setBounds(53, 207, 97, 25);
		contentPane.add(volverButton);
	}
}
