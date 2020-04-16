package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Vista.paneladministrarclientes;
import Vista.paneladministrarempleados;
import Vista.paneladministrarfacturas;
import Vista.paneladministrarordenes;
import Vista.paneladministrarproductos;
import Vista.paneladministrarproductosproveedor;
import Vista.paneladministrarproveedores;
import Vista.paneladministrarinformaciones;
import Vista.panelverliquidaciones;
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
		this.ventana.boto_administrarfacturas.addActionListener(this);
		this.ventana.boton_administrarinformaciones.addActionListener(this);
		this.ventana.boton_registroliquidaciones.addActionListener(this);
		
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
			paneladministrarempleados panel = new paneladministrarempleados();
			controlador_paneladministrarempleados controlador = new controlador_paneladministrarempleados(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
			
		}else if(e.getSource() == ventana.boton_administrarordenes) {
			paneladministrarordenes panel = new paneladministrarordenes();
			controlador_paneladministrarordenes controlador = new controlador_paneladministrarordenes(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
		
		}else if(e.getSource() == ventana.boton_administrarproductos) {
			paneladministrarproductos panel = new paneladministrarproductos();
			controlador_paneladministrarproductos controlador = new controlador_paneladministrarproductos(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
			
		}else if(e.getSource() == ventana.boton_administrarproductosproveedor) {
			paneladministrarproductosproveedor panel = new paneladministrarproductosproveedor();
			controlador_paneladministrarproductosproveedor controlador = new controlador_paneladministrarproductosproveedor(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
		}else if(e.getSource() == ventana.boton_administrarproveedores) {
			
			paneladministrarproveedores panel = new paneladministrarproveedores();
			controlador_paneladministrarproveedores controlador = new controlador_paneladministrarproveedores(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
			
		}else if(e.getSource() == ventana.boton_administrarclientes) {
			paneladministrarclientes panel = new paneladministrarclientes();
			controlador_paneladministrarclientes controlador = new controlador_paneladministrarclientes(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
		}else if (e.getSource() == ventana.boto_administrarfacturas){
			paneladministrarfacturas panel = new paneladministrarfacturas();
			controlador_paneladministrarfacturas controlador = new controlador_paneladministrarfacturas(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
			
			
		}else if (e.getSource() == ventana.boton_administrarinformaciones){
			paneladministrarinformaciones panel = new paneladministrarinformaciones();
			System.out.println("FUNCIONA");
			controlador_paneladministrarinformaciones controlador = new controlador_paneladministrarinformaciones(panel);
			System.out.println("PASO");
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
			
			
		}else if(e.getSource() ==this.ventana.boton_registroliquidaciones) {
			panelverliquidaciones panel = new panelverliquidaciones();
			controlador_panelverliquidaciones controlador = new controlador_panelverliquidaciones(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
			
			
		}
	}
	
	
	
}
