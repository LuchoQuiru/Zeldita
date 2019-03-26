
import Personajes.*;

public class Hilo2 extends Thread {
	private volatile boolean ejecutar;
	private jugador jugador;
	private Teclado teclado;
	
	public Hilo2 (jugador jugador, Teclado teclado) {
		System.out.println ("Hilardo 2");
		this.jugador = jugador; 
		this.teclado = teclado;
	}
	
	public void terminar () {
		ejecutar = false;
	}
	
	public void run () {
		this.ejecutar = true;
		while(ejecutar) {
			try {
				System.out.println ("Hilardo 2");
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				
			}
		}
	}
}
