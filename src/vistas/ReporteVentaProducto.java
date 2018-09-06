package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import cliente.Cliente;
import interfaz.TDAManejoDatos;

import javax.swing.JLabel;

public class ReporteVentaProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableVentas;
	private JTable tableProducto;
	private TDAManejoDatos sistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteVentaProducto frame = new ReporteVentaProducto();
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
	public ReporteVentaProducto() {
		sistema = Cliente.getInstancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//INICIO GRILLA VENTAS
		
		Vector<String> columnasVentas = new Vector<String>(); 
		columnasVentas.add("Id");
		columnasVentas.add("DNI");
		columnasVentas.add("Cliente");
		columnasVentas.add("Fecha");
		columnasVentas.add("Total");
		Vector<Vector<String>> dataVentas = null;
		try
		{
			dataVentas = sistema.obtenerVentasView();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		// creamos el modelo con los datos 
		TableModel modeloVentas = new DefaultTableModel(dataVentas, columnasVentas) {
		    private static final long serialVersionUID = 1L;
		    public Class<?> getColumnClass(int column) {
		        return getValueAt(0, column).getClass();
		    }
		};

		// creamos la Table basados en el modelo de datos que hemos creado
		tableVentas = new JTable(modeloVentas);
		tableVentas.setEnabled(false);

		// ordenacion de filas (por defecto, al ser tipos primitivos)
		TableRowSorter<TableModel> sorterVentas = new TableRowSorter<TableModel>(modeloVentas);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		tableVentas.setRowSorter(sorterVentas);

		// creamos un scroll y le añadimos la tabla
		JScrollPane scrollPaneVentas = new JScrollPane();
		scrollPaneVentas.setBounds(15, 39, 450, 180);
		scrollPaneVentas.setViewportView(tableVentas);
		getContentPane().add(scrollPaneVentas);		
		
		//FIN GRILLA VENTAS
		
		//INICIO GRILLA PRODUCTO
		
		Vector<String> columnasProductos = new Vector<String>();
		columnasProductos.add("Codigo");
		columnasProductos.add("Descripcion");
		columnasProductos.add("Precio");
		Vector<Vector<String>> dataProductos = null;
		try
		{
			dataProductos = sistema.obtenerProductosView();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		// creamos el modelo con los datos 
		TableModel modeloProducto = new DefaultTableModel(dataProductos, columnasProductos) {
		    private static final long serialVersionUID = 1L;
		    public Class<?> getColumnClass(int column) {
		        return getValueAt(0, column).getClass();
		    }
		};

		// creamos la Table basados en el modelo de datos que hemos creado
		tableProducto = new JTable(modeloProducto);
		tableProducto.setEnabled(false);

		// ordenacion de filas (por defecto, al ser tipos primitivos)
		TableRowSorter<TableModel> sorterProducto = new TableRowSorter<TableModel>(modeloProducto);
		contentPane.setLayout(null);
		tableProducto.setRowSorter(sorterProducto);

		// creamos un scroll y le añadimos la tabla
		JScrollPane scrollPaneProducto = new JScrollPane();
		scrollPaneProducto.setBounds(15, 255, 450, 180);
		scrollPaneProducto.setViewportView(tableProducto);
		getContentPane().add(scrollPaneProducto);		
		
		JLabel lblReporteDeVentas = new JLabel("Reporte de Ventas");
		lblReporteDeVentas.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblReporteDeVentas.setBounds(15, 11, 232, 14);
		contentPane.add(lblReporteDeVentas);
		
		JLabel lblReporteDeProductos = new JLabel("Reporte de Productos");
		lblReporteDeProductos.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblReporteDeProductos.setBounds(15, 230, 220, 14);
		contentPane.add(lblReporteDeProductos);
		
		//FIN GRILLA PRODUCTO
		
		
	}
}
