package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.sql.*;
import Vista.paneladministrarinformaciones;
import Vista.panelnuevaorden;

import crud.conexion;

public class controlador_paneladministrarinformaciones implements ActionListener {
	paneladministrarinformaciones panel;
	
	public controlador_paneladministrarinformaciones(paneladministrarinformaciones panel) {
		this.panel=panel;
		
		this.panel.boton_consulta1.addActionListener(this);
		this.panel.boton_consulta2.addActionListener(this);
		this.panel.boton_consulta3.addActionListener(this);
		this.panel.boton_consulta4.addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.boton_consulta1) {

			String mes = JOptionPane.showInputDialog("Ingrese el mes que desea buscar la planilla de sueldos");
			//Rs = obtener_sueldos(mes);
			//controlador_graficos.verTabla(Rs);
			
			
		}
		if(e.getSource() == panel.boton_consulta2) {
			
			String stock =  JOptionPane.showInputDialog("Ingrese el minimo de stock que debiera tener de algun producto");
			//Rs = obtener_proveedores(stock);
			//controlador_graficos.verTabla(Rs)
			

			
		}
		if(e.getSource() == panel.boton_consulta3) {
			
			
			int opcion = JOptionPane.showOptionDialog(panel.boton_consulta3,
					   "¿Qué búsqueda de venta quiere realizar?", 
					   "Ventas",
					   JOptionPane.YES_NO_CANCEL_OPTION,
					   JOptionPane.QUESTION_MESSAGE,
					   null,    // null para icono por defecto.
					   new Object[] { "Venta Total", "Venta Por Producto", "Cancelar" },   // null para YES, NO y CANCEL
					   "opcion 1");

			if (opcion == 0) {
				try {
					conexion con = new conexion();
					ResultSet Rs = con.mustraVentasPorMes("Ventas Totales");
					controlador_graficos.graficoBarra(Rs, "Ventas Totales");
				}
				catch(Exception el) {
					
					System.out.println("error en la conexion");
					
				}
			} 
			if(opcion == 1) {
				try {
					String idProducto =  JOptionPane.showInputDialog("Ingrese el código del producto", "7801223100019");
					conexion con = new conexion();
					ResultSet Rs = con.mustraVentasProductosPorMes(idProducto);
					controlador_graficos.graficoBarra(Rs, idProducto);
				}
				catch(Exception el) {
					
					System.out.println("error en la conexion");
					
				}
			}
			

			
		}
		if(e.getSource() == panel.boton_consulta4) {
			//String stock =  JOptionPane.showInputDialog("Ingrese el minimo de stock que debiera tener de algun producto");
			//Rs = obtener_proveedores(stock);
			//controlador_graficos.verTabla(Rs)
			try {
				conexion con = new conexion();
				ResultSet Rs = con.mustraBeneficiosTotalesPorMes("Beneficios");
				controlador_graficos.graficoBarra(Rs, "Beneficios");
			}
			catch(Exception er) {
				
			}
			

			
		}
		
	}

}
