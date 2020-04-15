package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Vista.ventanaadministrador;
import Vista.ventanaempleados;
import Vista.ventanainicio;

public class controlador_ventanainicio implements ActionListener  {
	
	ventanainicio ventana;
	
	public controlador_ventanainicio(ventanainicio ventana) {
		this.ventana = ventana;
		
		ventana.boton_ingresaradministrador.addActionListener(this);
		ventana.boton_ingresarempleado.addActionListener(this);
	}
	
	public void iniciarventana() {
		ventana.setTitle("Ventana Principal");
		ventana.setSize(355, 350);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventana.boton_ingresaradministrador) {
			ventanaadministrador ventanaadministrador = new ventanaadministrador();
			controlador_ventanaadministrador controlador = new controlador_ventanaadministrador(ventanaadministrador);
			controlador.iniciarventana();
			this.ventana.dispose();
			
			
		}else if(e.getSource() == ventana.boton_ingresarempleado) {
			
			ventanaempleados ventanaempleado = new ventanaempleados();
			controlador_ventanaempleados controlador = new controlador_ventanaempleados(ventanaempleado);
			controlador.iniciarventana();
			this.ventana.dispose();
			
			
		}
	}

	
}
