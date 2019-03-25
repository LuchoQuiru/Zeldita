import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import Lista.*;
import Personajes.*;


public class Panel extends JPanel { 
	private PositionList<entidades> lista;
	Frame frame;
	
	public Panel(Frame ventana, PositionList<entidades> lista2) {
		this.frame = frame;
		this.lista = lista2;
	}

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
}


/*
public void paint(Graphics g){
super.paint(g);
Toolkit t = Toolkit.getDefaultToolkit();
Image imagen = t.getImage("C:/Users/julie/Desktop/grass.png");
g.drawImage(imagen, 0, 0, 30,30, this);
g.drawImage(imagen, 30, 30, 30,30, this);
g.drawImage(imagen, 60, 60, 30,30, this);
g.drawImage(imagen, 90, 90, 30,30, this);
g.drawImage(imagen, 120, 120, 30,30, this);
}*/