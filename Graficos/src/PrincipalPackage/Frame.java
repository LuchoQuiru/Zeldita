package PrincipalPackage;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	Panel p;
	
	public Frame(){
		
		setSize(620,640);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void addpanel(Panel p) {
		this.add(p);
	}
	public void addpanel(ConstructorMapa m) {
		this.add(m);
	}
}


