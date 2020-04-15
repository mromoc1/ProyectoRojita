package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.paneladministrarfacturas;
import Vista.panelnuevafactura;

public class controlador_paneladministrarfacturas implements ActionListener{
	paneladministrarfacturas panel;
	
	public controlador_paneladministrarfacturas(paneladministrarfacturas panel){
		this.panel=panel;
		
		this.panel.boton_nuevafactura.addActionListener(this);
		this.panel.boton_cancelarfactura.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.boton_nuevafactura) {
			panelnuevafactura panel = new panelnuevafactura();
			controlador_panelnuevafactura controlador = new controlador_panelnuevafactura(panel);
			
			this.panel.removeAll();
			this.panel.removeAll();
			this.panel.add(panel,BorderLayout.CENTER);
			this.panel.revalidate();
			this.panel.repaint();
			
		}
		
	}
	
}
