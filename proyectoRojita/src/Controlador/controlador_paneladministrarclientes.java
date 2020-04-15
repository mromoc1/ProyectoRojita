package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.paneladministrarclientes;

public class controlador_paneladministrarclientes implements ActionListener {
	paneladministrarclientes panel;
	
	public controlador_paneladministrarclientes(paneladministrarclientes panel) {
		this.panel=panel;
		
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
