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
			
			
			if(panel.campocantidad.getText().length() != 0 || panel.campocodigoproducto.getText().length() != 0 || panel.camporutcliente.getText().length() != 0 || panel.camporutempleado.getText().length() != 0 ) {
				
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
				//calculaValorTotal();
				//identificaBeneficio();
				panel.montototal.setText("Monto Final: "+montoFinal());
			}else {
				
				JOptionPane.showMessageDialog(null, "Ingrese los campos solicitados");
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
	 * Metodo encargado de insertar los datos en la tabla boleta.
	 * @throws IOException 
	 */
	public void generaBoleta() throws ClassNotFoundException, IOException {
		
		
		String idCliente = panel.camporutcliente.getText();
		String idEmpleado = panel.camporutempleado.getText();
		String boleta = generaIdBoleta();
		conexion cone = new conexion();
		cone.insertaBoltea(boleta, idCliente, idEmpleado,identificaBeneficio(), montoFinal());
		
		generaCarro(boleta);
		actulizaStock();
	}
	
	
	/**
	 * Metodo encargado de insertar los datos en la tabla carro.
	 * @throws IOException 
	 */
	public void generaCarro(String id_boleta) throws ClassNotFoundException, IOException {
		
		for (int i = 0; i < panel.table.getRowCount(); i++) {
			
			conexion conexion = new conexion();
			conexion.insertaCarro(id_boleta, panel.table.getValueAt(i,0).toString(), panel.table.getValueAt(i,4).toString());
		
		}
	}
	
	
	/**
	 * Metodo encargado de actualizar el stock en la tabla productos.
	 * @throws IOException 
	 */
	public void actulizaStock() throws ClassNotFoundException, IOException {
		
		for(int i = 0; i < panel.table.getRowCount(); i++) {
			
			conexion conexion = new conexion();
			conexion.modificarStockProductos(panel.table.getValueAt(i,0).toString(), panel.table.getValueAt(i,4).toString());
		}
	}
	
	
	/**
	 * Genera un id para la boleta.
	 */
	public String generaIdBoleta() {
			
		int idBoleta;
		return  Integer.toString(idBoleta = (int)(1000000 * Math.random()));  
	}
	
	/**
	 * calcula el valor final de la compra sin descuento ya que solo suma el valor de cada producto por su cantidad
	 * @return valor sin descuento.
	 */
	public String calculaValorTotal() {
		
		 int ValorTotalCompra=0;
		 int cantidad = Integer. parseInt(panel.campocantidad.getText()) ;
		 for (int i = 0; i < panel.table.getRowCount(); i++) {
			 
			 int valor =Integer. parseInt( panel.table.getValueAt(i,3).toString());
			 ValorTotalCompra = ValorTotalCompra + valor * cantidad ;
		 }
		 
		 return  Integer.toString(ValorTotalCompra);
	
	}
	
	
	/**
	 * Calcula monto final de la compra con el descuento incluido
	 * @return monto final.
	 */
	public String montoFinal() {
		
		int ValorTotalCompra = Integer.parseInt(calculaValorTotal());
		
		if(identificaBeneficio() == "5") {
			 
			panel.Descuento.setText("0%");
			 return  Integer.toString(ValorTotalCompra);
			 
		 }else if(identificaBeneficio() == "1"){
			 
			 panel.Descuento.setText("5%");
			 return Integer.toString((int) (ValorTotalCompra-(ValorTotalCompra*0.05)));
			 
		 }else if(identificaBeneficio() == "2"){
			 
			 panel.Descuento.setText("10%");
			 return Integer.toString((int) (ValorTotalCompra-(ValorTotalCompra*0.1)));
			 
		 }else if(identificaBeneficio() == "3"){
			 
			 panel.Descuento.setText("15%");
			 return Integer.toString((int) (ValorTotalCompra-(ValorTotalCompra*0.15)));
			 
		 }else if(identificaBeneficio() == "4"){
			 
			 panel.Descuento.setText("20%");
			 return Integer.toString((int) (ValorTotalCompra-(ValorTotalCompra*0.15)));
		 }
		return "0";
	}
	
	
	/**
	 * Identifica el tipo de beneficio
	 * @return tipo de beneficio.
	 */
	public String identificaBeneficio() {
		
		int beneficio =  Integer. parseInt(calculaValorTotal());
		System.out.println("El monto total es: "+beneficio);
		if(beneficio <= 2999) {
			
			return "5";
						
		}else if(beneficio >= 3000 && beneficio <= 5000) {

			return "1";
			
		}else if (beneficio >= 5001 && beneficio <= 10000) {
			
			return "2";
			
		}else if(beneficio >= 10001 && beneficio <= 20000) {

			return "3";
			
		}else if(beneficio >= 20001 && beneficio <= 10000) {

			return "4";
		}
		
		return "-1";
		
	}
	
}

