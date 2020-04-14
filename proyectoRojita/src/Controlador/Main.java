package Controlador;


import java.io.IOException;

import Vista.ventanainicio;
import crud.conexion;

public class Main {
	
	public static void main(String[] args) throws IOException {
		ventanainicio ventana = new ventanainicio();
		
		controlador_ventanainicio controlador = new controlador_ventanainicio(ventana);
		controlador.iniciarventana();
		
	}
	
	
	
	
}
