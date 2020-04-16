package crud;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;





/**
 * Clase para iniciar y cerrar la coneccion remota con la BD
 * @author juan_
 *
 */
public class conexion {

	String config = "/src/crud/config.bin";
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
		url = "jdbc:postgresql://10.4.3.195:5432/rojita";
		user = "rojita_dev";
		pass = "okL56g12";

	}
	
	/**
	 * Genera la conexion con BD rojita
	 * @return
	 */
	public Connection conn() {
		
   		try {
			conn = DriverManager.getConnection(url, user, pass);
			st = conn.createStatement();
			
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
                 
                 rsData = stmData.executeQuery("SELECT date_trunc('MONTH', b.fecha) as mes, SUM(total) as total FROM boleta as b GROUP BY date_trunc('MONTH', b.fecha) ORDER BY mes;");

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
                 
                 rsData = stmData.executeQuery("Select date_trunc('MONTH', b.fecha) as mes, SUM(total) as total FROM boleta as b, productos as p, carro as c WHERE  b.idboleta = c.idboleta AND c.idproducto = p.idproducto AND p.idproducto ="+id+" GROUP BY date_trunc('MONTH', b.fecha) ORDER BY mes");

                 conData.close(); //Se cierrab la conexion a la base de datos.
                 return rsData;
                
             } catch (SQLException e) {

             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
         
         /*
          * 
          * CONTROLADOR_PANELPRODUCTOS
          * 
          * */
         
         public ResultSet rs_MostrarProductos() throws ClassNotFoundException {

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
         
         /*
          * 
          * CONTROLADOR_PANELCLIENTES
          * 
          * */
         
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
         
         /*
          * 
          * CONTROLADOR_PANELADMINISTRARPROVEEDORES
          * 
          * */
         public ResultSet rs_MostrarProveedores() throws ClassNotFoundException {
             Connection conData = null;//conn
             Statement stmData; 
             ResultSet rsData = null;
             try {
                 conData = conn();
                 stmData = conData.createStatement();
                 rsData = stmData.executeQuery("select * from proveedor");
                 conData.close(); 
                 return rsData;
             } catch (SQLException e) {
             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
         
         
         public ResultSet rs_buscarproveedor(String idproveedor) throws ClassNotFoundException {
             Connection conData = null;
             Statement stmData; 
             ResultSet rsData = null;
             try {
                 conData = conn();
                 stmData = conData.createStatement();
                 rsData = stmData.executeQuery("select nombre from proveedor where idproveedor = "+idproveedor);
                 conData.close();
                 return rsData;
             } catch (SQLException e) {
             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
         
         public void AgregarProveedor(String idproveedor, String nombreproveedor) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 PreparedStatement stmt = conData.prepareStatement("insert into proveedor (idproveedor,nombre) values(?,?)"); 
                 stmt.setInt(1, Integer.parseInt(idproveedor));
                 stmt.setString(2, nombreproveedor);
                 
                 stmt.executeUpdate();

                 conData.close();
                 
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         }
         
         public void EliminarProveedor(String idproveedor) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 PreparedStatement stmt = conData.prepareStatement("delete from proveedor where idproveedor ="+idproveedor); 
                 PreparedStatement stmt2 = conData.prepareStatement("delete from productos_proveedor where idproveedor ="+idproveedor); 
                 JOptionPane.showMessageDialog(null, "Proveedor Eliminado correctamente");
                 stmt.executeUpdate();
                 stmt2.executeUpdate();

                 conData.close();
                 
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         }
         
         public void ModificarProveedor(String idproveedor, String nombre) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 PreparedStatement stmt = conData.prepareStatement("update proveedor set nombre = ? where idproveedor = ?"); 
                 stmt.setString(1, nombre);
                 stmt.setInt(2, Integer.parseInt(idproveedor));
                 
                 stmt.executeUpdate();

                 conData.close();
                 
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         }
  	
         /*
          * 
          * CONTROLADOR_PANELADMINISTRARPRODUCTOSPROVEEDOR
          * 
          * */
         
         
         public ResultSet rs_MostrarProductosProveedor() throws ClassNotFoundException {
             Connection conData = null;//conn
             Statement stmData; 
             ResultSet rsData = null;
             try {
                 conData = conn();
                 stmData = conData.createStatement();
                 rsData = stmData.executeQuery("select  prov.idproveedor, prov.nombre, prod.idproducto, prod.nombre, pp.precio_compra\r\n" + 
                 		"from productos_proveedor as pp,\r\n" + 
                 		"productos as prod,\r\n" + 
                 		"proveedor as prov\r\n" + 
                 		"where\r\n" + 
                 		"prod.idproducto = pp.idproducto and\r\n" + 
                 		"prov.idproveedor = pp.idproveedor order by prod.nombre");
                 conData.close(); 
                 return rsData;
             } catch (SQLException e) {
             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
         
         
         public void AgregarProductoProveedor(String idproveedor, String idproducto, String precio_compra) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 PreparedStatement stmt = conData.prepareStatement("insert into productos_proveedor (idproveedor,idproducto,precio_compra) values(?,?,?)"); 
                 stmt.setInt(1, Integer.parseInt(idproveedor));
                 stmt.setLong(2, Long.parseLong(idproducto));
                 stmt.setInt(3, Integer.parseInt(precio_compra));
                 
                 stmt.executeUpdate();

                 conData.close();
                 
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         }
  	
         public void ModificarProductoProveedor(String idproveedor, String idproducto, String precio_compra) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 PreparedStatement stmt = conData.prepareStatement("update productos set idproducto = ?, precio_compra = ? where idproveedor = ?"); 
                 stmt.setLong(1, Long.parseLong(idproducto));
                 stmt.setInt(2, Integer.parseInt(precio_compra));
                 stmt.setInt(3, Integer.parseInt(idproveedor));
                 
                 stmt.executeUpdate();

                 conData.close();
                 
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         }
         
         public void EliminarProductoProveedor(String idproveedor, String idproducto) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 PreparedStatement stmt = conData.prepareStatement("delete from productos_proveedor where idproducto ="+Long.parseLong(idproducto)+"and idproveedor ="+idproveedor); 
                 JOptionPane.showMessageDialog(null, "Producto Eliminado correctamente");
                 stmt.executeUpdate();

                 conData.close();
                 
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         }
  	
         public ResultSet rs_MostrarProductosProveedorBuscado(String idproducto) throws ClassNotFoundException {
             Connection conData = null;//conn
             Statement stmData; 
             ResultSet rsData = null;
             try {
                 conData = conn();
                 stmData = conData.createStatement();
                 rsData = stmData.executeQuery("select  prov.idproveedor, prov.nombre, prod.idproducto, prod.nombre, pp.precio_compra\r\n" + 
                 		"from productos_proveedor as pp,\r\n" + 
                 		"productos as prod,\r\n" + 
                 		"proveedor as prov\r\n" + 
                 		"where\r\n" + 
                 		"prod.idproducto = pp.idproducto and\r\n" + 
                 		"prov.idproveedor = pp.idproveedor and prod.idproducto = "+Long.parseLong(idproducto)+" order by prod.nombre");
                 conData.close(); 
                 return rsData;
             } catch (SQLException e) {
             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
         
  	
         /*
          * 
          * CONTROLADOR PANEL ADMINISTRAR PRODUCTOS
          * 
          * */
         
         public ResultSet rs_AdministradorBuscarProducto(String codigoproducto) throws ClassNotFoundException {
             Connection conData = null;
             Statement stmData; 
             ResultSet rsData = null;
             try {
                 conData = conn();
                 stmData = conData.createStatement();
                 rsData = stmData.executeQuery("select * from productos where idproducto = "+Long.parseLong(codigoproducto));
                 conData.close();
                 return rsData;
             } catch (SQLException e) {
             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
         
         public void AgregarProducto(String idproducto, String nombre, String categoria, String precio, String stock) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 PreparedStatement stmt = conData.prepareStatement("insert into productos (idproducto,nombre,categoria,precio_venta,stock) values(?,?,?,?,?)"); 
                 stmt.setLong(1, Long.parseLong(idproducto));
                 stmt.setString(2, nombre);
                 stmt.setString(3, categoria);
                 stmt.setInt(4, Integer.parseInt(precio));
                 stmt.setDouble(5, Double.parseDouble(stock));
                 
                 stmt.executeUpdate();

                 conData.close();
                 
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         }
         
         public void EliminarProducto(String idproducto) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 PreparedStatement stmt = conData.prepareStatement("delete from productos where idproducto ="+Long.parseLong(idproducto)); 
                 PreparedStatement stmt2 = conData.prepareStatement("delete from productos_proveedor where idproducto ="+Long.parseLong(idproducto)); 
                 JOptionPane.showMessageDialog(null, "Producto Eliminado correctamente");
                 stmt.executeUpdate();
                 stmt2.executeUpdate();

                 conData.close();
                 
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         }
         
         public void ModificarProducto(String idproducto, String nombre, String categoria, String precio, String stock) throws ClassNotFoundException {

             Connection conData = null;//conn
             Statement stmData; 
             
             try {

                 conData = conn();
                 stmData = conData.createStatement();
                 
                 if(conData != null) {
                 	System.out.println("Conectado!!");
                 }
                 
                 PreparedStatement stmt = conData.prepareStatement("update productos set nombre = ?, categoria = ?, precio_Venta = ?, stock = ?  where idproducto = ?"); 
                 stmt.setString(1, nombre);
                 stmt.setString(2, categoria);
                 stmt.setInt(3, Integer.parseInt(precio));
                 stmt.setDouble(4, Double.parseDouble(stock));
                 stmt.setLong(5, Long.parseLong(idproducto));
                 
                 stmt.executeUpdate();

                 conData.close();
                 
             } catch (SQLException e) {

                 JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 
             }
         }
         
         public ResultSet rs_CargarProductosporAgotar(String stock ) throws ClassNotFoundException {
             Connection conData = null;//conn
             Statement stmData; 
             ResultSet rsData = null;
             try {
                 conData = conn();
                 stmData = conData.createStatement();
              	   rsData = stmData.executeQuery("SELECT DISTINCT Y.codigoproducto, Y.nombreproducto,Y.idproveedor, prov.nombre,prod.stock, Y.preciocompra\r\n" + 
              	   		"FROM (SELECT X.idproducto as codigoproducto, prod.nombre as nombreproducto,pp.idproveedor as idproveedor, X.preciominimo as preciocompra\r\n" + 
              	   		"FROM (SELECT idproducto,MIN(precio_compra) as preciominimo\r\n" + 
              	   		"FROM productos_proveedor\r\n" + 
              	   		"GROUP BY idproducto\r\n" + 
              	   		"ORDER BY idproducto) as X,\r\n" + 
              	   		"productos as prod,\r\n" + 
              	   		"productos_proveedor as pp\r\n" + 
              	   		"WHERE X.idproducto = prod.idproducto\r\n" + 
              	   		"AND X.preciominimo = pp.precio_compra\r\n" + 
              	   		"AND prod.idproducto = pp.idproducto\r\n" + 
              	   		"ORDER BY prod.nombre) as Y,\r\n" + 
              	   		"productos as prod,\r\n" + 
              	   		"proveedor as prov\r\n" + 
              	   		"WHERE Y.codigoproducto = prod.idproducto\r\n" + 
              	   		"AND Y.idproveedor = prov.idproveedor\r\n" + 
              	   		"AND prod.stock <= "+stock+"\r\n" + 
              	   		"ORDER BY Y.nombreproducto;");
                 
                 conData.close(); 
                 return rsData;
             } catch (SQLException e) {
             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
         
         public ResultSet rs_CargarSueldoEmpleado(String mes ) throws ClassNotFoundException {
             Connection conData = null;//conn
             Statement stmData; 
             ResultSet rsData = null;
             String fecha = "";
             try {
            	 
                 conData = conn();
                 stmData = conData.createStatement();
                 if(mes.equals("Enero")||mes.equals("enero")) {
                	 fecha = "2020-01-15";
                	 
                 }else if(mes.equals("Febrero")||mes.equals("febrero")){
                	 fecha = "2020-02-15";
                 }else if(mes.equals("Marzo")||mes.equals("marzo")) {
                	 fecha = "2020-03-15";
                 }
              	   rsData = stmData.executeQuery("SELECT X.idempleado, E.nombre, E.apellido, X.fecha, X.sueldo\r\n" + 
              	   		"FROM (SELECT L.idempleado as idempleado,L.fecha as fecha, SUM((RM.dias_trabajados*SB.base_diaria)+(RM.tiempo_extras*hora_extra)+(L.sueldo_bruto)+(B.monto)) as sueldo\r\n" + 
              	   		"FROM bonos as B,\r\n" + 
              	   		"liquidacion as L,\r\n" + 
              	   		"registro_mensual as RM,\r\n" + 
              	   		"sueldo_base as SB\r\n" + 
              	   		"WHERE B.idbono = L.idbonos\r\n" + 
              	   		"AND RM.idregistro = L.idregistro\r\n" + 
              	   		"AND RM.idempleado = SB.idempleado\r\n" + 
              	   		"GROUP BY L.idempleado, L.fecha\r\n" + 
              	   		"ORDER BY L.idempleado) as X,\r\n" + 
              	   		"empleado as E\r\n" + 
              	   		"WHERE X.idempleado = E.idempleado ");
                 
                 conData.close(); 
                 return rsData;
             } catch (SQLException e) {
             	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                 return null;
             }
         }
         
         
          public ResultSet mustraBeneficiosTotalesPorMes(String id) throws ClassNotFoundException {

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
                  
                  String consulta = "select a.mes, (a.ingresos - a.costo_proveedor - b.sueldos) as beneficios, a.ingresos, (a.costo_proveedor + b.sueldos) as costos from (SELECT a.mes,ingresos,costo_proveedor FROM (SELECT date_trunc('MONTH', b.fecha) as mes, SUM(total) as ingresos FROM boleta as b GROUP BY date_trunc('MONTH', b.fecha) order by mes) as a LEFT JOIN (SELECT date_trunc('Mon', factura.fecha) as mes, sum(productos_proveedor.precio_compra * lista_factura.cantidad_entrega) as costo_proveedor from factura, lista_factura, productos_proveedor where (factura.idfactura = lista_factura.idfactura and productos_proveedor.idProducto = lista_factura.idProducto)  group by date_trunc('Mon',factura.fecha) order by mes) as c ON a.mes = c.mes) as a LEFT JOIN (select date_trunc('Mon',Liquidacion.fecha) as mes,sum(liquidacion.sueldo_bruto) as sueldos from liquidacion group by date_trunc('Mon',liquidacion.fecha) order by mes) as b ON a.mes = b.mes;";
                  rsData = stmData.executeQuery(consulta);

                  conData.close(); //Se cierrab la conexion a la base de datos.
                  return rsData;
                 
              } catch (SQLException e) {

              	JOptionPane.showMessageDialog(null, "Error en la conexion: "+e.getMessage());
                  return null;
              }
          }
         
  	
 
	
}
