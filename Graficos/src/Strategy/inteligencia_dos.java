package Strategy;

import Personajes.*;

/*
 * Esta inteligencia mueve a los enemigos
 *  de forma aleatoria por el mapa.
 */

public class inteligencia_dos extends Inteligencia_enemigos{
	
	public inteligencia_dos (enemigos enemigo) {
		this.enemigo_propio = enemigo; 
		this.tabla = tabla.getinstance();
	}
	
	private int moneda_azar() {
		//Este metodo retorna un 0 o un 1, al azar
		return (int) (Math.random()*2);
	}
	
	public void seguir_jugador() {
		pos_x_enemigo = enemigo_propio.getx();
		pos_y_enemigo = enemigo_propio.gety();
		mover_alguneje();
	}
	
	private void mover_alguneje() {
		int num = moneda_azar();
		System.out.println ("Num: " + num);
		if (num==1)
			mover_enx();
		else
			mover_eny();
	}
	
	private void mover_enx() {
		boolean move_izq = ! (tabla.posicion_libre(pos_x_enemigo - 20, pos_y_enemigo));
		boolean move_der = ! (tabla.posicion_libre(pos_x_enemigo + 20, pos_y_enemigo));
		boolean memovi = false;
		
		int num = moneda_azar();
		if(!memovi && move_der &&num==0) {
			mover_der();
			memovi=true;
		}
		if(!memovi && move_izq && num==1) {
			mover_izq();
			memovi=true;
		}
	}
	
	private void mover_eny() {
		boolean memovi = false;
		boolean move_arriba = ! (tabla.posicion_libre(pos_x_enemigo, pos_y_enemigo + 20));
		boolean move_abajo =  ! (tabla.posicion_libre(pos_x_enemigo, pos_y_enemigo - 20));
		//Analizo si me puedo mover para algun lado
		
		int num = moneda_azar();
		if (!memovi && move_abajo && num==0) {
			mover_abajo();
			memovi=true;
		}
		if(!memovi && move_arriba && num==1) {
			mover_arriba();
			memovi=true;
		}
	}
}
