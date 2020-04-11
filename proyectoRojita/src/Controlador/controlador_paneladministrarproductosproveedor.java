package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.paneladministrarproductosproveedor;

public class controlador_paneladministrarproductosproveedor implements ActionListener{
	paneladministrarproductosproveedor panel;
	
	public controlador_paneladministrarproductosproveedor(paneladministrarproductosproveedor panel) {
		this.panel=panel;
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
		
	}
	
	

	public void actionPerformed(ActionEvent e) {
		
	}

}
