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

	public JButton boton_consulta1;
	public JButton boton_consulta2;
	public JButton boton_consulta3;
	public JButton boton_consulta4;
	public JButton boton_volver;
	public JLabel  label_consulta1;
	public JLabel  label_consulta2;
	public JLabel  label_consulta3;
	public JLabel  label_consulta4;	
	public JTextField campocodigo;
	
	
	public JPanel panellista;
	public JTable tabla_ordenes;
	
	public paneladministrarinformaciones() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Administrar Informaciones:");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 28));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		boton_consulta1 = new JButton("Sueldos");
		boton_consulta1.setPreferredSize(new Dimension(200, 30));
		label_consulta1 = new JLabel("( Información de los sueldos de todos los empleados para un determinado mes)");
		
		panel_1.add(boton_consulta1);
		panel_1.add(label_consulta1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		boton_consulta2 = new JButton("Buscar Proveedores");

		boton_consulta2.setPreferredSize(new Dimension(200, 30));
		label_consulta2 = new JLabel("( Información de los proveedores más baratos para productos con bajo stock)");
		panel_2.add(boton_consulta2);
		panel_2.add(label_consulta2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		boton_consulta3 = new JButton("Ventas");
		boton_consulta3.setPreferredSize(new Dimension(200, 30));
		label_consulta3 = new JLabel("( Información de los ingresos obtenidos para algún determinado producto)");
		panel_3.add(boton_consulta3);
		panel_3.add(label_consulta3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		boton_consulta4 = new JButton("Beneficios");
		boton_consulta4.setPreferredSize(new Dimension(200, 30));
		label_consulta4 = new JLabel("( Información de los beneficios obtenidos en el minimarket La Rojita)");
		panel_4.add(boton_consulta4);
		panel_4.add(label_consulta4);
		
		// BOTON DE VOLVER
		boton_volver = new JButton("Volver");
		JPanel panel_volver = new JPanel();
		panel_volver.add(boton_volver,BorderLayout.EAST);
		panel.add(panel_volver,BorderLayout.SOUTH);
	}
}
