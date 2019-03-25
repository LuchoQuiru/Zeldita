import Lista.*;
import Personajes.*;

public class Create {
	private Frame ventana ;
	private Panel panel ;
	private ConstructorMapa mapa;
	private Hilo hilo;
	PositionList<entidades> lista ;
	private	boolean [][] tabla;
	
	Create(){
		crear();
	}
	
	public void crear () {
		lista = new List<entidades> ();
		generar_mapa();
		ventana = new Frame();
		mapa = new ConstructorMapa();
		panel = new Panel(ventana,lista);
		ventana.addpanel(mapa);
		ventana.addpanel(panel);
		hilo = new Hilo(panel);
		hilo.run();
	}
	
	/*
	 * Los proximos servicios crearán el mapa, incluyendo obstaculos y enemigos de manera aleatoria
	 */
	private void generar_mapa() {
		generar_tabla();
		generar_obstaculos();
		generar_enemigos();
	}
	
	private void generar_tabla() {
		//Esta tabla es una representacion de los objetos, en una tabla de 30x30
		tabla = new boolean[30][30];
		for (int i = 0 ; i<30 ; i++) {
			for (int j = 0 ; j<30 ; j++) {
				tabla[i][j] = false;
			}
		}
	}
	
	private boolean posicion_libre (int i, int j) {
		return tabla[i/20][j/20];
	}
	
	private void agregar_entabla(int i, int j) {
		tabla[i/20][j/20] = true;
	}
	
	private void generar_obstaculos() {
		for (int i = 0 ; i<50 ; i++) {
			int random1 = generar_numero();
			int random2 = generar_numero();
			while (posicion_libre(random1,random2) == true) {
				random1 = generar_numero();
				random2 = generar_numero();
			}
			lista.addFirst(new Obstaculo(random1,random2));
			agregar_entabla(random1,random2);
		}
	}
	
	private void generar_enemigos () {
		for (int i = 0 ; i<10 ; i++) {
			int random1 = generar_numero();
			int random2 = generar_numero();
			while (posicion_libre(random1,random2) == true) {
				random1 = generar_numero();
				random2 = generar_numero();
			}		
			lista.addFirst(new carafeliz(random1, random2));
			agregar_entabla(random1,random2);
		}
	}

	private int generar_numero() {
		return (20 * ( (int) (Math.random() * 28) + 1));
	}
}
