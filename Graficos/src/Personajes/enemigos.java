package Personajes;
import Strategy.*;
import Singleton.*;

public abstract class enemigos extends personajes {
	protected jugador jugador;
	protected Inteligencia_enemigos inteligencia;
	protected int alcancedisparo;
	
	public void mover() {
		inteligencia.mover();
	}
	
	public int getAlcance() {
		return alcancedisparo;
	}
	
	public int getx_jugador() {
		return jugador.getx();
	}
	
	public int gety_jugador() {
		return jugador.gety();
	}
}
