package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class panelproductosporagotar extends JFrame {
	public JButton boton_buscar;
	public JTextField campostock;
	
	
	public JPanel panellista;
	public JTable table;
	public DefaultTableModel modelo;
	/**
	 * Create the panel.
	 */
	public panelproductosporagotar() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(168, 11, 448, 48);
		panel.add(panel_3);
		
		JLabel lblInventario = new JLabel("Lista de productos por agotar");
		panel_3.add(lblInventario);
		lblInventario.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 64, 793, 436);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 11, 775, 44);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNombre = new JLabel("Stock:");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(478, 11, 41, 23);
		panel_5.add(lblNombre);
		
		campostock = new JTextField();
		campostock.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campostock.setColumns(10);
		campostock.setBounds(529, 12, 56, 20);
		panel_5.add(campostock);
		
		boton_buscar = new JButton("Buscar");
		boton_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_buscar.setBackground(Color.LIGHT_GRAY);
		boton_buscar.setBounds(595, 11, 102, 23);
		panel_5.add(boton_buscar);
		boton_buscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel lblBuscarProductos = new JLabel("Buscar productos con un stock menor o igual al indicado.");
		lblBuscarProductos.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblBuscarProductos.setBounds(70, 11, 398, 23);
		panel_5.add(lblBuscarProductos);

		
		panellista = new JPanel();
		panellista.setBounds(10, 66, 775, 359);
		panel_4.add(panellista);
		panellista.setLayout(new BorderLayout(0, 0));
		
		
		modelo = new DefaultTableModel();
		JScrollPane scrollPane = new JScrollPane();
		panellista.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(modelo);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("ID proveedor");
		modelo.addColumn("Proveedor");
		modelo.addColumn("Stock");
		modelo.addColumn("Precio Compra");
		
		
		
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
}
