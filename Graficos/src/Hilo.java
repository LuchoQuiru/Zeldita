
public class Hilo extends Thread {
	private volatile boolean ejecutar;
	private Panel p ; 
	
	public Hilo (Panel p) {
		this.p = p;
	}
	
	public void terminar () {
		ejecutar = false;
	}
	
	public void run() {
		this.ejecutar= true;
		while(ejecutar) {
			try {
				System.out.println ("Hilardo");
				Thread.sleep(100);
				p.repaint();
			}
			catch (InterruptedException e) {
				
			}
		}
	}
}
