package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class panelnuevafactura extends JPanel {
	public JButton boton_agregar;
	public JButton boton_finalizar;
	
	
	public JTextField campoidorden;
	public JTextField campoidproveedor;
	public JTextField campocodigo;
	public JTextField campocantidad;
	
	
	public JPanel panellista;
	public JTable tabla_productosorden;

	
	public panelnuevafactura() {

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(286, 11, 236, 48);
		panel.add(panel_3);
		
		JLabel lblInventario = new JLabel("Nueva Factura");
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
		
		JLabel lblrut = new JLabel("ID orden:");
		lblrut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblrut.setBounds(63, 11, 66, 19);
		panel_5.add(lblrut);
		
		campoidorden = new JTextField();
		campoidorden.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campoidorden.setBounds(129, 10, 214, 20);
		panel_5.add(campoidorden);
		campoidorden.setColumns(10);
		
		JLabel lblNombre = new JLabel("ID proveedor:");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(393, 11, 93, 19);
		panel_5.add(lblNombre);
		
		campoidproveedor = new JTextField();
		campoidproveedor.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campoidproveedor.setColumns(10);
		campoidproveedor.setBounds(496, 10, 214, 20);
		panel_5.add(campoidproveedor);
		
		JLabel lblapellido = new JLabel("Codigo");
		lblapellido.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblapellido.setBounds(60, 41, 59, 19);
		panel_5.add(lblapellido);
		
		campocodigo = new JTextField();
		campocodigo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campocodigo.setColumns(10);
		campocodigo.setBounds(129, 40, 214, 20);
		panel_5.add(campocodigo);
		
		boton_agregar = new JButton("Agregar producto");
		boton_agregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_agregar.setBackground(Color.LIGHT_GRAY);
		boton_agregar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_agregar.setBounds(240, 73, 155, 23);
		panel_5.add(boton_agregar);
		
		boton_finalizar = new JButton("Finalizar");
		boton_finalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_finalizar.setBackground(Color.LIGHT_GRAY);
		boton_finalizar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_finalizar.setBounds(405, 73, 94, 23);
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
		panellista.setLayout(new BorderLayout(0, 0));
		
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
				"Codigo", "Nombre", "ID proveedor", "Cantidad", "Precio"
			}
		));
		scrollPane.setViewportView(tabla_productosorden);

	}

}
