package PrincipalPackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Personajes.*;
import Singleton.tabla;

public class control implements KeyListener {
	private jugador jugador;
	private tabla tabla;
	private Panel p;
	private actualizador actualizador;
	private String direccion;
	
	public control(jugador jugador) {
		this.jugador = jugador;
		tabla = tabla.getinstance();
		direccion = "arriba";
	}

	public void keyPressed(KeyEvent e) {
		if(KeyEvent.VK_LEFT == e.getKeyCode()) {
			if (!tabla.posicion_libre(jugador.getx()-20,jugador.gety())) {
				mover_izq();
				direccion = "izquierda";
			}
		}
		if(KeyEvent.VK_RIGHT == e.getKeyCode()) {
			if (!tabla.posicion_libre(jugador.getx()+20,jugador.gety())) {
				mover_der();
				direccion = "derecha";
			}
		}
		if(KeyEvent.VK_SPACE == e.getKeyCode()) {
			generar_disparo();
		}
		if(KeyEvent.VK_UP == e.getKeyCode()) {
			if (!tabla.posicion_libre(jugador.getx(),jugador.gety()-20)) {
				mover_arriba();
				direccion = "arriba";
			}
		}
		if(KeyEvent.VK_DOWN == e.getKeyCode()) {
			if (!tabla.posicion_libre(jugador.getx(),jugador.gety()+20)) {
				mover_abajo();
				direccion = "abajo";
			}
		}
	}
	
	protected void generar_disparo () { 
		disparo d = new disparojugador(jugador.getx(), jugador.gety(), 10, direccion);
		actualizador.agregarDisparo(d);
	}
	
	public void setactualizador (actualizador actualizador) {
		this.actualizador = actualizador;
	}
	
	
	public void keyReleased(KeyEvent e) {
	}


	public void keyTyped(KeyEvent e) {
	}

	public void setPanel(Panel p) {
		this.p = p;
	}
	
	private void mover_arriba() {
		tabla.setvalue(false, jugador.getx(), jugador.gety());
		jugador.sety(jugador.gety()-20);
		tabla.setvalue(true, jugador.getx(), jugador.gety());
		p.paintJugador();
	}
	private void mover_abajo() {
		tabla.setvalue(false, jugador.getx(), jugador.gety());
		jugador.sety(jugador.gety()+20);
		tabla.setvalue(true, jugador.getx(), jugador.gety());
		p.paintJugador();
	}
	private void mover_der() {
		tabla.setvalue(false, jugador.getx(), jugador.gety());
		jugador.setx(jugador.getx()+20);
		tabla.setvalue(true, jugador.getx(), jugador.gety());
		p.paintJugador();

	}

	private void mover_izq() {
		tabla.setvalue(false, jugador.getx(), jugador.gety());
		jugador.setx(jugador.getx()-20);
		tabla.setvalue(true, jugador.getx(), jugador.gety());
		p.paintJugador();

	}

}