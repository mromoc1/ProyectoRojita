package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Vista.panelinformacionsueldo;
import crud.conexion;

public class controlador_panelinformacionsueldo implements ActionListener {
	panelinformacionsueldo panel;
	
	public controlador_panelinformacionsueldo(panelinformacionsueldo panel) {
		this.panel = panel;
		
		this.panel.boton_buscar.addActionListener(this);
	}

	public void iniciarventana() {
		panel.setTitle("Ventana Informacion");
		panel.setSize(825, 545);
		panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel.setLocationRelativeTo(null);
		panel.setVisible(true);
		
	}	
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.boton_buscar) {
			try {
				panel.modelo.setRowCount(0);
				CargarSueldoEmpleadoPorMes(this.panel.campostock.getText());
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void CargarSueldoEmpleadoPorMes(String mes) throws ClassNotFoundException, SQLException, IOException {
		conexion cone = new conexion();
		ResultSet tabla = cone.rs_CargarSueldoEmpleado(mes);
		if(tabla != null) {
			
			while(tabla.next()){
				Object [] fila = new Object[5];
				 for (int i=0;i<=4;i++) {
					 
					 fila[i] = tabla.getObject(i+1);
				 }
				 panel.modelo.addRow(fila);
	        }
		}else {
			
			JOptionPane.showMessageDialog(null, "Producto no encontrado");
		}
	 }

}
