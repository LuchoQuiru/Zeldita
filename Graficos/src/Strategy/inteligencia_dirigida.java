package Strategy;
import PrincipalPackage.*;
import Personajes.*;

public class inteligencia_dirigida extends Inteligencia_enemigos {
	private jugador jugador;
	
	public inteligencia_dirigida(jugador jugador, enemigos enemigo, actualizador a) {
		this.jugador = jugador; 
		enemigo_propio = enemigo;
		this.tabla = tabla.getinstance();
		this.actualizador = a; 
	}
		
	public boolean mover() {
		if (enemigo_propio.getvida()==0)
			return true;
		else {
			pos_x_jugador = jugador.getx();
			pos_y_jugador = jugador.gety();
			pos_x_enemigo = enemigo_propio.getx();
			pos_y_enemigo = enemigo_propio.gety();
			mover_alguneje();
		
			if(generar_numero()==10)
				generar_disparo(cuatro_valores());
		}
		return false;
		
	}
	
	private void mover_alguneje() {
		int num = moneda_azar();
		if (num==1)
			mover_enx();
		else
			mover_eny();
	}
	
	private void mover_enx() {
		boolean move_izq , move_der; 
		move_izq = ! (tabla.posicion_libre(pos_x_enemigo - 20, pos_y_enemigo));
		move_der = ! (tabla.posicion_libre(pos_x_enemigo + 20, pos_y_enemigo));
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
		boolean move_arriba , move_abajo; 
		move_arriba = ! (tabla.posicion_libre(pos_x_enemigo, pos_y_enemigo + 20));
		move_abajo =  ! (tabla.posicion_libre(pos_x_enemigo, pos_y_enemigo - 20));
		boolean debo_ir_abajo = pos_y_enemigo > pos_y_jugador;
		boolean debo_ir_arriba = pos_y_enemigo < pos_y_jugador;
		
		//Analizo si me puedo mover para la posicion del jugador
		if (!memovi && debo_ir_abajo && move_abajo ) {
				mover_abajo();
				memovi = true;
		}
		if (!memovi && debo_ir_arriba && move_arriba) {
			mover_arriba();
			memovi=true;
		}
		//Analizo si me puedo mover para algun lado
		if (!memovi && move_abajo) {
			mover_abajo();
			memovi=true;
		}
		if(!memovi && move_arriba) {
			mover_arriba();
			memovi=true;
		}
	}

}