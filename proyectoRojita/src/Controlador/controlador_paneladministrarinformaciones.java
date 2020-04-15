package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.paneladministrarinformaciones;
import Vista.panelnuevaorden;

public class controlador_paneladministrarinformaciones implements ActionListener {
	paneladministrarinformaciones panel;
	
	public controlador_paneladministrarinformaciones(paneladministrarinformaciones panel) {
		this.panel=panel;
		
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_cancelarorden.addActionListener(this);
		this.panel.boton_nuevaorden.addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.boton_nuevaorden) {
			panelnuevaorden panel = new panelnuevaorden();
			controlador_panelnuevaorden controlador = new controlador_panelnuevaorden(panel);
			
			this.panel.removeAll();
			this.panel.removeAll();
			this.panel.add(panel,BorderLayout.CENTER);
			this.panel.revalidate();
			this.panel.repaint();
			
		}
		
	}

}
