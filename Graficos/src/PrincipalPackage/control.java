package PrincipalPackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Personajes.*;
import Singleton.tabla;

public class control implements KeyListener {
	private jugador jugador;
	private tabla tabla;
	private graficador p;
	private boolean pausado;
	private actualizador actualizador;
	private String direccion;
	
	public control(jugador jugador) {
		this.jugador = jugador;
		tabla = tabla.getinstance();
		direccion = "arriba";
		pausado = false;
	}

	public void keyPressed(KeyEvent e) {
		if (!pausado) {
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
	}
	
	protected void generar_disparo () { 
		disparo d = null;
		if(direccion == "arriba")
			d = new disparojugador(jugador.getx(), jugador.gety()-20, jugador.getAlcance(), "arriba");
		if(direccion == "abajo")
			d = new disparojugador(jugador.getx(), jugador.gety()+20, jugador.getAlcance(), "abajo");
		if(direccion == "derecha")
				d = new disparojugador(jugador.getx()+20, jugador.gety(), jugador.getAlcance(), "derecha");
		if(direccion == "izquierda")
					d = new disparojugador(jugador.getx()-20, jugador.gety(), jugador.getAlcance(), "izquierda");
		
		actualizador.agregarDisparo(d);
	}
	
	public void setactualizador (actualizador actualizador) {
		this.actualizador = actualizador;
	}

	public void setPanel(graficador p) {
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

	public void pause(boolean b) {
		pausado = b; 
	}

	
	public void keyReleased(KeyEvent e) {
	}


	public void keyTyped(KeyEvent e) {
	}
}