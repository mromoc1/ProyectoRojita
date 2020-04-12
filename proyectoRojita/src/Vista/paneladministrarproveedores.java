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

public class paneladministrarproveedores extends JPanel {
	public JButton boton_buscar;
	public JButton boton_modificar;
	public JButton boton_eliminar;
	public JButton boton_agregar;
	
	
	public JTextField camporut;
	public JTextField camponombre;
	
	
	public JPanel panellista;
	public JTable table;

	public paneladministrarproveedores() {
setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(286, 11, 236, 48);
		panel.add(panel_3);
		
		JLabel lblInventario = new JLabel("Proveedores");
		panel_3.add(lblInventario);
		lblInventario.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 64, 793, 436);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 11, 775, 76);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblrut = new JLabel("ID:");
		lblrut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblrut.setBounds(63, 11, 33, 19);
		panel_5.add(lblrut);
		
		camporut = new JTextField();
		camporut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		camporut.setBounds(129, 10, 214, 20);
		panel_5.add(camporut);
		camporut.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(420, 10, 66, 19);
		panel_5.add(lblNombre);
		
		camponombre = new JTextField();
		camponombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		camponombre.setColumns(10);
		camponombre.setBounds(496, 9, 214, 20);
		panel_5.add(camponombre);
		
		boton_agregar = new JButton("Agregar");
		boton_agregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_agregar.setBackground(Color.LIGHT_GRAY);
		boton_agregar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_agregar.setBounds(168, 41, 102, 23);
		panel_5.add(boton_agregar);
		
		boton_buscar = new JButton("Buscar");
		boton_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_buscar.setBackground(Color.LIGHT_GRAY);
		boton_buscar.setBounds(280, 41, 102, 23);
		panel_5.add(boton_buscar);
		boton_buscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		boton_modificar = new JButton("Modificar");
		boton_modificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_modificar.setBackground(Color.LIGHT_GRAY);
		boton_modificar.setBounds(392, 41, 102, 23);
		panel_5.add(boton_modificar);
		boton_modificar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		boton_eliminar = new JButton("Eliminar");
		boton_eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_eliminar.setBackground(Color.LIGHT_GRAY);
		boton_eliminar.setBounds(504, 41, 102, 23);
		panel_5.add(boton_eliminar);
		boton_eliminar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		panellista = new JPanel();
		panellista.setBounds(10, 98, 775, 327);
		panel_4.add(panellista);
		panellista.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panellista.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Proveedor", "Nombre"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

	}
}
