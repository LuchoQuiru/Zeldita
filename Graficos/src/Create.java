
import Singleton.*;
import Lista.*;
import Personajes.*;

public class Create {
	private Frame ventana ;
	private Panel panel ;
	private ConstructorMapa mapa;
	private Hilo hilo;
	private Hilo2 hilo2;
	PositionList<entidades> lista ;
	PositionList<enemigos> listaenemigos ;
	private jugador jugador;
	private tabla tabla;
	private Teclado teclado;
	
	Create(){
		crear();
	}
	
	public void crear () {
		tabla = tabla.getinstance();
		lista = new List<entidades> ();
		listaenemigos = new List<enemigos>();
		generar_mapa();
		ventana = new Frame();
		mapa = new ConstructorMapa();
		panel = new Panel(ventana,lista,listaenemigos);
		ventana.addpanel(mapa);
		ventana.addpanel(panel);
		teclado = new Teclado();

		hilo = new Hilo(panel,listaenemigos);
		hilo2 = new Hilo2(jugador,teclado);
		hilo.run();
		//hilo2.run();
		
	}
	
	/*
	 * Los proximos servicios crearán el mapa, incluyendo obstaculos y enemigos de manera aleatoria
	 */
	private void generar_mapa() {
		//generar_tabla();
		generar_obstaculos();
		generar_jugador();
		generar_enemigos();
	}
	
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
		
		for (int i = 0 ; i<10 ; i++) {
			int random1 = generar_numero();
			int random2 = generar_numero();
			while (tabla.posicion_libre(random1,random2) == true) {
				random1 = generar_numero();
				random2 = generar_numero();
			}		
			listaenemigos.addFirst(new carafeliz(random1, random2,jugador));
			agregar_entabla(random1,random2);
		}
	}

	private int generar_numero() {
		return (20 * ( (int) (Math.random() * 28) + 1));
	}


}
