package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ventanalogin extends JFrame {

	public JPanel contentPane;
	public JButton btnIngresar;
	public JButton btnSalir;
	public JPanel panel;
	public JLabel lblUsuario;
	public JLabel lblContraseña;
	public JTextField textUsuario;
	public JPasswordField pwd;


	public ventanalogin() {
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(23, 41, 68, 14);
		panel.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(81, 38, 150, 20);
		textUsuario.setColumns(10);
		panel.add(textUsuario);
		
		
		lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(0, 86, 91, 19);
		panel.add(lblContraseña);
		
		pwd = new JPasswordField();
		pwd.setBounds(81, 85, 150, 20);
		panel.add(pwd);
		
		btnIngresar = new JButton("ENTRAR");
		btnIngresar.setBounds(241, 37, 83, 23);
		panel.add(btnIngresar);
		
		btnSalir = new JButton("VOLVER");
		btnSalir.setBounds(241, 84, 83, 23);
		panel.add(btnSalir);
	}
}
