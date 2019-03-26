import Lista.*;
import Personajes.*;

public class Hilo extends Thread {
	private volatile boolean ejecutar;
	private Panel p ;
	private PositionList<enemigos> listaenemigos;
	
	public Hilo (Panel p, PositionList<enemigos> listaenemigos) {
		this.p = p;
		this.listaenemigos = listaenemigos; 
	}

	public void terminar () {
		ejecutar = false;
	}
	
	public void run() {
		this.ejecutar = true;
		while(ejecutar) {
			try {
				System.out.println ("Hilardo");
				Thread.sleep(50);
				p.repaint();
				actualizar_enemigos();
			}
			catch (InterruptedException e) {
				
			}
		}
	}
	
	private void actualizar_enemigos () {
		for(Position<enemigos> p : listaenemigos.positions()) {
			p.element().mover();
		}
	}
}
