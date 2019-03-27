package PrincipalPackage;

import Singleton.*;
import Lista.*;
import Personajes.*;

public class Create {
	private Frame ventana ;
	private Panel panel ;
	private Hilo hilo;
	PositionList<entidades> lista ;
	private jugador jugador;
	private tabla tabla;
	private control control;
	private actualizador actualizador;
	
	Create(){
		crear();
	}
	
	public void crear () {
		tabla = tabla.getinstance();
		lista = new List<entidades> ();
		generar_jugador();
		control = new control(jugador);
		actualizador = new actualizador (lista,control, jugador);
		generar_obstaculos();
		generar_enemigos();
		ventana = new Frame(control);
		panel = new Panel(ventana,lista);
		ventana.addpanel(panel);

		hilo = new Hilo(panel,actualizador);
		hilo.run();
		
	}
	
	/*
	 * Los proximos servicios crearán el mapa, incluyendo obstaculos y enemigos de manera aleatoria
	 */
	/*private void generar_mapa() {
		generar_obstaculos();
		generar_jugador();
		generar_enemigos();
	}*/
	
	private void agregar_entabla(int i, int j) { 
		tabla.setvalue(true, i/20, j/20);
	}
	
	public void generar_jugador () {
		int random1 = generar_numero();
		int random2 = generar_numero();
		while (tabla.posicion_libre(random1,random2) == true) {
			random1 = generar_numero();
			random2 = generar_numero();
		}
		jugador = new jugador(random1,random2);
		lista.addFirst(jugador);
		agregar_entabla(random1,random2);
	}
	
	private void generar_obstaculos() {
		for (int i = 0 ; i<50 ; i++) {
			int random1 = generar_numero();
			int random2 = generar_numero();
			while (tabla.posicion_libre(random1,random2) == true) {
				random1 = generar_numero();
				random2 = generar_numero();
			}
			lista.addFirst(new Obstaculo(random1,random2));
			agregar_entabla(random1,random2);
		}
	}
	
	private void generar_enemigos () {
		
		for (int i = 0 ; i<0 ; i++) {
			int random1 = generar_numero();
			int random2 = generar_numero();
			while (tabla.posicion_libre(random1,random2) == true) {
				random1 = generar_numero();
				random2 = generar_numero();
			}		
			lista.addFirst(new carafeliz(random1, random2,jugador,actualizador));
			agregar_entabla(random1,random2);
		}
	}

	private int generar_numero() {
		return (20 * ( (int) (Math.random() * 28) + 1));
	}


}
