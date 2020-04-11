package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.panelinventario;

public class controlador_panelinventario implements ActionListener {
	
	panelinventario panel;
	
	public controlador_panelinventario(panelinventario panel) {
		this.panel = panel;
		
		this.panel.boton_buscar.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.panel.boton_buscar) {
			
		}
	}

}
