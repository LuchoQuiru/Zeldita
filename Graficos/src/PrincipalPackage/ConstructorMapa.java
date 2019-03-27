package PrincipalPackage;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ConstructorMapa extends JPanel {
	private int contador_x;
	private int contador_y;
	
	ConstructorMapa () {
		contador_x = -20;
		contador_y = -20;
	}
	public void paint(Graphics g){
		super.paint(g);
		Toolkit t = Toolkit.getDefaultToolkit();
		Image imagen = t.getImage("C:/Users/julie/Desktop/grass.png");
		for (int i = 0; i<30; i++) {
			contador_x += 20;
			for (int j = 0; j<30; j++) {
				contador_y += 20;
				g.drawImage(imagen,contador_x,contador_y, 20,20, this);
			}
		}
	}
}
