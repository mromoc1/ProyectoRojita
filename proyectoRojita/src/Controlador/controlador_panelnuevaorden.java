package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.panelnuevaorden;

public class controlador_panelnuevaorden implements ActionListener {
	panelnuevaorden panel;
	
	public controlador_panelnuevaorden(panelnuevaorden panel) {
		this.panel= panel;
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_finalizar.addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		
	}

}
