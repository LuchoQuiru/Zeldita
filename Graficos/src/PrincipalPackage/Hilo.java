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
				System.out.println ("Hilardo");
				Thread.sleep(500);
				p.repaint();
				actualizador.actualizar_entidades();
				actualizador.chequear_colisiones();
			}
			catch (InterruptedException e) {
				
			}
		}
	}
	
}
