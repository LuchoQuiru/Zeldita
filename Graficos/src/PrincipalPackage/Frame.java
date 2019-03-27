package PrincipalPackage;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	Panel p;
	
	public Frame(control t){
		
		setSize(620,640);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(t);
	}
	
	public void addpanel(Panel p) {
		this.add(p);
	}
}


