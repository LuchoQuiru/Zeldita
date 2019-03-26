
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
	private boolean izquierda,derecha,space,abajo,arriba;
	
	public Teclado() {
		izquierda = false;
		derecha = false;
		space = false;
		abajo = false;
		arriba = false;
	}

	public void keyPressed(KeyEvent e) {
		System.out.println ("KEYEENVET:)");
		if(KeyEvent.VK_LEFT == e.getKeyCode()) 
			izquierda = true;
		if(KeyEvent.VK_RIGHT == e.getKeyCode())
			derecha = true;
		if(KeyEvent.VK_SPACE == e.getKeyCode())
			space = true;
		if(KeyEvent.VK_UP == e.getKeyCode())
			arriba = true;
		if(KeyEvent.VK_DOWN == e.getKeyCode())
			abajo = true;
	}


	public void keyReleased(KeyEvent e) {
		if(KeyEvent.VK_LEFT == e.getKeyCode()) 
			izquierda = false;
		if(KeyEvent.VK_RIGHT == e.getKeyCode())
			derecha = false;
		if(KeyEvent.VK_SPACE == e.getKeyCode())
			space = false;
		if(KeyEvent.VK_UP == e.getKeyCode())
			arriba = false;
		if(KeyEvent.VK_DOWN == e.getKeyCode())
			abajo = false;
	}


	public void keyTyped(KeyEvent e) {
	
	}

	public boolean isSpace() {
		boolean aux = space;
		space = false;
		return aux;
	}

	public boolean isDerecha() {
		return derecha;
	}
	
	public boolean isAbajo() {
		return abajo;
	}
	
	public boolean isArriba() {
		return arriba;
	}

	public boolean isIzquierda() {
		return izquierda;
	}

}