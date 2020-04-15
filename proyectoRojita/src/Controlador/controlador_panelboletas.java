package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Vista.panelboletas;
import crud.conexion;

public class controlador_panelboletas implements ActionListener{
	panelboletas panel;
	
	public controlador_panelboletas(panelboletas panel) {
		
		this.panel = panel;
		try {
			CargarBoletas();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		this.panel.campocliente.setEditable(false);
		this.panel.campoempleado.setEditable(false);
		this.panel.campodescuento.setEditable(false);
		this.panel.campofecha.setEditable(false);
		this.panel.campototal.setEditable(false);
		
		
		
		this.panel.boton_buscar.addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.panel.boton_buscar) {
			try {
				LlenarCampos();
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public void CargarBoletas() throws ClassNotFoundException, SQLException, IOException {
		
		conexion cone = new conexion();
		ResultSet tabla = cone.rs_MostrarBoletas();
		if(tabla != null) {
			
			while(tabla.next()){
				Object [] fila = new Object[6];
				 for (int i=0;i<=5;i++) {
					 
					 fila[i] = tabla.getObject(i+1);
				 }
				 panel.modelo.addRow(fila);
	        }
		}else {
			
			JOptionPane.showMessageDialog(null, "Producto no encontrado");
		}
	 }
	
	public void LlenarCampos() throws IOException, ClassNotFoundException, SQLException {
		conexion cone = new conexion();
		ResultSet rs = cone.rs_BuscarBoleta(this.panel.campocodigo.getText());
		if(rs != null) {
			while(rs.next()){
				panel.campocliente.setText(rs.getString(2));
				panel.campoempleado.setText(rs.getString(3));
				panel.campodescuento.setText(rs.getString(4));
				panel.campofecha.setText(rs.getString(5));
				panel.campototal.setText(rs.getString(6));
	        }
		}else {
			
			JOptionPane.showMessageDialog(null, "Producto no encontrado");
		}
	}

}
