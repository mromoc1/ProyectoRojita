package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Vista.panelproductosporagotar;
import crud.conexion;

public class controlador_panelproductosporagotar implements ActionListener {
	panelproductosporagotar panel;
	
	public controlador_panelproductosporagotar(panelproductosporagotar panel) {
		this.panel = panel;
		
		this.panel.boton_buscar.addActionListener(this);
	}
	
	public void iniciarventana() {
		panel.setTitle("Ventana Informacion");
		panel.setSize(825, 545);
		panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel.setLocationRelativeTo(null);
		panel.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.boton_buscar) {
			try {
				panel.modelo.setRowCount(0);
				CargarProductosporAgotar(this.panel.campostock.getText());
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public void CargarProductosporAgotar(String stock) throws ClassNotFoundException, SQLException, IOException {
		conexion cone = new conexion();
		ResultSet tabla = cone.rs_CargarProductosporAgotar(stock);
		if(tabla != null) {
			
			while(tabla.next()){
				Object [] fila = new Object[6];
				 for (int i=0;i<=5;i++) {
					 
					 fila[i] = tabla.getObject(i+1);
				 }
				 panel.modelo.addRow(fila);
	        }
		}else {
			
			JOptionPane.showMessageDialog(null, "Producto no encontrado");
		}
	 }

	
}
