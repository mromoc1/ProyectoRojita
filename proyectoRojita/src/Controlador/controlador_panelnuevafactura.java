package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.panelnuevafactura;

public class controlador_panelnuevafactura implements ActionListener {
	panelnuevafactura panel;

	public controlador_panelnuevafactura(panelnuevafactura panel) {
		this.panel=panel;
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_finalizar.addActionListener(this);
	
	}
	

	public void actionPerformed(ActionEvent e) {
		
	}

}
