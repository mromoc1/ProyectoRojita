package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;

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
import javax.swing.SwingConstants;

public class paneladministrarinformaciones extends JPanel {
	public JButton boton_consulta2;
	public JButton boton_consulta3;
	public JButton boton_consulta4;
	public JButton boton_volver;
	public JLabel  label_consulta2;
	public JLabel  label_consulta3;
	public JLabel  label_consulta4;	
	public JTextField campocodigo;
	
	
	public JPanel panellista;
	public JTable tabla_ordenes;
	
	public paneladministrarinformaciones() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrar Informaciones:");
		lblNewLabel.setBounds(234, 11, 388, 38);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 28));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 38, 816, 474);
		add(panel);
		panel.setLayout(null);
		boton_consulta2 = new JButton("Buscar Proveedores");
		boton_consulta2.setBounds(111, 120, 200, 30);
		panel.add(boton_consulta2);
		
				boton_consulta2.setPreferredSize(new Dimension(200, 30));
				label_consulta2 = new JLabel("( Información de los proveedores más baratos para productos con bajo stock)");
				label_consulta2.setBounds(316, 128, 449, 14);
				panel.add(label_consulta2);
				boton_consulta3 = new JButton("Ventas");
				boton_consulta3.setBounds(111, 161, 200, 30);
				panel.add(boton_consulta3);
				boton_consulta3.setPreferredSize(new Dimension(200, 30));
				label_consulta3 = new JLabel("( Información de los ingresos obtenidos para algún determinado producto)");
				label_consulta3.setBounds(316, 169, 449, 14);
				panel.add(label_consulta3);
				boton_consulta4 = new JButton("Beneficios");
				boton_consulta4.setBounds(111, 202, 200, 30);
				panel.add(boton_consulta4);
				boton_consulta4.setPreferredSize(new Dimension(200, 30));
				label_consulta4 = new JLabel("( Información de los beneficios obtenidos en el minimarket La Rojita)");
				label_consulta4.setBounds(316, 210, 449, 14);
				panel.add(label_consulta4);
				
				// BOTON DE VOLVER
				boton_volver = new JButton("Volver");
				boton_volver.setBounds(370, 396, 82, 23);
				panel.add(boton_volver);
	}
}
