package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Vista.panelventa;
import crud.conexion;

public class controlador_panelventa implements ActionListener, KeyListener{
	panelventa panel;

	public controlador_panelventa(panelventa panel) {
		this.panel = panel;
		
		this.panel.boton_agregarproducto.addActionListener(this);
		this.panel.boton_finalizarcompra.addActionListener(this);
		
		this.panel.campocantidad.addKeyListener(this);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.panel.boton_agregarproducto) {
			
			
			try {
				agregaProducto();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		}else if(e.getSource()==this.panel.boton_finalizarcompra) {
			
			try {
				generaBoleta();
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			calculaValorTotal();
		}
		
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER && e.getSource()==panel.campocantidad){
            //hace lo mismo que boton agregar
        }
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	
	/**
	 * Metodo encargado buscar un producto en base a id de este
	 * y lo agrega al jtable.
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public void agregaProducto() throws ClassNotFoundException, SQLException, IOException {
		
		conexion cone = new conexion();
		ResultSet tabla = cone.buscaProducto(panel.campocodigoproducto.getText());
		if(tabla != null) {
			
			while(tabla.next()){
				Object [] fila = new Object[5]; //arreglo que almacena cada columna de la tabla productos.
				 for (int i=0;i<=3;i++) {
					 
					 fila[i] = tabla.getObject(i+1);
				 }
				 fila[4] = panel.campocantidad.getText();
				 panel.modelo.addRow(fila);
	        }
		}else {
			
			JOptionPane.showMessageDialog(null, "Producto no encontrado");
		}
	 }
	
	
	/**
	 * metodo encargado de insertar los datos en la tabla boleta.
	 * @throws IOException 
	 */
	public void generaBoleta() throws ClassNotFoundException, IOException {
		
		
		String idCliente = panel.camporutcliente.getText();
		String idEmpleado = panel.camporutempleado.getText();
		String boleta = generaIdBoleta();
		conexion cone = new conexion();
		cone.insertaBoltea(boleta, idCliente, idEmpleado,"1", calculaValorTotal());
		
		generaCarro(boleta);
		actulizaStock();
	}
	
	
	/**
	 * metodo encargado de insertar los datos en la tabla carro.
	 * @throws IOException 
	 */
	public void generaCarro(String id_boleta) throws ClassNotFoundException, IOException {
		
		for (int i = 0; i < panel.table.getRowCount(); i++) {
			
			conexion conexion = new conexion();
			conexion.insertaCarro(id_boleta, panel.table.getValueAt(i,0).toString(), panel.table.getValueAt(i,4).toString());
		
		}
	}
	
	
	/**
	 * metodo encargado de actualizar el stock en la tabla productos.
	 * @throws IOException 
	 */
	public void actulizaStock() throws ClassNotFoundException, IOException {
		
		for(int i = 0; i < panel.table.getRowCount(); i++) {
			
			conexion conexion = new conexion();
			conexion.modificarStockProductos(panel.table.getValueAt(i,0).toString(), panel.table.getValueAt(i,4).toString());
		}
	}
	
	
	/**
	 * genera un id para la boleta.
	 */
	public String generaIdBoleta() {
			
		int idBoleta;
		return  Integer.toString(idBoleta = (int)(1000000 * Math.random()));  
	}
	
	/**
	 * calcula el valor final de la compra.
	 */
	public String calculaValorTotal() {
		
		 int ValorTotalCompra=0;
		 for (int i = 0; i < panel.table.getRowCount(); i++) {
			 
			 int valor =Integer. parseInt( panel.table.getValueAt(i,3).toString());
			 ValorTotalCompra = ValorTotalCompra + valor ;
		 }
		 
		 return  Integer.toString(ValorTotalCompra);
	
	}
	
}
