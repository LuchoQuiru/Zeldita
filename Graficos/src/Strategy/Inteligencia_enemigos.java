package Strategy;

import Singleton.*;
import PrincipalPackage.*;
import Personajes.*;

public abstract class Inteligencia_enemigos {
	protected enemigos enemigo_propio;
	protected tabla tabla ;
	protected int pos_x_jugador, pos_y_jugador, pos_x_enemigo, pos_y_enemigo;
	protected actualizador actualizador; 
	
	public void mover() {};
	
	protected void crear_disparo () {
		disparo disparo = new disparoenemigo (enemigo_propio.getx(),enemigo_propio.gety(), enemigo_propio.getAlcance(), "arriba");
		actualizador.agregarDisparo(disparo);
	}
	
	protected void mover_arriba() {
		enemigo_propio.sety(pos_y_enemigo + 20);
		tabla.setvalue(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setvalue(true, pos_x_enemigo/20, (pos_y_enemigo + 20) /20);
	}
	protected void mover_abajo() {
		enemigo_propio.sety(pos_y_enemigo - 20);
		tabla.setvalue(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setvalue(true, pos_x_enemigo/20, (pos_y_enemigo - 20) /20);
	}
	protected void mover_der() {
		enemigo_propio.setx(pos_x_enemigo + 20);
		tabla.setvalue(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setvalue(true, (pos_x_enemigo + 20) / 20, pos_y_enemigo / 20 );
	}

	protected void mover_izq() {
		enemigo_propio.setx(pos_x_enemigo - 20);
		tabla.setvalue(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setvalue(true, (pos_x_enemigo - 20) / 20, pos_y_enemigo / 20 );
	}
}