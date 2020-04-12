package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ventanaadministrador extends JFrame {
	
	public JButton boton_administrarempleados;
	public JButton boton_administrarproductos;
	public JButton boton_administrarproveedores;
	public JButton boton_administrarordenes;
	public JButton boton_administrarproductosproveedor;
	public JButton boton_volver;
	
	public JPanel panelcambio;
	public JButton boton_administrarclientes;
	public JButton boto_administrarfacturas;

	public ventanaadministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 600);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		boton_administrarempleados = new JButton("Administrar Empleados");
		boton_administrarempleados.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_administrarempleados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_administrarempleados.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_administrarempleados);
		
		boton_administrarclientes = new JButton("Administrar Clientes");
		boton_administrarclientes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_administrarclientes.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_administrarclientes);
		
		boton_administrarproveedores = new JButton("Administrar Proveedores");
		boton_administrarproveedores.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_administrarproveedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_administrarproveedores.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_administrarproveedores);
		
		boton_administrarproductos = new JButton("Administrar Productos");
		boton_administrarproductos.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_administrarproductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_administrarproductos.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_administrarproductos);
		
		boton_administrarproductosproveedor = new JButton("Administrar Productos Proveedor");
		boton_administrarproductosproveedor.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_administrarproductosproveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_administrarproductosproveedor.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_administrarproductosproveedor);
		
		boton_administrarordenes = new JButton("Administrar Ordenes");
		boton_administrarordenes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_administrarordenes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_administrarordenes.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_administrarordenes);
		
		boto_administrarfacturas = new JButton("Administrar Facturas");
		boto_administrarfacturas.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boto_administrarfacturas.setBackground(Color.LIGHT_GRAY);
		panel.add(boto_administrarfacturas);
		
		boton_volver = new JButton("VOLVER");
		boton_volver.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		boton_volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_volver.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_volver);
		
		panelcambio = new JPanel();
		getContentPane().add(panelcambio, BorderLayout.CENTER);
		panelcambio.setLayout(new BorderLayout(0, 0));
	}

}
