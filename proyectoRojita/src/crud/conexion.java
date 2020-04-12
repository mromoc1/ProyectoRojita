package crud;

import java.io.*;
import java.sql.*;

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
			st = conn.createStatement();
			
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
}
