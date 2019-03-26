package Personajes;
import Strategy.*;
import Singleton.*;

public abstract class enemigos extends entidades {
	protected jugador jugador;
	protected Inteligencia_enemigos inteligencia;
	
	public void mover() {
		inteligencia.seguir_jugador();
	}
	
	public int getx_jugador() {
		return jugador.getx();
	}
	
	public int gety_jugador() {
		return jugador.gety();
	}
}
