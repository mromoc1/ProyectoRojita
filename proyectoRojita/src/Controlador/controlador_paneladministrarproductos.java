package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Vista.paneladministrarproductos;

public class controlador_paneladministrarproductos implements ActionListener{

	paneladministrarproductos panel;
	
	public controlador_paneladministrarproductos(paneladministrarproductos panel) {
		this.panel=panel;
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
}
