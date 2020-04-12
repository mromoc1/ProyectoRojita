package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;

public class panelnuevaorden extends JPanel {
	
	public JButton boton_buscar;
	public JButton boton_agregar;
	public JButton boton_finalizar;
	
	
	public JTextField campocodigo;
	public JTextField campoidproveedor;
	public JTextField camponombre;
	public JTextField campocantidad;
	
	
	public JPanel panellista;
	public JTable tabla_productosproveedor;
	public JTable tabla_productosorden;

	public panelnuevaorden() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(286, 11, 236, 48);
		panel.add(panel_3);
		
		JLabel lblInventario = new JLabel("Nueva Orden");
		panel_3.add(lblInventario);
		lblInventario.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 70, 793, 432);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 11, 775, 107);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblrut = new JLabel("Codigo:");
		lblrut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblrut.setBounds(63, 11, 66, 19);
		panel_5.add(lblrut);
		
		campocodigo = new JTextField();
		campocodigo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campocodigo.setBounds(129, 10, 214, 20);
		panel_5.add(campocodigo);
		campocodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("ID proveedor:");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(393, 11, 93, 19);
		panel_5.add(lblNombre);
		
		campoidproveedor = new JTextField();
		campoidproveedor.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campoidproveedor.setColumns(10);
		campoidproveedor.setBounds(496, 10, 214, 20);
		panel_5.add(campoidproveedor);
		
		JLabel lblapellido = new JLabel("Nombre:");
		lblapellido.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblapellido.setBounds(60, 41, 59, 19);
		panel_5.add(lblapellido);
		
		camponombre = new JTextField();
		camponombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		camponombre.setColumns(10);
		camponombre.setBounds(129, 40, 214, 20);
		panel_5.add(camponombre);
		
		boton_agregar = new JButton("Agregar producto");
		boton_agregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_agregar.setBackground(Color.LIGHT_GRAY);
		boton_agregar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_agregar.setBounds(323, 73, 155, 23);
		panel_5.add(boton_agregar);
		
		boton_buscar = new JButton("Buscar producto");
		boton_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_buscar.setBackground(Color.LIGHT_GRAY);
		boton_buscar.setBounds(166, 73, 147, 23);
		panel_5.add(boton_buscar);
		boton_buscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		boton_finalizar = new JButton("Finalizar");
		boton_finalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_finalizar.setBackground(Color.LIGHT_GRAY);
		boton_finalizar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_finalizar.setBounds(488, 73, 94, 23);
		panel_5.add(boton_finalizar);
		
		campocantidad = new JTextField();
		campocantidad.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campocantidad.setColumns(10);
		campocantidad.setBounds(496, 41, 214, 20);
		panel_5.add(campocantidad);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCantidad.setBounds(414, 41, 72, 19);
		panel_5.add(lblCantidad);
		
		panellista = new JPanel();
		panellista.setBounds(10, 129, 775, 292);
		panel_4.add(panellista);
		panellista.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panellista.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		tabla_productosproveedor = new JTable();
		tabla_productosproveedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Producto", "Proveedor", "Precio Compra"
			}
		));
		scrollPane_1.setViewportView(tabla_productosproveedor);
		
		JPanel panel_7 = new JPanel();
		panellista.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_7.add(scrollPane, BorderLayout.CENTER);
		
		tabla_productosorden = new JTable();
		tabla_productosorden.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Producto", "Proveedor", "Cantidad", "Precio"
			}
		));
		scrollPane.setViewportView(tabla_productosorden);

	}
}
