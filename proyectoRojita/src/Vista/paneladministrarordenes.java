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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class paneladministrarordenes extends JPanel {

	public JButton boton_buscar;
	public JButton boton_cancelarorden;
	public JButton boton_nuevaorden;
	
	
	public JTextField campocodigo;
	
	
	public JPanel panellista;
	public JTable tabla_ordenes;
	public JTable tabla_productosorden;
	
	public paneladministrarordenes() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(248, 11, 339, 48);
		panel.add(panel_3);
		
		JLabel lblInventario = new JLabel("Administrar Ordenes");
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
		
		JLabel lblrut = new JLabel("ID orden:");
		lblrut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblrut.setBounds(10, 12, 66, 19);
		panel_5.add(lblrut);
		
		campocodigo = new JTextField();
		campocodigo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		campocodigo.setBounds(86, 11, 214, 20);
		panel_5.add(campocodigo);
		campocodigo.setColumns(10);
		
		boton_buscar = new JButton("Ver Orden");
		boton_buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_buscar.setBackground(Color.LIGHT_GRAY);
		boton_buscar.setBounds(310, 11, 128, 23);
		panel_5.add(boton_buscar);
		boton_buscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		boton_cancelarorden = new JButton("Cancelar Orden");
		boton_cancelarorden.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_cancelarorden.setBackground(Color.LIGHT_GRAY);
		boton_cancelarorden.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_cancelarorden.setBounds(448, 11, 156, 23);
		panel_5.add(boton_cancelarorden);
		
		boton_nuevaorden = new JButton("Nueva Orden");
		boton_nuevaorden.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_nuevaorden.setBackground(Color.LIGHT_GRAY);
		boton_nuevaorden.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_nuevaorden.setBounds(614, 11, 139, 23);
		panel_5.add(boton_nuevaorden);
		
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
				"ID ORDEN", "Fecha"
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
				"Codigo", "Producto", "Proveedor", "Cantidad", "Precio"
			}
		));
		scrollPane.setViewportView(tabla_productosorden);

	}
}
