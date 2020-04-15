package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.paneladministrarregistromensual;

public class controlador_paneladministrarregistromensual implements ActionListener{
	paneladministrarregistromensual panel ;
	
	public controlador_paneladministrarregistromensual(paneladministrarregistromensual panel) {
		this.panel = panel;
		
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_pagar.addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		
	}

}
