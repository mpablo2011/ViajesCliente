package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AltaProductosView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaProductosView frame = new AltaProductosView();
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
	public AltaProductosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(156, 62, 122, 20);
		comboBox.addItem("");
		comboBox.addItem("Pasajes");
		comboBox.addItem("Alojamiento");
		comboBox.addItem("Visitas Turisticas");
		
		JLabel lblIngreseLosDatos = new JLabel("Elija el tipo de producto: ");
		lblIngreseLosDatos.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblIngreseLosDatos.setBounds(118, 11, 224, 16);
		contentPane.add(lblIngreseLosDatos);
		
		contentPane.add(comboBox);
		
		comboBox.addActionListener(new ActionListener(){
             @Override public void actionPerformed(ActionEvent e) {
            	 String tipo = (String) comboBox.getSelectedItem();
            	 
            	 if (tipo.equals("Pasajes"))
            	 {
            		AltaPasajesView view = new AltaPasajesView();
            		view.setVisible(true);
            		AltaProductosView.this.setVisible(false);
            	 }
            	 
            	 if (tipo.equals("Alojamiento"))
            	 {
            		AltaAlojamientosView view = new AltaAlojamientosView();
             		view.setVisible(true);
             		AltaProductosView.this.setVisible(false);
            	 }
            	 
            	 if (tipo.equals("Visitas Turisticas"))
            	 {
            		AltaVisitasView view = new AltaVisitasView();
              		view.setVisible(true);
              		AltaProductosView.this.setVisible(false);
            	 }
            	        
             }
		});
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(118, 65, 46, 14);
		contentPane.add(lblTipo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaProductosView.this.setVisible(false);
				MainView view = new MainView();
				view.setVisible(true);
			}
		});
		btnVolver.setBounds(168, 172, 89, 23);
		contentPane.add(btnVolver);
	}
}
