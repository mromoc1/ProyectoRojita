package Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelinventario extends JPanel {

	public JButton boton_buscar;
	public JTextField campocodigo;
	public JTextField camponombre;
	public JTextField campostock;
	public JTextField campoprecio;
	public JPanel panellista;
	public JTable table;

	
	public panelinventario() {
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
		
		JLabel lblInventario = new JLabel("Inventario");
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
		
		JLabel lblCodigoProducto = new JLabel("Codigo:");
		lblCodigoProducto.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCodigoProducto.setBounds(140, 11, 66, 19);
		panel_5.add(lblCodigoProducto);
		
		campocodigo = new JTextField();
		campocodigo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campocodigo.setBounds(216, 12, 214, 20);
		panel_5.add(campocodigo);
		campocodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(487, 9, 66, 19);
		panel_5.add(lblNombre);
		
		camponombre = new JTextField();
		camponombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		camponombre.setColumns(10);
		camponombre.setBounds(563, 10, 214, 20);
		panel_5.add(camponombre);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblStock.setBounds(140, 41, 66, 19);
		panel_5.add(lblStock);
		
		campostock = new JTextField();
		campostock.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campostock.setColumns(10);
		campostock.setBounds(216, 42, 214, 20);
		panel_5.add(campostock);
		
		campoprecio = new JTextField();
		campoprecio.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campoprecio.setColumns(10);
		campoprecio.setBounds(563, 40, 214, 20);
		panel_5.add(campoprecio);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblPrecio.setBounds(487, 39, 66, 19);
		panel_5.add(lblPrecio);
		
		boton_buscar = new JButton("Buscar");
		boton_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_buscar.setBackground(Color.LIGHT_GRAY);
		boton_buscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_buscar.setBounds(817, 39, 99, 23);
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
					"Codigo", "Nombre", "Categoria", "Stock", "Precio"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

	}
}
