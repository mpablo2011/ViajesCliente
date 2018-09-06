package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import interfaz.TDAManejoDatos;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static TDAManejoDatos sis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					MainView frame = new MainView();
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
	public MainView() {
		sis = Cliente.getInstancia();
		sis.cargaInicial();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Clientes");
		menuBar.add(mnMenu);
		
		JMenuItem mntmAltaDeUsuarios = new JMenuItem("Alta de cliente");
		mntmAltaDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaClienteView auv = new AltaClienteView();
				auv.setVisible(true);
				MainView.this.setVisible(false);
				
			}
		});
		mnMenu.add(mntmAltaDeUsuarios);
		
		JMenuItem mntmBajaDeClientes = new JMenuItem("Baja de cliente");
		mntmBajaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaClienteView bcv = new BajaClienteView();
				bcv.setVisible(true);
				MainView.this.setVisible(false);
			}
		});
		mnMenu.add(mntmBajaDeClientes);
		
		JMenu mnNewMenu = new JMenu("Productos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAltaProducto = new JMenuItem("Alta producto");
		mntmAltaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaProductosView auv = new AltaProductosView();
				auv.setVisible(true);
				MainView.this.setVisible(false);
				
			}
		});
		mnNewMenu.add(mntmAltaProducto);
		
		JMenuItem mntmAltaPaquete = new JMenuItem("Alta paquete");
		mntmAltaPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaPaquetesView auv = new AltaPaquetesView();
				auv.setVisible(true);
				MainView.this.setVisible(false);
				
			}
		});
		mnNewMenu.add(mntmAltaPaquete);
		
		JMenu mnNewMenu_1 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNuevaVenta = new JMenuItem("Nueva Venta");
		mntmNuevaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaVentasView avv = new AltaVentasView();
				avv.setVisible(true);
				MainView.this.setVisible(false);
			}
		});
		mnNewMenu_1.add(mntmNuevaVenta);
		
		JMenuItem mntmListarVtasX = new JMenuItem("Ventas por cliente");
		mnNewMenu_1.add(mntmListarVtasX);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
