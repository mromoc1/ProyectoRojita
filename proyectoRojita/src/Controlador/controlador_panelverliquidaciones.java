package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.panelverliquidaciones;

public class controlador_panelverliquidaciones implements ActionListener {
	panelverliquidaciones panel;
	
	public controlador_panelverliquidaciones(panelverliquidaciones panel) {
		this.panel = panel;
		
		this.panel.boton_buscar.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		
	}

}
