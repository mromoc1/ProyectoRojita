package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;

public class ventanaempleados extends JFrame {

	
	public JButton boton_anotaringreso;
	public JButton boton_anotarsalida;
	public JButton boton_nuevaventa;
	public JButton boton_mostrarinventario;
	public JButton boton_vercliente;
	public JButton boton_verboletas;
	public JButton boton_volver;
	
	public JPanel panelcambio;
	
	public ventanaempleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		boton_anotaringreso = new JButton("Registrar Ingreso");
		boton_anotaringreso.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_anotaringreso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_anotaringreso.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_anotaringreso);
		
		boton_anotarsalida = new JButton("Registrar Salida");
		boton_anotarsalida.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_anotarsalida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_anotarsalida.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_anotarsalida);
		
		boton_nuevaventa = new JButton("Nueva Venta");
		boton_nuevaventa.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_nuevaventa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_nuevaventa.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_nuevaventa);
		
		boton_mostrarinventario = new JButton("Mostrar Inventario");
		boton_mostrarinventario.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_mostrarinventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_mostrarinventario.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_mostrarinventario);
		
		boton_vercliente = new JButton("Mostrar Clientes");
		boton_vercliente.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_vercliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_vercliente.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_vercliente);
		
		boton_verboletas = new JButton("Mostrar Boletas");
		boton_verboletas.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_verboletas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_verboletas.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_verboletas);
		
		boton_volver = new JButton("VOLVER");
		boton_volver.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_volver.setBackground(Color.LIGHT_GRAY);
		panel.add(boton_volver);
		
		panelcambio = new JPanel();
		getContentPane().add(panelcambio, BorderLayout.CENTER);
		panelcambio.setLayout(new BorderLayout(0, 0));
		
	}

}
