package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Vista.paneladministrarproductosproveedor;
import crud.conexion;

public class controlador_paneladministrarproductosproveedor implements ActionListener{
	paneladministrarproductosproveedor panel;
	
	public controlador_paneladministrarproductosproveedor(paneladministrarproductosproveedor panel) {
		this.panel=panel;
		
		try {
			CargarProductosProveedor();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
		
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.boton_agregar) {
			
			
			try {
				conexion conexion = new conexion();
				conexion.AgregarProductoProveedor(panel.campoidproveedor.getText(), this.panel.campocodigo.getText(), panel.campopreciocompra.getText());
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource() == panel.boton_modificar) {
			
			try {
				conexion conexion = new conexion();
				conexion.ModificarProductoProveedor(panel.campoidproveedor.getText(), this.panel.campocodigo.getText(), panel.campopreciocompra.getText());
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
		}else if(e.getSource() == panel.boton_eliminar) {
			try {
				conexion conexion = new conexion();
				conexion.EliminarProductoProveedor(panel.campoidproveedor.getText(), this.panel.campocodigo.getText());
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == panel.boton_buscar) {
			try {
				CargarProductosProveedorBuscado(this.panel.campocodigo.getText());
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void CargarProductosProveedor() throws ClassNotFoundException, SQLException, IOException {
		
		conexion cone = new conexion();
		ResultSet tabla = cone.rs_MostrarProductosProveedor();
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
	
	public void CargarProductosProveedorBuscado(String idproducto) throws ClassNotFoundException, SQLException, IOException {
		conexion cone = new conexion();
		ResultSet tabla = cone.rs_MostrarProductosProveedorBuscado(idproducto);
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
