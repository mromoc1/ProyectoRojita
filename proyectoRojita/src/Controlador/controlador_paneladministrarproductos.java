package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Vista.paneladministrarproductos;
import crud.conexion;

public class controlador_paneladministrarproductos implements ActionListener{

	paneladministrarproductos panel;
	
	public controlador_paneladministrarproductos(paneladministrarproductos panel) {
		this.panel=panel;
		
		try {
			CargarProductos();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.boton_buscar) {
			try {
				LlenarCampos();
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				e1.printStackTrace();
			}
		}if(e.getSource()== panel.boton_agregar) {
			
			try {
				conexion conexion = new conexion();
				conexion.AgregarProducto(panel.campocodigo.getText(), panel.camponombre.getText(), panel.campocategoria.getText(), panel.campoprecio.getText(), panel.campostock.getText());
				panel.campocodigo.setText("");
				panel.camponombre.setText("");
				panel.campoprecio.setText("");
				panel.campocategoria.setText("");
				panel.campostock.setText("");
				
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}if(e.getSource() == panel.boton_eliminar) {
			
			
			try {
				conexion conexion = new conexion();
				conexion.EliminarProducto(panel.campocodigo.getText());
				
				panel.campocodigo.setText("");
				panel.camponombre.setText("");
				panel.campoprecio.setText("");
				panel.campocategoria.setText("");
				panel.campostock.setText("");
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			
		}if(e.getSource() == panel.boton_modificar) {
			
			try {
				conexion conexion = new conexion();
				conexion.ModificarProducto(panel.campocodigo.getText(), panel.camponombre.getText(), panel.campocategoria.getText(), panel.campoprecio.getText(), panel.campostock.getText());
				panel.campocodigo.setText("");
				panel.camponombre.setText("");
				panel.campoprecio.setText("");
				panel.campocategoria.setText("");
				panel.campostock.setText("");
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public void CargarProductos() throws ClassNotFoundException, SQLException, IOException {
		
		conexion cone = new conexion();
		ResultSet tabla = cone.rs_MostrarProductos();
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
	
	public void LlenarCampos() throws IOException, ClassNotFoundException, SQLException {
		conexion cone = new conexion();
		ResultSet rs = cone.rs_AdministradorBuscarProducto(this.panel.campocodigo.getText());
		if(rs != null) {
			while(rs.next()){
				panel.camponombre.setText(rs.getString(2));
				panel.campoprecio.setText(rs.getString(4));
				panel.campocategoria.setText(rs.getString(3));
				panel.campostock.setText(rs.getString(5));
	        }
		}else {
			
			JOptionPane.showMessageDialog(null, "Producto no encontrado");
		}
	}
	
}
