package Strategy;

import Singleton.*;
import PrincipalPackage.*;
import Personajes.*;

public abstract class Inteligencia_enemigos {
	protected enemigos enemigo_propio;
	protected tabla tabla ;
	protected int pos_x_jugador, pos_y_jugador, pos_x_enemigo, pos_y_enemigo;
	protected actualizador actualizador; 
	
	public abstract boolean mover() ;
	
	protected void generar_disparo (int i) {
		disparo d = null;
		if(i==1)
			d = new disparoenemigo(enemigo_propio.getx(), enemigo_propio.gety()-20, enemigo_propio.getAlcance(), "arriba");
		if (i==2) 
			d = new disparoenemigo(enemigo_propio.getx(), enemigo_propio.gety()+20, enemigo_propio.getAlcance(), "abajo");
		if (i==3) 
			d = new disparoenemigo(enemigo_propio.getx()+20, enemigo_propio.gety(), enemigo_propio.getAlcance(), "derecha");
		if (i==4)
			d = new disparoenemigo(enemigo_propio.getx()-20, enemigo_propio.gety()-20, enemigo_propio.getAlcance(), "izquierda");
		actualizador.agregarDisparo(d);
	}
	
	protected int moneda_azar() {
		//Este metodo retorna un 0 o un 1, al azar
		return (int) (Math.random()*2);
	}
	
	protected int cuatro_valores() {
		//Este metodo retorna del 1 al 4, al azar
		return (int) (Math.random()*4) +1 ;
	}
	
	protected int generar_numero() {
		//Este metodo retorna un valor del 1 al 29
		return (int) (Math.random() * 28) + 1;
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