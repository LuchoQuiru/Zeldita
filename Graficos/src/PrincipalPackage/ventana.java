package PrincipalPackage;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ventana extends JFrame {
	graficador p;
	
	public ventana(control t){
		
		setSize(620,640);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(t);
	}
	
	public void addpanel(graficador p) {
		this.add(p);
	}
}


