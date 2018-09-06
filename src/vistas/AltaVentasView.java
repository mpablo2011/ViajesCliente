package vistas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bean.Views.ClienteView;
import bean.Views.VentaView;
import cliente.Cliente;
import interfaz.TDAManejoDatos;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

public class AltaVentasView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dniField;
	private JTable table;
	private JTextField precioTotField;
	private JTextField clienteNombreField;
	
	private TDAManejoDatos sistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaVentasView frame = new AltaVentasView();
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
	public AltaVentasView() {
		sistema = Cliente.getInstancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("DNI Cliente:");
		lblCliente.setBounds(12, 24, 73, 16);
		contentPane.add(lblCliente);
		
		dniField = new JTextField();
		dniField.setBounds(97, 21, 185, 22);
		contentPane.add(dniField);
		dniField.setColumns(10);
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
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
					int resultado = sistema.VincularClienteAVenta(dni);
					
					if (resultado == 1) {
						ClienteView c = sistema.getClienteView();
						clienteNombreField.setText(c.getNombre());
		            	JOptionPane pane = new JOptionPane("Cliente vinculado de forma correcta");
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
		btnBuscar.setBounds(302, 20, 151, 25);
		contentPane.add(btnBuscar);
		
		JButton btnAlta = new JButton("Nuevo Cliente");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaClienteView acv = new AltaClienteView();
				acv.setVisible(true);
				AltaVentasView.this.setVisible(false);
			}
		});
		btnAlta.setBounds(302, 49, 151, 25);
		contentPane.add(btnAlta);
		
		// Inicio de tabla de productos
		Vector<String> columnas = new Vector<String>();
		columnas.add("Codigo Producto");
		columnas.add("Discripción");
		columnas.add("Cantidad");
		Vector data = sistema.getItemVentaVector();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 460, 131);
		contentPane.add(scrollPane);
		TableModel dtm = new DefaultTableModel(data,columnas);
		table = new JTable();
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setBounds(12, 88, 70, 16);
		contentPane.add(lblProductos);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarProductoView bpv = new buscarProductoView();
				bpv.setVisible(true);
				AltaVentasView.this.setVisible(false);
			}
		});
		btnAgregarProducto.setBounds(12, 259, 469, 25);
		contentPane.add(btnAgregarProducto);
		
		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(12, 317, 81, 16);
		contentPane.add(lblPrecioTotal);
		
		precioTotField = new JTextField();
		precioTotField.setEditable(false);
		precioTotField.setBounds(134, 314, 148, 22);
		contentPane.add(precioTotField);
		precioTotField.setColumns(10);
		VentaView vw = sistema.getVentaView();
		if (vw == null) 
		{
			precioTotField.setText("0");
		}
		else
		{
			float precioTotal = vw.getTotalVenta();
			precioTotField.setText(Float.toString(precioTotal));
		}
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView mv = new MainView();
				mv.setVisible(true);
				AltaVentasView.this.setVisible(false);
			}
		});
		btnVolver.setBounds(12, 386, 185, 25);
		contentPane.add(btnVolver);
		
		JButton btnRegistrarVenta = new JButton("Registrar Venta");
		btnRegistrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sistema.grabarVenta();
				
            	JOptionPane pane = new JOptionPane("Venta registrada de forma satisfactoria.");
            	pane.setBackground(Color.GREEN);
                JDialog d = pane.createDialog(new JFrame(), "OK");
                d.setLocation(100,100);
                d.setVisible(true);
			}
		});
		btnRegistrarVenta.setBounds(253, 386, 200, 25);
		contentPane.add(btnRegistrarVenta);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 53, 56, 16);
		contentPane.add(lblNombre);
		
		clienteNombreField = new JTextField();
		clienteNombreField.setEditable(false);
		clienteNombreField.setBounds(97, 50, 185, 22);
		contentPane.add(clienteNombreField);
		clienteNombreField.setColumns(10);
				
		ClienteView c = sistema.getClienteView();
		
		if (c!=null)
		{
			dniField.setText(Integer.toString(c.getDni()));
			clienteNombreField.setText(c.getNombre());
		}
	}
}
