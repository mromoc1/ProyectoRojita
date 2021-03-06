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

public class panelinformacionsueldo extends JFrame {
	public JButton boton_buscar;
	public JTextField campostock;
	
	
	public JPanel panellista;
	public JTable table;
	public DefaultTableModel modelo;
	/**
	 * Create the panel.
	 */
	public panelinformacionsueldo() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(219, 11, 345, 48);
		panel.add(panel_3);
		
		JLabel lblInventario = new JLabel("Sueldo Empleados");
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
		
		JLabel lblNombre = new JLabel("Mes:");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(431, 11, 31, 23);
		panel_5.add(lblNombre);
		
		campostock = new JTextField();
		campostock.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campostock.setColumns(10);
		campostock.setBounds(472, 12, 56, 20);
		panel_5.add(campostock);
		
		boton_buscar = new JButton("Buscar");
		boton_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_buscar.setBackground(Color.LIGHT_GRAY);
		boton_buscar.setBounds(538, 11, 102, 23);
		panel_5.add(boton_buscar);
		boton_buscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel lblBuscarRegistroMensual = new JLabel("Buscar registro mensual indicando el mes");
		lblBuscarRegistroMensual.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblBuscarRegistroMensual.setBounds(122, 11, 289, 23);
		panel_5.add(lblBuscarRegistroMensual);

		
		panellista = new JPanel();
		panellista.setBounds(10, 66, 775, 359);
		panel_4.add(panellista);
		panellista.setLayout(new BorderLayout(0, 0));
		
		
		modelo = new DefaultTableModel();
		JScrollPane scrollPane = new JScrollPane();
		panellista.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(modelo);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		modelo.addColumn("Rut");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Fecha");
		modelo.addColumn("Sueldo");
		
		
		
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
}
