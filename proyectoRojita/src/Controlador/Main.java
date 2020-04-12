package Controlador;

import Vista.ventanainicio;
import crud.conexion;

public class Main {
	
	public static void main(String[] args) {
		/*if(BDConnection.conectar() == null) {
			System.out.println("Error en la conexion");
		}*/
		ventanainicio ventana = new ventanainicio();
		
		controlador_ventanainicio controlador = new controlador_ventanainicio(ventana);
		controlador.iniciarventana();
	}
	
	
}
