package crud;

import java.io.*;
import java.sql.*;

import javax.swing.*;

/**
 * Clase para iniciar y cerrar la coneccion remota con la BD
 * @author juan_
 *
 */
public class conexion {

	String config = "/proyectoRojita/src/crud/config.bin";
	String user = null;
	String pass = null;
	String url = null;
	Connection conn = null;
	Statement st = null;

	/**
	 * Constructor, Recupera informacion de la sesion y
	 * ruta de la BD, junto a las credenciales
	 * @throws IOException
	 */
	public conexion() throws IOException {
		String c = System.getProperty("user.dir")+config;
		FileReader f = new FileReader(c);
		BufferedReader b = new BufferedReader(f);
		url = b.readLine().replaceAll("url:", "");
		user = b.readLine().replaceAll("admin:", "");
		pass = b.readLine().replaceAll("admin_pass:", "");
		b.close();
	}
	
	/**
	 * Genera la conexion con BD rojita
	 * @return
	 */
	public Connection conn() {
		
   		try {
			conn = DriverManager.getConnection(url, user, pass);
			
			System.out.println("La conexion se establecio con exito");
			
		}catch (SQLException e) {
			System.err.println("error: "+e.getMessage());
		}
		
		
		return conn;
	}
	
	/**
	 * Cierra la Conexion con BD rojita
	 * @throws SQLException
	 */
	public void close() throws SQLException  {
		st.close();
		conn.close();
	}
	
	
	
	/**
	 * retorna el producto buscado en el modulo de ventas
	 * @return resultset
	 */
    public ResultSet buscaProducto(String id) throws ClassNotFoundException {

        Connection conData = null;//conn
        Statement stmData; 
        ResultSet rsData = null;
        
        try {

            //Class.forName(driver);
            conData = conn();
            stmData = conData.createStatement();
            
            if(conData != null) {
            	System.out.println("Conectado!!");
            }
            
            rsData = stmData.executeQuery("select * from productos where idproducto ="+id+";");

            conData.close(); //Se cierrab la conexion a la base de datos.
            return rsData;
           
        } catch (SQLException e) {

        	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
            return null;
        }
    }
    
    
    /**
   	 * Inserta los datos a la tabla boleta en la bd
   	 * @param id_boleta, id_cliente, id_empleado, id_beneficio, monto_total.
   	 */
       public void insertaBoltea(String id, String id_cliente, String id_empleado, String id_beneficio, String total) throws ClassNotFoundException {

           Connection conData = null;//conn
           Statement stmData; 
           
           try {

               conData = conn();
               stmData = conData.createStatement();
               
               if(conData != null) {
               	System.out.println("Conectado!!");
               }
               
               PreparedStatement stmt = conData.prepareStatement("insert into boleta (idboleta,idcliente,idempleado,idbeneficios,fecha,total) values(?,?,?,?,?,?)"); 
               stmt.setInt(1, Integer.parseInt(id));
               stmt.setInt(2, Integer.parseInt(id_cliente));
               stmt.setInt(3, Integer.parseInt(id_empleado));
               stmt.setInt(4, Integer.parseInt(id_beneficio));
               stmt.setDate(5, getCurrentDate()); 
               stmt.setInt(6, Integer.parseInt(total));
               
               stmt.executeUpdate();

               conData.close(); //Se cierrab la conexion a la base de datos.
               JOptionPane.showMessageDialog(null, "Compra realizada con exito! ");
               
           } catch (SQLException e) {

               JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
               
           }
       }
	
	
	
       /**
   	 * Inserta los datos en la tabla carro de la bd
   	 * @param id_boleta, id_producto, cantidad.
   	 */
       public void insertaCarro(String id_boleta, String id_producto, String cantidad) throws ClassNotFoundException {
       	
       	 Connection conData = null;//conn
            Statement stmData; 
            
            try {

                conData = conn();
                stmData = conData.createStatement();
                
                if(conData != null) {
                	System.out.println("Conectado!!");
                }
                stmData.executeUpdate("insert into carro (idboleta,idproducto,cantidad) values("+id_boleta+","+id_producto+","+cantidad+")");
                
                conData.close(); //Se cierrab la conexion a la base de datos.
                           
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                
            }
       }
	
       
       /**
   	 * modifica el stock de los productos a corde a la cantidad adquirida por un cliente
   	 * @param id_producto, cantidad
   	 */
       public void modificarStockProductos(String id_producto, String cantidad) throws ClassNotFoundException {
       	
       	Connection conData = null;//conn
           Statement stmData; 
           
           try {

               
               conData = conn();
               stmData = conData.createStatement();
               
               if(conData != null) {
               	System.out.println("Conectado!!");
               }
               stmData.executeUpdate("update productos set stock=stock"+"-"+cantidad+"where idproducto="+id_producto);
               
               conData.close(); //Se cierrab la conexion a la base de datos.
                          
           } catch (SQLException e) {

               JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
               
           }
       	
       }
       
