package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Vista.ventanaadministrador;

public class controlador_ventanaadministrador implements ActionListener {
	ventanaadministrador ventana;
	
	public controlador_ventanaadministrador(ventanaadministrador ventana) {
		this.ventana = ventana;
		
		
	}
	
	public void iniciarventana() {
		ventana.setTitle("Ventana Administrador");
		ventana.setSize(1100, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
}
