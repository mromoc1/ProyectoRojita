package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.paneladministrarempleados;

public class controlador_paneladministrarempleados implements ActionListener{
	paneladministrarempleados panel;
	
	public controlador_paneladministrarempleados(paneladministrarempleados panel) {
		this.panel=panel;
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		
	}

}
