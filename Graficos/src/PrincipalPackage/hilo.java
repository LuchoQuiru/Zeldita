package PrincipalPackage;

public class hilo extends Thread {
	private volatile boolean ejecutar;
	private creador c;
	private graficador p ;
	private actualizador actualizador; 
	
	public hilo (graficador p, actualizador act, creador c) {
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
