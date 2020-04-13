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

public class panelboletas extends JPanel {

	public JButton boton_buscar;
	public JTextField campocodigo;
	public JTextField campocliente;
	public JTextField campoempleado;
	public JTextField campofecha;
	public JPanel panellista;
	public JTextField campodescuento;
	public JTextField campototal;
	public JTable table;
	
	public panelboletas() {

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
		
		JLabel lblInventario = new JLabel("Boletas");
		panel_3.add(lblInventario);
		lblInventario.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 81, 960, 419);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 11, 940, 102);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblcodigo = new JLabel("Codigo:");
		lblcodigo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblcodigo.setBounds(138, 11, 55, 19);
		panel_5.add(lblcodigo);
		
		campocodigo = new JTextField();
		campocodigo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campocodigo.setBounds(216, 12, 214, 20);
		panel_5.add(campocodigo);
		campocodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Cliente:");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(486, 11, 55, 19);
		panel_5.add(lblNombre);
		
		campocliente = new JTextField();
		campocliente.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campocliente.setColumns(10);
		campocliente.setBounds(563, 10, 214, 20);
		panel_5.add(campocliente);
		
		JLabel lblapellido = new JLabel("Empleado:");
		lblapellido.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblapellido.setBounds(117, 41, 76, 19);
		panel_5.add(lblapellido);
		
		campoempleado = new JTextField();
		campoempleado.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campoempleado.setColumns(10);
		campoempleado.setBounds(216, 42, 214, 20);
		panel_5.add(campoempleado);
		
		campofecha = new JTextField();
		campofecha.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campofecha.setColumns(10);
		campofecha.setBounds(563, 40, 214, 20);
		panel_5.add(campofecha);
		
		JLabel lbltelefono = new JLabel("Fecha:");
		lbltelefono.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lbltelefono.setBounds(493, 39, 48, 19);
		panel_5.add(lbltelefono);
		
		boton_buscar = new JButton("Buscar");
		boton_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_buscar.setBackground(Color.LIGHT_GRAY);
		boton_buscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_buscar.setBounds(816, 71, 89, 23);
		panel_5.add(boton_buscar);
		
		campodescuento = new JTextField();
		campodescuento.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campodescuento.setColumns(10);
		campodescuento.setBounds(216, 72, 214, 20);
		panel_5.add(campodescuento);
		
		JLabel lblTotalCompra = new JLabel("Descuento:");
		lblTotalCompra.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblTotalCompra.setBounds(115, 71, 78, 19);
		panel_5.add(lblTotalCompra);
		
		JLabel lblBeneficio = new JLabel("Total:");
		lblBeneficio.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblBeneficio.setBounds(504, 71, 36, 19);
		panel_5.add(lblBeneficio);
		
		campototal = new JTextField();
		campototal.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campototal.setColumns(10);
		campototal.setBounds(563, 72, 214, 20);
		panel_5.add(campototal);
		
		panellista = new JPanel();
		panellista.setBounds(10, 124, 940, 284);
		panel_4.add(panellista);
		panellista.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panellista.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Codigo", "Nombre", "Categoria", "Cantidad", "Precio Unitario"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
}
