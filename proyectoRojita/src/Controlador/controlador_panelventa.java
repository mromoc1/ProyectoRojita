package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Vista.panelventa;

public class controlador_panelventa implements ActionListener, KeyListener{
	panelventa panel;

	public controlador_panelventa(panelventa panel) {
		this.panel = panel;
		
		this.panel.boton_agregarproducto.addActionListener(this);
		this.panel.boton_finalizarcompra.addActionListener(this);
		
		this.panel.campocantidad.addKeyListener(this);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.panel.boton_agregarproducto) {
			//SE AGREGAN LOS PRODUCTOS A UNA LISTA
			//SE ACTUALIZAN LOS STOCKS EN LOS QUE SE MARCA CON LA MAQUINA
			//SE ACTUALIZA EL JLABEL DE MONTO TOTAL
			//[ACCION] SI EL MONTO TOTAL LLEGA AL MINIMO DE BENEFICIO SE ACTUALIZA EL JLABEL DE BENEFICIO Y SE DESCUENTA DEL MONTO TOTAL.
		
		}else if(e.getSource()==this.panel.boton_finalizarcompra) {
			//SE AÑADE LA COMO BOLETA A  LA BASE DE DATOS
		}
		
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER && e.getSource()==panel.campocantidad){
            //hace lo mismo que boton agregar
        }
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	
	
}
