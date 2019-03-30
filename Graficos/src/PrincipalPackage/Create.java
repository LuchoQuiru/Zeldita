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
	
	private void crear () {
		tabla = tabla.getinstance();
		lista = new List<entidades> ();
		generar_jugador();
		control = new control(jugador);
		actualizador = new actualizador (lista,control, jugador);
		generar_obstaculos();
		generar_enemigos();
		ventana = new Frame(control);
		panel = new Panel(ventana,jugador,lista);
		ventana.addpanel(panel);
		
		control.setPanel(panel);
		control.setactualizador(actualizador);

		hilo = new Hilo(panel,actualizador);
		hilo.run();
	}
	
	
	private void agregar_entabla(int i, int j) { 
		tabla.setvalue(true, i/20, j/20);
	}
	
	private void generar_jugador () {
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
	
	private int moneda_azar() {
		//Este metodo retorna un 0 o un 1, al azar
		return (int) (Math.random()*2);
	}
	
	private void generar_enemigos () {
		
		for (int i = 0 ; i<10 ; i++) {
			int random1 = generar_numero();
			int random2 = generar_numero();
			while (tabla.posicion_libre(random1,random2) == true) {
				random1 = generar_numero();
				random2 = generar_numero();
			}		
			if(moneda_azar() == 0)
				lista.addFirst(new duendes(random1, random2,jugador,actualizador));
			else
				lista.addFirst(new dragones(random1, random2, jugador,actualizador));
			agregar_entabla(random1,random2);
		}
	}

	private int generar_numero() {
		return (20 * ( (int) (Math.random() * 28) + 1));
	}


}
