package Personajes;
import Strategy.*;

public abstract class enemigos extends personajes {
	protected jugador jugador;
	protected Inteligencia_enemigos inteligencia;
	
	public abstract boolean mover() ;
	
	public int getx_jugador() {
		return jugador.getx();
	}
	
	public int gety_jugador() {
		return jugador.gety();
	}
}
