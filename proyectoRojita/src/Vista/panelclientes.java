package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelclientes extends JPanel {
	
	public JButton boton_buscar;
	public JTextField camporut;
	public JTextField camponombre;
	public JTextField campoapellido;
	public JTextField campotelefono;
	public JPanel panellista;
	public JTable table;

	public panelclientes() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 980, 0);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(372, 11, 236, 48);
		panel.add(panel_3);
		
		JLabel lblInventario = new JLabel("Clientes");
		panel_3.add(lblInventario);
		lblInventario.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 81, 960, 419);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 11, 940, 71);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblrut = new JLabel("Rut:");
		lblrut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblrut.setBounds(140, 11, 66, 19);
		panel_5.add(lblrut);
		
		camporut = new JTextField();
		camporut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		camporut.setBounds(216, 12, 214, 20);
		panel_5.add(camporut);
		camporut.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(487, 9, 66, 19);
		panel_5.add(lblNombre);
		
		camponombre = new JTextField();
		camponombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		camponombre.setColumns(10);
		camponombre.setBounds(563, 10, 214, 20);
		panel_5.add(camponombre);
		
		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblapellido.setBounds(140, 41, 66, 19);
		panel_5.add(lblapellido);
		
		campoapellido = new JTextField();
		campoapellido.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campoapellido.setColumns(10);
		campoapellido.setBounds(216, 42, 214, 20);
		panel_5.add(campoapellido);
		
		campotelefono = new JTextField();
		campotelefono.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campotelefono.setColumns(10);
		campotelefono.setBounds(563, 40, 214, 20);
		panel_5.add(campotelefono);
		
		JLabel lbltelefono = new JLabel("Telefono:");
		lbltelefono.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lbltelefono.setBounds(487, 39, 66, 19);
		panel_5.add(lbltelefono);
		
		boton_buscar = new JButton("Buscar");
		boton_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_buscar.setBackground(Color.LIGHT_GRAY);
		boton_buscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_buscar.setBounds(817, 39, 89, 23);
		panel_5.add(boton_buscar);
		
		panellista = new JPanel();
		panellista.setBounds(10, 93, 940, 315);
		panel_4.add(panellista);
		panellista.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panellista.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Rut", "Nombre", "Apellido", "Telefono"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

	}

}
