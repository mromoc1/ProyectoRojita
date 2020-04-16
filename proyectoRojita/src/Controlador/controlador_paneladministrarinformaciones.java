package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vista.paneladministrarinformaciones;
import Vista.panelnuevaorden;

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
			//String stock =  JOptionPane.showInputDialog("Ingrese el minimo de stock que debiera tener de algun producto");
			//Rs = obtener_proveedores(stock);
			//controlador_graficos.verTabla(Rs)

			

			
		}
		if(e.getSource() == panel.boton_consulta4) {
			//String stock =  JOptionPane.showInputDialog("Ingrese el minimo de stock que debiera tener de algun producto");
			//Rs = obtener_proveedores(stock);
			//controlador_graficos.verTabla(Rs)

			

			
		}
		
	}

}
