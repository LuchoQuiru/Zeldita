package Strategy;

import Personajes.enemigos;
import Personajes.jugador;

public abstract class Inteligencia_enemigos {
	private enemigos enemigo_propio;
	private jugador jugador;
	private int[][] tabla ;
	
	public void seguir_jugador() {};
}
