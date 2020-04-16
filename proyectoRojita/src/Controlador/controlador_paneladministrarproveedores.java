package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Vista.paneladministrarproveedores;
import crud.conexion;

public class controlador_paneladministrarproveedores implements ActionListener{
	paneladministrarproveedores panel;
	
	public controlador_paneladministrarproveedores(paneladministrarproveedores panel) {
		this.panel=panel;
		
		try {
			CargarBoletas();
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
		}if(e.getSource() == panel.boton_agregar) {
			try {
				conexion conexion = new conexion();
				conexion.AgregarProveedor(this.panel.campoid.getText(), this.panel.camponombre.getText());
				
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}if(e.getSource() == panel.boton_eliminar) {
			
			try {
				conexion conexion = new conexion();
				conexion.EliminarProveedor(this.panel.campoid.getText());
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}if(e.getSource() == panel.boton_modificar) {
			
			
			try {
				conexion conexion = new conexion();
				conexion.ModificarProveedor(this.panel.campoid.getText(), this.panel.camponombre.getText());
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
public void CargarBoletas() throws ClassNotFoundException, SQLException, IOException {
		
		conexion cone = new conexion();
		ResultSet tabla = cone.rs_MostrarProveedores();
		if(tabla != null) {
			
			while(tabla.next()){
				Object [] fila = new Object[2];
				 for (int i=0;i<=1;i++) {
					 
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
	ResultSet rs = cone.rs_buscarproveedor(this.panel.campoid.getText());
	if(rs != null) {
		while(rs.next()){
			panel.camponombre.setText(rs.getString(1));
        }
	}else {
		
		JOptionPane.showMessageDialog(null, "Producto no encontrado");
	}
}

}
