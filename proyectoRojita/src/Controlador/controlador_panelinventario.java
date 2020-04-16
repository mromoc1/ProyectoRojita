package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Vista.panelinventario;
import crud.conexion;

public class controlador_panelinventario implements ActionListener {
	
	panelinventario panel;
	
	public controlador_panelinventario(panelinventario panel) throws ClassNotFoundException, SQLException, IOException {
		this.panel = panel;
		
		CargarProductos();
		
		this.panel.campostock.setEditable(false);
		this.panel.camponombre.setEditable(false);
		this.panel.campoprecio.setEditable(false);
		this.panel.boton_buscar.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.panel.boton_buscar) {
			try {
				LlenarCampos();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void CargarProductos() throws ClassNotFoundException, SQLException, IOException {
		
		conexion cone = new conexion();
		ResultSet tabla = cone.rs_MostrarProductos();
		if(tabla != null) {
			
			while(tabla.next()){
				Object [] fila = new Object[5]; //arreglo que almacena cada columna de la tabla productos.
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
		ResultSet rs = cone.rs_buscarproducto(this.panel.campocodigo.getText());
		if(rs != null) {
			while(rs.next()){
				panel.camponombre.setText(rs.getString(2));
				panel.campoprecio.setText(rs.getString(4));
				panel.campostock.setText(rs.getString(5));
	        }
		}else {
			
			JOptionPane.showMessageDialog(null, "Producto no encontrado");
		}
	}

}
