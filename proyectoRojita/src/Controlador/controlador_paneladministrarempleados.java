/*package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.paneladministrarempleados;
import Vista.paneladministrarregistromensual;

public class controlador_paneladministrarempleados implements ActionListener{
	paneladministrarempleados panel;
	
	public controlador_paneladministrarempleados(paneladministrarempleados panel) {
		this.panel=panel;
		
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
		this.panel.boton_verregistromensual.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.panel.boton_verregistromensual) {
			paneladministrarregistromensual panel = new paneladministrarregistromensual();
			controlador_paneladministrarregistromensual controlador = new controlador_paneladministrarregistromensual(panel);
			
			this.panel.removeAll();
			this.panel.add(panel,BorderLayout.CENTER);
			this.panel.revalidate();
			this.panel.repaint();
			
			
			
		}
		
	}

}*/
package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import Vista.paneladministrarempleados;
import Vista.paneladministrarregistromensual;
import javax.swing.JOptionPane;

import crud.conexion;

public class controlador_paneladministrarempleados implements ActionListener{
	
	paneladministrarempleados panel;
	
	
	
	public controlador_paneladministrarempleados(paneladministrarempleados panel) {
		

		this.panel=panel;
		this.panel.boton_agregar.addActionListener(this);
		this.panel.boton_buscar.addActionListener(this);
		this.panel.boton_eliminar.addActionListener(this);
		this.panel.boton_modificar.addActionListener(this);
		this.panel.boton_verregistromensual.addActionListener(this);
	//	panelopciones opcion = new panelopciones();
		//this.opcion = opcion;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == panel.boton_verregistromensual) {
			
			paneladministrarregistromensual panel = new paneladministrarregistromensual();
			controlador_paneladministrarregistromensual controlador = new controlador_paneladministrarregistromensual(panel);
			
			this.panel.removeAll();			
			this.panel.add(panel,BorderLayout.CENTER);
			this.panel.revalidate();
			this.panel.repaint();
		}
	/*
		if(e.getSource() == panel.boton_opciones) {
		//panelopciones opcion = new panelopciones();
			panelopciones opcion = new panelopciones();
			controlador_panelopciones controlador = new controlador_panelopciones(opcion);
			
			this.panel.removeAll();
			this.panel.add(opcion,BorderLayout.CENTER);
			this.panel.revalidate();
			this.panel.repaint();		
			
		}*/
		
	}
	public void agregaEmpleado() throws ClassNotFoundException, SQLException, IOException{
	
		try {
		conexion conn = new conexion();
		String query = " insert into Empleado (idEmpleado, nombre, apellido, tipo_de_trabajo)"
		                 + " values (?, ?, ?, ?)";
	    PreparedStatement preparedStmt = conn.conn().prepareStatement(query);
	    preparedStmt.setInt(1,Integer.valueOf(panel.camporut.getText()));
	    preparedStmt.setString(2, panel.camponombre.getText());
	    preparedStmt.setString(3, panel.campoapellido.getText());
	    preparedStmt.setString(4, panel.campocargo.getText());

	      // Ejecuta el query
	    preparedStmt.execute();
	    conn.close();
	    
	    agregaTelefono();
	     
	    JOptionPane.showMessageDialog(null, "Se ha ingresado correctamente al nuevo empleado");
		}

		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo ingresar un nuevo empleado");
		}
	}
	public void agregaTelefono() throws ClassNotFoundException, SQLException, IOException{
		try {
			conexion conn = new conexion();
			String query = " insert into Telefono_Empleado (idEmpleado, telefonos)"
			                 + " values (?, ?)";
		    PreparedStatement preparedStmt = conn.conn().prepareStatement(query);
		    preparedStmt.setInt(1,Integer.valueOf(panel.camporut.getText()));
		    preparedStmt.setString(2, panel.campotelefono.getText());

		      // Ejecuta el query
		    preparedStmt.execute();
		    conn.close();
			}

			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "No se pudo ingresar el telefono");
			}
		
	}
	public void buscaEmpleado() throws ClassNotFoundException, SQLException, IOException{
		conexion conn = new conexion();
		String query = " select * from Empleado where rutEmpleado ="+String.valueOf(panel.camporut.getText());

	      // Ejecuta el query
	  /*  ResultSet tabla = conn.query(query);
	    if(tabla != null) {
			while(tabla.next()){
				Object [] fila = new Object[5];
				 for (int i=0;i<=4;i++) {
					 
					 fila[i] = tabla.getObject(i+1);
				 }
				 // ACA HAY QUE INCORPORAR TELEFONOS fila[4] = panel.campocantidad.getText();
				 panel.modelo.addRow(fila);
	        }
		}else {
			
			JOptionPane.showMessageDialog(null, "Empleado no encontrado");
		}*/
	      
	    conn.close();
	}
	public void modificarEmpleado() throws ClassNotFoundException, SQLException, IOException{
		
		try {
			conexion conn = new conexion();
			PreparedStatement ps = conn.conn().prepareStatement("UPDATE Empleado SET nombre = ?, apellido = ?, cargo_trabajo = ? WHERE idEmpleado = ?");

			// Se coloca los parametros para actualizar
			ps.setString(1,panel.camponombre.getText());
			ps.setString(2,panel.campoapellido.getText());
			ps.setString(3,panel.campocargo.getText());
			ps.setInt(4,Integer.valueOf(panel.camporut.getText()));

			// Se ejecuta
			ps.executeUpdate();
			ps.close();
			modificarEmpleadoTelefono();
		}
		catch (SQLException se){
			    // si no se actualizo
			    throw se;
		}
	}
	public void modificarEmpleadoTelefono() throws ClassNotFoundException, SQLException, IOException{
		
		try {
			conexion conn = new conexion();
			PreparedStatement ps = conn.conn().prepareStatement("UPDATE Telefono_Empleado SET telefonos = ? WHERE idEmpleado = ?");

			// Se coloca los parametros para actualizar
			ps.setString(1,panel.campotelefono.getText());
			ps.setInt(2,Integer.valueOf(panel.camporut.getText()));

			// Se ejecuta
			ps.executeUpdate();
			ps.close();
		}
		catch (SQLException se){
			    // si no se actualizo
			    throw se;
		}
	}
		
	public void eliminarEmpleado() throws ClassNotFoundException, SQLException, IOException{
		
		try {
			conexion conn = new conexion();
	        PreparedStatement pstmt = conn.conn().prepareStatement("DELETE FROM Empleado WHERE id = ?");

	         // Se coloca la clave primaria a elimnar
	        pstmt.setInt(1, Integer.valueOf(panel.camporut.getText()));
	         // execute the delete statement
	        pstmt.executeUpdate();
	        conn.close();
	        eliminarTelefonoEmpleado();
	        } 
		catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void eliminarTelefonoEmpleado() throws ClassNotFoundException, SQLException, IOException{
		
		try {
			conexion conn = new conexion();
	        PreparedStatement pstmt = conn.conn().prepareStatement("DELETE FROM Telefono_Empleado WHERE id = ?");

	         // Se coloca la clave primaria a elimnar
	        pstmt.setInt(1, Integer.valueOf(panel.camporut.getText()));
	         // execute the delete statement
	        pstmt.executeUpdate();
	        conn.close();
	        } 
		catch (SQLException e) {
	            System.out.println(e.getMessage());
	    }
	}

}
