package Controlador;

import Vista.ventanainicio;

public class Main {
	
	public static void main(String[] args) {
		ventanainicio ventana = new ventanainicio();
		
		controlador_ventanainicio controlador = new controlador_ventanainicio(ventana);
		controlador.iniciarventana();
	}
	
	
}
