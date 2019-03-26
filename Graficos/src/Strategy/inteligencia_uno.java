package Strategy;
import Personajes.*;
import Singleton.*;

public class inteligencia_uno extends Inteligencia_enemigos {
	private enemigos enemigo_propio;
	private jugador jugador;
	private tabla tabla;
	int pos_x_jugador, pos_y_jugador, pos_x_enemigo, pos_y_enemigo;
	
	public inteligencia_uno(jugador jugador, enemigos enemigo) {
		this.jugador = jugador; 
		enemigo_propio = enemigo;
		this.tabla = tabla.getinstance();
	}
		
	public void seguir_jugador() {
		pos_x_jugador = jugador.getx();
		pos_y_jugador = jugador.gety();
		pos_x_enemigo = enemigo_propio.getx();
		pos_y_enemigo = enemigo_propio.gety();
		mover_aleatorio();
		
		/*if (pos_x_enemigo == pos_x_jugador) 
			mover_eny();
		else
			if (pos_y_enemigo == pos_y_jugador)
				mover_enx();	
			else 
				mover_aleatorio();*/
	}
	
	private void mover_aleatorio() {
		if (pos_x_enemigo > pos_x_jugador)
			enemigo_propio.setx(pos_x_enemigo - 20);
		else
			enemigo_propio.setx(pos_x_enemigo + 20);
		
		if (pos_y_enemigo > pos_y_jugador)
			enemigo_propio.sety(pos_y_enemigo - 20);
		else
			enemigo_propio.sety(pos_y_enemigo + 20);
	}
	
	private void mover_enx() {
		
	}
	
	private void mover_eny() {
		
	}

}
