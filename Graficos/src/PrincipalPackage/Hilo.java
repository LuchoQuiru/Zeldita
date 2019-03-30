package PrincipalPackage;

public class Hilo extends Thread {
	private volatile boolean ejecutar;
	private Create c;
	private Panel p ;
	private actualizador actualizador; 
	
	public Hilo (Panel p, actualizador act, Create c) {
		this.c = c; 
		this.p = p; 
		this.actualizador = act;
	}

	public void terminar () {
		ejecutar = false;
	}
	
	public void run() {
		this.ejecutar = true;
		while(ejecutar) {
			try {
				p.repaint();
				Thread.sleep(350);
				actualizador.actualizar_entidades();
				actualizador.chequear_colisiones();
				if(c.isdead()) {
					p.repaint(); 
					Thread.sleep(4000);
					c.regenerar_jugador();
				}
			}
			catch (InterruptedException e) {
				
			}
		}
	}
	
}
