package vistas;

import java.awt.Color;
import java.awt.EventQueue;

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

public class BajaClienteView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dniField;
	private static TDAManejoDatos sistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					BajaClienteView frame = new BajaClienteView();
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
	public BajaClienteView() {
		sistema = Cliente.getInstancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(12, 43, 56, 16);
		contentPane.add(lblDni);
		
		dniField = new JTextField();
		dniField.setBounds(100, 40, 116, 22);
		contentPane.add(dniField);
		dniField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String dniStr = dniField.getText();

				if (dniStr.isEmpty()) {
	            	JOptionPane pane = new JOptionPane("Complete el DNI");
	            	pane.setBackground(Color.RED);
	                JDialog d = pane.createDialog(new JFrame(), "OK");
	                d.setLocation(100,100);
	                d.setVisible(true);
				}
				else {
					
					int dni = Integer.parseInt(dniField.getText());
					
					int resultado = sistema.bajaCliente(dni);
					
					if (resultado == 1) {
		            	JOptionPane pane = new JOptionPane("Cliente eliminado de forma correcta");
		            	pane.setBackground(Color.GREEN);
		                JDialog d = pane.createDialog(new JFrame(), "OK");
		                d.setLocation(100,100);
		                d.setVisible(true);
					}
					if (resultado == -1) {
		            	JOptionPane pane = new JOptionPane("Cliente inexistente.");
		            	pane.setBackground(Color.RED);
		                JDialog d = pane.createDialog(new JFrame(), "OK");
		                d.setLocation(100,100);
		                d.setVisible(true);
					}
					
				}
			}
		});
		btnAceptar.setBounds(120, 100, 97, 25);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView mvw = new MainView();
				mvw.setVisible(true);
				BajaClienteView.this.setVisible(false);
			}
		});
		btnVolver.setBounds(11, 100, 97, 25);
		contentPane.add(btnVolver);
	}

}
