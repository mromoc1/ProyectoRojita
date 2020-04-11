package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ventanainicio extends JFrame {
	public JButton boton_ingresarempleado;
	public JButton boton_ingresaradministrador;


	public ventanainicio() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		boton_ingresarempleado = new JButton("Empleado");
		boton_ingresarempleado.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_ingresarempleado.setBounds(73, 75, 193, 62);
		boton_ingresarempleado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_ingresarempleado.setBackground(Color.LIGHT_GRAY);
		panel_1.add(boton_ingresarempleado);
		
		boton_ingresaradministrador = new JButton("Administrador");
		boton_ingresaradministrador.setFont(new Font("Century Gothic", Font.BOLD, 14));
		boton_ingresaradministrador.setBounds(73, 148, 193, 62);
		boton_ingresaradministrador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton_ingresaradministrador.setBackground(Color.LIGHT_GRAY);
		panel_1.add(boton_ingresaradministrador);
		
		JLabel lblSeleccioneQuienIngresa = new JLabel("Ingresar Como");
		lblSeleccioneQuienIngresa.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblSeleccioneQuienIngresa.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblSeleccioneQuienIngresa, BorderLayout.NORTH);
	}
}
