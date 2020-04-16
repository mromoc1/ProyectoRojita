package Controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Vista.ventanaadministrador;
import Vista.ventanainicio;
import Vista.ventanalogin;

public class controlador_login implements ActionListener  {
	
	ventanalogin ventanalogin;
	
	
	public controlador_login(ventanalogin ventanalogin) {
		this.ventanalogin = ventanalogin;
		
		ventanalogin.btnIngresar.addActionListener(this);
		ventanalogin.btnSalir.addActionListener(this);
		ventanalogin.textUsuario.addKeyListener(null);
		ventanalogin.pwd.addKeyListener(null);

	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void iniciarlogin() {

		ventanalogin.setTitle("Ingresar Administrador");
		ventanalogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanalogin.setSize(355, 200);
		ventanalogin.contentPane = new JPanel();
		ventanalogin.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ventanalogin.contentPane.setLayout(new BorderLayout(0, 0));
		ventanalogin.setLocationRelativeTo(null);
		ventanalogin.setVisible(true);
	
	
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ventanalogin.btnIngresar) {
			
			char[] clave = ventanalogin.pwd.getPassword();
			String clavefinal = new String(clave);
			
			if(ventanalogin.textUsuario.getText().equals("1")&&clavefinal.equals("1")){
				
					JOptionPane.showMessageDialog(null, "Bienvenido Don Fernando","Ingreso Permitido",JOptionPane.INFORMATION_MESSAGE);
					ventanaadministrador ventanaadministrador = new ventanaadministrador();
					controlador_ventanaadministrador controlador1 = new controlador_ventanaadministrador(ventanaadministrador);
					controlador1.iniciarventana();	
					this.ventanalogin.dispose();
			}
			else{
		            JOptionPane.showMessageDialog(null, "Usuario / Contraseña Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
		            ventanalogin.textUsuario.setText("");
		            ventanalogin.pwd.setText("");
		            ventanalogin.textUsuario.requestFocus();
		        }
			}
					
		 if(e.getSource() == ventanalogin.btnSalir) {
					ventanainicio ventanainicio =new ventanainicio();
					controlador_ventanainicio controlador = new controlador_ventanainicio(ventanainicio);
					controlador.iniciarventana();
					this.ventanalogin.dispose();
					
				}
		}

	}	

	