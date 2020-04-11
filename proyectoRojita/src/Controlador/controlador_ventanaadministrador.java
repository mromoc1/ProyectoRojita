package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Vista.paneladministrarclientes;
import Vista.ventanaadministrador;
import Vista.ventanainicio;

public class controlador_ventanaadministrador implements ActionListener {
	ventanaadministrador ventana;
	
	public controlador_ventanaadministrador(ventanaadministrador ventana) {
		this.ventana = ventana;
		
		this.ventana.boton_administrarempleados.addActionListener(this);
		this.ventana.boton_administrarordenes.addActionListener(this);
		this.ventana.boton_administrarproductos.addActionListener(this);
		this.ventana.boton_administrarproductosproveedor.addActionListener(this);
		this.ventana.boton_administrarproveedores.addActionListener(this);
		this.ventana.boton_volver.addActionListener(this);
		this.ventana.boton_administrarclientes.addActionListener(this);
		
	}
	
	public void iniciarventana() {
		ventana.setTitle("Ventana Administrador");
		ventana.setSize(1100, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventana.boton_volver) {
			ventanainicio ventanainicio =new ventanainicio();
			controlador_ventanainicio controlador = new controlador_ventanainicio(ventanainicio);
			controlador.iniciarventana();
			this.ventana.dispose();
		}else if(e.getSource() == ventana.boton_administrarempleados) {
			
		}else if(e.getSource() == ventana.boton_administrarordenes) {
			
		}else if(e.getSource() == ventana.boton_administrarproductos) {
			
		}else if(e.getSource() == ventana.boton_administrarproductosproveedor) {
			
		}else if(e.getSource() == ventana.boton_administrarproveedores) {
			
		}else if(e.getSource() == ventana.boton_administrarclientes) {
			paneladministrarclientes panel = new paneladministrarclientes();
			controlador_paneladministrarclientes controlador = new controlador_paneladministrarclientes(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
		}
	}
	
	
	
}
