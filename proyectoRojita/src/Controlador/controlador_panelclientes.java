package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Vista.panelclientes;
import crud.conexion;

public class controlador_panelclientes implements ActionListener{
	
	panelclientes panel;
	
	public controlador_panelclientes(panelclientes panel) throws ClassNotFoundException, SQLException, IOException {
		this.panel=panel;

		CargarClientes();
		
		this.panel.camponombre.setEditable(false);
		this.panel.campoapellido.setEditable(false);
		this.panel.campotelefono.setEditable(false);
			
		this.panel.boton_buscar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.boton_buscar) {
			try {
				LlenarCampos();
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public void CargarClientes() throws ClassNotFoundException, SQLException, IOException {	
		conexion cone = new conexion();
		ResultSet tabla = cone.rs_MostrarClientes();
		if(tabla != null) {
			
			while(tabla.next()){
				Object [] fila = new Object[5]; //arreglo que almacena cada columna de la tabla productos.
				 for (int i=0;i<=3;i++) {
					 
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
		ResultSet rs = cone.rs_BuscarCliente(this.panel.camporut.getText());
		if(rs != null) {
			while(rs.next()){
				panel.camponombre.setText(rs.getString(2));
				panel.campoapellido.setText(rs.getString(3));
				panel.campotelefono.setText(rs.getString(4));
	        }
		}else {
			
			JOptionPane.showMessageDialog(null, "Cliente no encontrado");
		}
	}

}
