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
	}
	
	private void mover_aleatorio() {
		int num = (int) ((Math.random() * 2) + 1);
		if (num==1)
			mover_enx();
		else
			mover_eny();
	}
	
	private void mover_enx() {
		System.out.println ("Entré a mover_enX");
		boolean move_izq , move_der; 
		move_izq = ! (tabla.posicion_libre(pos_x_enemigo - 20, pos_y_enemigo));
		move_der = ! (tabla.posicion_libre(pos_x_enemigo + 20, pos_y_enemigo));
		System.out.println ("Move_izq: " + move_izq);
		System.out.println ("Move_der: " + move_der);
		boolean debo_ir_izq = pos_x_enemigo > pos_x_jugador;
		boolean debo_ir_der = pos_x_enemigo < pos_x_jugador;
		boolean memovi = false;
		
		//Analizo si me puedo mover para donde necesito
		if (!memovi && debo_ir_izq && move_izq) {
			mover_izq();
			memovi = true;
		}
		if(!memovi && debo_ir_der && move_der) {
			mover_der();
			memovi = true;
		}
		//Analizo si me puedo mover para algun lado
		//o pdria resolver esto en Y
		if(!memovi && move_der) {
			mover_der();
			memovi=true;
		}
		if(!memovi && move_izq) {
			mover_izq();
			memovi=true;
		}
	}
	
	private void mover_eny() {
		boolean memovi = false;
		System.out.println ("Entré a mover_enY");
		boolean move_arriba , move_abajo; 
		move_arriba = ! (tabla.posicion_libre(pos_x_enemigo, pos_y_enemigo + 20));
		move_abajo =  ! (tabla.posicion_libre(pos_x_enemigo, pos_y_enemigo - 20));
		System.out.println ("Move_arriba: " + move_arriba);
		System.out.println ("Move_abajo: " + move_abajo);
		boolean debo_ir_abajo = pos_y_enemigo > pos_y_jugador;
		boolean debo_ir_arriba = pos_y_enemigo < pos_y_jugador;
		
		//Analizo si me puedo mover para la posicion del jugador
		if (!memovi && debo_ir_abajo && move_abajo ) {
				mover_abajo();
				memovi = true;
		}
		if (!memovi && debo_ir_arriba && move_arriba) {
			mover_arriba();
			/*enemigo_propio.sety(pos_y_enemigo + 20);
			tabla.setvalue(false, pos_x_enemigo/20, pos_y_enemigo/20);
			tabla.setvalue(true, pos_x_enemigo/20, (pos_y_enemigo + 20) /20);*/
			memovi=true;
		}
		//Analizo si me puedo mover para algun lado
		//podriá fijarme que pasa en x, o resolverlo en y
		if (!memovi && move_abajo) {
			mover_abajo();
			memovi=true;
		}
		if(!memovi && move_arriba) {
			mover_arriba();
			memovi=true;
		}
	}

	private void mover_arriba() {
		enemigo_propio.sety(pos_y_enemigo + 20);
		tabla.setvalue(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setvalue(true, pos_x_enemigo/20, (pos_y_enemigo + 20) /20);
	}
	private void mover_abajo() {
		enemigo_propio.sety(pos_y_enemigo - 20);
		tabla.setvalue(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setvalue(true, pos_x_enemigo/20, (pos_y_enemigo - 20) /20);
	}
	private void mover_der() {
		enemigo_propio.setx(pos_x_enemigo + 20);
		tabla.setvalue(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setvalue(true, (pos_x_enemigo + 20) / 20, pos_y_enemigo / 20 );
	}
	
	private void mover_izq() {
		enemigo_propio.setx(pos_x_enemigo - 20);
		tabla.setvalue(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setvalue(true, (pos_x_enemigo - 20) / 20, pos_y_enemigo / 20 );
	}
}
