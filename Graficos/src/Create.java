import Lista.*;
import Personajes.*;

public class Create {
	private Frame ventana ;
	private Panel panel ;
	private ConstructorMapa mapa;
	private Hilo hilo;
	PositionList<entidades> lista ;
	
	Create(){
		crear();
	}
	
	public void crear () {
		lista = new List<entidades> ();
		crear_nivel();
		ventana = new Frame();
		mapa = new ConstructorMapa();
		panel = new Panel(ventana,lista);
		ventana.addpanel(mapa);
		ventana.addpanel(panel);
		hilo = new Hilo(panel);
		hilo.run();
	}
	private void crear_nivel() {
		////////
		entidades p1 = new carafeliz(0,0);
		entidades p2 = new carafeliz(20,20);
		entidades p3 = new carafeliz(40,40);
			lista.addFirst(p3);
			lista.addFirst(p2);
			lista.addFirst(p1);
		////////
			
			////////
			entidades p4 = new Obstaculo (100,100);
			entidades p5 = new Obstaculo (180,220);
			entidades p6 = new Obstaculo (540,340);
			lista.addFirst(p4);
			lista.addFirst(p5);
			lista.addFirst(p6);
			///////////
	}
}
