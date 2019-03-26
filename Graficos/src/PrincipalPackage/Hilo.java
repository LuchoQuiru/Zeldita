package PrincipalPackage;
import Lista.*;
import Personajes.*;

public class Hilo extends Thread {
	private volatile boolean ejecutar;
	private Panel p ;
	private PositionList<enemigos> listaenemigos;
	private PositionList<entidades> lista;
	private actualizador actualizador; 
	
	public Hilo (Panel p, actualizador act) {
		this.p = p;
		this.lista = lista; 
		this.actualizador = act;
	}

	public void terminar () {
		ejecutar = false;
	}
	
	public void run() {
		this.ejecutar = true;
		while(ejecutar) {
			try {
				System.out.println ("Hilardo");
				Thread.sleep(1000);
				p.repaint();
				actualizador.actualizar_entidades();
			}
			catch (InterruptedException e) {
				
			}
		}
	}
	
}
