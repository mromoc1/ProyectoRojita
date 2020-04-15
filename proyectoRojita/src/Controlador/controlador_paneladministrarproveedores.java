package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.paneladministrarproveedores;

public class controlador_paneladministrarproveedores implements ActionListener{
	paneladministrarproveedores panel;
	
	public controlador_paneladministrarproveedores(paneladministrarproveedores panel) {
		this.panel=panel;
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
	}


	public void actionPerformed(ActionEvent arg0) {
		
	}

}
