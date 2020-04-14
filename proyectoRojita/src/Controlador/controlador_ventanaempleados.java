package Controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Vista.panelboletas;
import Vista.panelclientes;
import Vista.panelinventario;
import Vista.panelventa;
import Vista.ventanaempleados;
import Vista.ventanainicio;

public class controlador_ventanaempleados implements ActionListener{
	
	ventanaempleados ventana;
	
	public controlador_ventanaempleados(ventanaempleados ventana) {
		this.ventana = ventana;
		
		this.ventana.boton_anotaringreso.addActionListener(this);
		this.ventana.boton_anotarsalida.addActionListener(this);
		this.ventana.boton_mostrarinventario.addActionListener(this);
		this.ventana.boton_nuevaventa.addActionListener(this);
		this.ventana.boton_verboletas.addActionListener(this);
		this.ventana.boton_volver.addActionListener(this);
		this.ventana.boton_vercliente.addActionListener(this);
		
	}
	
	public void iniciarventana() {
		ventana.setTitle("Ventana Empleado");
		ventana.setSize(1160, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventana.boton_anotaringreso) {
			String rutempleado = JOptionPane.showInputDialog(null,"Ingrese su rut para registrar su hora de entrada",JOptionPane.QUESTION_MESSAGE);
			//SI EL RUT NO COINCIDE CON EL DE NINGUN EMPLEADO DEBE REPETIRSE LA PREGUNTA (WHILE)
			
			
		}else if(e.getSource() == ventana.boton_anotarsalida) {
			String rutempleado = JOptionPane.showInputDialog(null,"Ingrese su rut para registrar su hora de salida",JOptionPane.QUESTION_MESSAGE);
			//SI EL RUT NO COINCIDE CON EL DE NINGUN EMPLEADO DEBE REPETIRSE LA PREGUNTA (WHILE)
			//O SI EL EMPLEADO INGRESADO NO POSEE UNA HORA DE INGRESO TAMBIEN DEBE REPETIRSE
			
		}else if(e.getSource() == ventana.boton_mostrarinventario) {
			panelinventario panel = new panelinventario();
			try {
				controlador_panelinventario controlador = new controlador_panelinventario(panel);
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
		}else if(e.getSource() == ventana.boton_nuevaventa) {
			panelventa panel = new panelventa();
			controlador_panelventa controlador = new controlador_panelventa(panel);
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
		}else if(e.getSource() == ventana.boton_verboletas) {
			panelboletas panel = new panelboletas();
			controlador_panelboletas controlador = new controlador_panelboletas(panel);
		
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();
			
		}else if(e.getSource() == ventana.boton_vercliente) {
			panelclientes panel = new panelclientes();
			try {
				controlador_panelclientes controlador = new controlador_panelclientes(panel);
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ventana.panelcambio.removeAll();
			ventana.panelcambio.add(panel,BorderLayout.CENTER);
			ventana.panelcambio.revalidate();
			ventana.panelcambio.repaint();		
			
		}else if(e.getSource() == ventana.boton_volver) {
			ventanainicio ventanainicio =new ventanainicio();
			controlador_ventanainicio controlador = new controlador_ventanainicio(ventanainicio);
			controlador.iniciarventana();
			this.ventana.dispose();
			
			
		}
		
	}

}
