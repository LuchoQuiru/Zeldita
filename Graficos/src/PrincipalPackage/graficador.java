package PrincipalPackage;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import Lista.*;
import Personajes.*;


@SuppressWarnings("serial")
public class graficador extends JPanel { 
	private PositionList<entidades> lista;
	ventana frame;
	private jugador jugador;
	private boolean solojugador;
	
	public graficador(ventana ventana, jugador jugador, PositionList<entidades> lista) {
		this.frame = ventana;
		this.lista = lista;
		this.jugador = jugador;
		this.solojugador=false;
	}

	/*
	 * Este metodo grafica la totalidad de las entidades que están en la lista.
	 */
	public void paint(Graphics g){
		super.paint(g);
		Toolkit t = Toolkit.getDefaultToolkit();
		Image imagen = t.getImage("C:/Users/julie/Desktop/grass.png");
		g.drawImage(imagen, 0, 0, 600,600, this);
		
		for (Position<entidades> p : lista.positions()) {
			imagen = t.getImage(p.element().getruta());
			g.drawImage(imagen, p.element().getx(), p.element().gety(), 20,20, this);
		}
	}
	
	public void paintJugador() {
		jugador.getvida();
		repaint();
	}
}