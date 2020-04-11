package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.panelboletas;

public class controlador_panelboletas implements ActionListener, MouseListener {
	panelboletas panel;
	
	public controlador_panelboletas(panelboletas panel) {
		
		this.panel = panel;
		
		this.panel.boton_buscar.addActionListener(this);
		this.panel.table.addMouseListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.panel.boton_buscar) {
			
		}
		
	}



	public void mouseClicked(MouseEvent e) {
		
	}
	
	
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

}
