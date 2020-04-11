package Modelo;
import java.sql.*;
import javax.swing.JOptionPane;

public class BDConnection {	
	
	private static String Controlador = "org.postgresql.Driver";
	private static String Url;
	private static String User;
	private static String Pass;
	
	public static void Inicializarvariables(String contraseña, String nombreusuario) {
		String puerto = "5432";
		Pass = "m9701bFd";
		User = "rojita";
		Url = "jdbc:postgresql://10.4.3.195/rojita";
	}
	
	public static Connection conectar() {
		Connection con = null;
		try {
			Class.forName(Controlador);
			con = DriverManager.getConnection(Url,User,Pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la conexion","Aviso",JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}
}
