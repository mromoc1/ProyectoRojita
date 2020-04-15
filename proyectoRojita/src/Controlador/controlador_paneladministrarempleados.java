package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.paneladministrarempleados;
import Vista.paneladministrarregistromensual;

public class controlador_paneladministrarempleados implements ActionListener{
	paneladministrarempleados panel;
	
	public controlador_paneladministrarempleados(paneladministrarempleados panel) {
		this.panel=panel;
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
		this.panel.boton_verregistromensual.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.panel.boton_verregistromensual) {
			paneladministrarregistromensual panel = new paneladministrarregistromensual();
			controlador_paneladministrarregistromensual controlador = new controlador_paneladministrarregistromensual(panel);
			
			this.panel.removeAll();
			this.panel.removeAll();
			this.panel.add(panel,BorderLayout.CENTER);
			this.panel.revalidate();
			this.panel.repaint();
			
			
			
		}
		
	}

}
