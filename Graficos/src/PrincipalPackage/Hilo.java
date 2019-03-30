package PrincipalPackage;

public class Hilo extends Thread {
	private volatile boolean ejecutar;
	private Panel p ;
	private actualizador actualizador; 
	
	public Hilo (Panel p, actualizador act) {
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
			}
			catch (InterruptedException e) {
				
			}
		}
	}
	
}
