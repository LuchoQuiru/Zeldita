package Personajes;
import Strategy.*;
public class carafeliz extends enemigos {

	public carafeliz (int posx, int posy, jugador jugador){
		this.posx = posx;
		this.posy = posy;
		ruta = "C:/Users/julie/Desktop/0.png";
		
		inteligencia = new inteligencia_uno(jugador,this);
	}
	
}
