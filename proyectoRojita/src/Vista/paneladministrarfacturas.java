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

public class paneladministrarfacturas extends JPanel {
	public JButton boton_buscar;
	public JButton boton_cancelarfactura;
	public JButton boton_nuevafactura;
	
	
	public JTextField campocodigo;
	
	
	public JPanel panellista;
	public JTable tabla_ordenes;
	public JTable tabla_productosorden;

	
	public paneladministrarfacturas() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(248, 11, 339, 48);
		panel.add(panel_3);
		
		JLabel lblInventario = new JLabel("Administrar Facturas");
		panel_3.add(lblInventario);
		lblInventario.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 70, 793, 432);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 11, 775, 45);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblrut = new JLabel("ID Factura:");
		lblrut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblrut.setBounds(10, 12, 75, 19);
		panel_5.add(lblrut);
		
		campocodigo = new JTextField();
		campocodigo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campocodigo.setBounds(95, 11, 205, 20);
		panel_5.add(campocodigo);
		campocodigo.setColumns(10);
		
		boton_buscar = new JButton("Ver");
		boton_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_buscar.setBackground(Color.LIGHT_GRAY);
		boton_buscar.setBounds(310, 10, 111, 23);
		panel_5.add(boton_buscar);
		boton_buscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		boton_cancelarfactura = new JButton("Eliminar");
		boton_cancelarfactura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_cancelarfactura.setBackground(Color.LIGHT_GRAY);
		boton_cancelarfactura.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_cancelarfactura.setBounds(431, 10, 128, 23);
		panel_5.add(boton_cancelarfactura);
		
		boton_nuevafactura = new JButton("Nueva Factura");
		boton_nuevafactura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_nuevafactura.setBackground(Color.LIGHT_GRAY);
		boton_nuevafactura.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_nuevafactura.setBounds(569, 10, 151, 23);
		panel_5.add(boton_nuevafactura);
		
		panellista = new JPanel();
		panellista.setBounds(10, 67, 775, 354);
		panel_4.add(panellista);
		panellista.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panellista.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		tabla_ordenes = new JTable();
		tabla_ordenes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID factura", "ID orden", "Fecha"
			}
		));
		scrollPane_1.setViewportView(tabla_ordenes);
		
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
