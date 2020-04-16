package Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelventa extends JPanel {

	public JLabel montototal;
	public JLabel Descuento;
	public JTextField camporutcliente;
	public JTextField camporutempleado;
	public JTextField campocodigoproducto;
	public JTextField campocantidad;
	public JButton boton_agregarproducto;
	public JButton boton_finalizarcompra;
	public JTable table;
	public DefaultTableModel modelo;
	
	
	public panelventa() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel, BorderLayout.SOUTH);
		
		boton_finalizarcompra = new JButton("Finalizar Venta");
		boton_finalizarcompra.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_finalizarcompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_finalizarcompra.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_finalizarcompra);
		
		JLabel lblNewLabel_2 = new JLabel("                                                                                                                                     ");
		panel.add(lblNewLabel_2);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel.add(lblDescuento);
		
		Descuento = new JLabel("");
		lblDescuento.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel.add(Descuento);
		
		JLabel label = new JLabel("             ");
		panel.add(label);
		
		montototal = new JLabel("Monto Total:");
		montototal.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel.add(montototal);
		
		JLabel montototal = new JLabel("");
		montototal.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel.add(montototal);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("                                                                                       ");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("                                                                                       ");
		panel_1.add(lblNewLabel_1, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblRutCliente = new JLabel("Rut Cliente:");
		lblRutCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblRutCliente.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel_4.add(lblRutCliente);
		
		JLabel lblRutEmpleado = new JLabel("Rut Empleado:");
		lblRutEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRutEmpleado.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel_4.add(lblRutEmpleado);
		
		JLabel lblCodigoProducto = new JLabel("Codigo Producto:");
		lblCodigoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoProducto.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel_4.add(lblCodigoProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel_4.add(lblCantidad);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		camporutcliente = new JTextField();
		camporutcliente.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel_5.add(camporutcliente);
		camporutcliente.setColumns(10);
		
		camporutempleado = new JTextField();
		camporutempleado.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel_5.add(camporutempleado);
		camporutempleado.setColumns(10);
		
		campocodigoproducto = new JTextField();
		campocodigoproducto.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel_5.add(campocodigoproducto);
		campocodigoproducto.setColumns(10);
		
		campocantidad = new JTextField();
		campocantidad.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel_5.add(campocantidad);
		campocantidad.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_7.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_7.add(lblNewLabel_4);
		
		JLabel label_1 = new JLabel("");
		panel_7.add(label_1);
		
		boton_agregarproducto = new JButton("Agregar");
		boton_agregarproducto.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_agregarproducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_agregarproducto.setBackground(Color.LIGHT_GRAY);
		panel_7.add(boton_agregarproducto);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.NORTH);
		
		modelo = new DefaultTableModel();
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(modelo);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("categoria");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");

	}

}
