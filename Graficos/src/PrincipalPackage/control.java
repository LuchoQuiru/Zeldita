package PrincipalPackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Personajes.*;
import Singleton.tabla;

public class control implements KeyListener {

	private boolean izquierda,derecha,abajo,arriba,space;
	private jugador jugador;
	private tabla tabla;
	
	
	public control(jugador jugador) {
		this.jugador = jugador;
		izquierda = false;
		derecha = false;
		space = false;
		abajo = false;
		arriba = false;
		tabla = tabla.getinstance();
	}

	public void keyPressed(KeyEvent e) {
		if(KeyEvent.VK_LEFT == e.getKeyCode()) {
			if (!tabla.posicion_libre(jugador.getx()-20,jugador.gety())) {
				mover_izq();
			}
		}
		if(KeyEvent.VK_RIGHT == e.getKeyCode()) {
			if (!tabla.posicion_libre(jugador.getx()+20,jugador.gety())) {
				mover_der();
			}
		}
		if(KeyEvent.VK_SPACE == e.getKeyCode()) {
			
		}
		if(KeyEvent.VK_UP == e.getKeyCode()) {
			if (!tabla.posicion_libre(jugador.getx(),jugador.gety()-20)) {
				mover_arriba();
			}
		}
		if(KeyEvent.VK_DOWN == e.getKeyCode()) {
			if (!tabla.posicion_libre(jugador.getx(),jugador.gety()+20)) {
				mover_abajo();
			}
		}
	}


	public void keyReleased(KeyEvent e) {
	}


	public void keyTyped(KeyEvent e) {
	}

	private void mover_arriba() {
		tabla.setvalue(false, jugador.getx(), jugador.gety());
		jugador.sety(jugador.gety()-20);
		tabla.setvalue(true, jugador.getx(), jugador.gety());
	}
	private void mover_abajo() {
		tabla.setvalue(false, jugador.getx(), jugador.gety());
		jugador.sety(jugador.gety()+20);
		tabla.setvalue(true, jugador.getx(), jugador.gety());
	}
	private void mover_der() {
		tabla.setvalue(false, jugador.getx(), jugador.gety());
		jugador.setx(jugador.getx()+20);
		tabla.setvalue(true, jugador.getx(), jugador.gety());
	}

	private void mover_izq() {
		tabla.setvalue(false, jugador.getx(), jugador.gety());
		jugador.setx(jugador.getx()-20);
		tabla.setvalue(true, jugador.getx(), jugador.gety());
	}

}