       /**
   	 * obtiene la fecha actual
   	 * @return fecha actual
   	 */
       private static java.sql.Date getCurrentDate() {
   	    java.util.Date today = new java.util.Date();
   	    return new java.sql.Date(today.getTime());
   	}
       
  
       public ResultSet MostrarProductos() throws ClassNotFoundException {

           Connection conData = null;//conn
           Statement stmData; 
           ResultSet rsData = null;
           
           try {

               conData = conn();
               stmData = conData.createStatement();
               
               rsData = stmData.executeQuery("select * from productos order by nombre");

               conData.close(); //Se cierrab la conexion a la base de datos.
               return rsData;
              
           } catch (SQLException e) {

           	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
               return null;
           }
       }
       
       public ResultSet rs_buscarproducto(String id) throws ClassNotFoundException {

           Connection conData = null;
           Statement stmData; 
           ResultSet rsData = null;
           
           try {

               conData = conn();
               stmData = conData.createStatement();
               
               rsData = stmData.executeQuery("select * from productos where idproducto = "+id);

               conData.close();
               return rsData;
              
           } catch (SQLException e) {

           	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
               return null;
           }
       }
       
       public ResultSet rs_MostrarClientes() throws ClassNotFoundException {

           Connection conData = null;//conn
           Statement stmData; 
           ResultSet rsData = null;
           
           try {

               conData = conn();
               stmData = conData.createStatement();
               
               rsData = stmData.executeQuery("select C.idcliente, C.nombre, C.apellido, T.telefonos from cliente as C, telefono_cliente as T where C.idcliente = T.idcliente order by C.nombre");

               conData.close(); //Se cierrab la conexion a la base de datos.
               return rsData;
              
           } catch (SQLException e) {

           	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
               return null;
           }
       }
       
       public ResultSet rs_BuscarCliente(String rut) throws ClassNotFoundException {
           Connection conData = null;
           Statement stmData; 
           ResultSet rsData = null;
           try {
               conData = conn();
               stmData = conData.createStatement();
               rsData = stmData.executeQuery("select C.idcliente, C.nombre, C.apellido, T.telefonos from cliente as C, telefono_cliente as T where C.idcliente = T.idcliente and C.idcliente = "+rut);
               conData.close();
               return rsData;
           } catch (SQLException e) {
           	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
               return null;
           }
       }
	
       public ResultSet rs_MostrarBoletas() throws ClassNotFoundException {
           Connection conData = null;//conn
           Statement stmData; 
           ResultSet rsData = null;
           try {
               conData = conn();
               stmData = conData.createStatement();
               rsData = stmData.executeQuery("select Bo.idboleta, Bo.idcliente, Bo.idempleado, Be.porcentaje, Bo.fecha, total from boleta as Bo, beneficios as Be where Bo.idbeneficios = Be.idbeneficios order by Bo.fecha");
               conData.close(); 
               return rsData;
           } catch (SQLException e) {
           	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
               return null;
           }
       }
	
       public ResultSet rs_BuscarBoleta(String codigoboleta) throws ClassNotFoundException {
           Connection conData = null;
           Statement stmData; 
           ResultSet rsData = null;
           try {
               conData = conn();
               stmData = conData.createStatement();
               rsData = stmData.executeQuery("select Bo.idboleta, Bo.idcliente, Bo.idempleado, Be.porcentaje, Bo.fecha, total from boleta as Bo, beneficios as Be where Bo.idbeneficios = Be.idbeneficios and Bo.idboleta = "+codigoboleta);
               conData.close();
               return rsData;
           } catch (SQLException e) {
           	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
               return null;
           }
       }
	
       
	
       /* modifica el stock de los productos a corde a la cantidad adquirida por un cliente
     	 * @param id_producto, cantidad
     	 */
         public void insertaRD(String id_registro, String id_empleado, String fecha, String hora_ingreso, String hora_salida) throws ClassNotFoundException {
         	
         	Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 
                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 stmData.executeUpdate("insert into registro_diario (idregistroempleado, idempleado, dia, hora_ingreso, hora_salida) values ("+id_registro+","+id_empleado+",'"+fecha+"','"+hora_ingreso+"','"+hora_salida+"')");
                 
                 conData.close(); //Se cierrab la conexion a la base de datos.
                            
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         	
         }
         
         
         
         
         /**
     	 * Retorna un resulset con las las venstas realizadas por meses
     	 * @return resultset
     	 */
         public ResultSet mustraVentasPorMes(String id) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             ResultSet rsData = null;
             
             try {

                 //Class.forName(driver);
                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 rsData = stmData.executeQuery("SELECT date_trunc('MONTH', b.fecha) as mes, SUM(total) as total FROM boleta as b GROUP BY date_trunc('MONTH', b.fecha);");

                 conData.close(); //Se cierrab la conexion a la base de datos.
                 return rsData;
                
             } catch (SQLException e) {

             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
         
         
         public ResultSet mustraVentasProductosPorMes(String id) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             ResultSet rsData = null;
             
             try {

                 //Class.forName(driver);
                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 rsData = stmData.executeQuery("Select date_trunc('MONTH', b.fecha) as mes, SUM(total) as total FROM boleta as b, productos as p, carro as c WHERE  b.idboleta = c.idboleta AND c.idproducto = p.idproducto AND p.idproducto ="+id+" GROUP BY date_trunc('MONTH', b.fecha)");

                 conData.close(); //Se cierrab la conexion a la base de datos.
                 return rsData;
                
             } catch (SQLException e) {

             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
 
	
}
