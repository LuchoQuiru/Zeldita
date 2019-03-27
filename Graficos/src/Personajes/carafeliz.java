package Personajes;
import PrincipalPackage.*;
import Strategy.*;
import Visitor.*;
public class carafeliz extends enemigos {

	public carafeliz (int posx, int posy, jugador jugador,actualizador actualizador){
		this.posx = posx;
		this.posy = posy;
		ruta = "/Images/4.png";
		this.alcancedisparo = 5;
		v = new visitadorenemigo();
		inteligencia = new inteligencia_uno(jugador,this,actualizador);
		this.vida=100;
	}
	
	public void aceptar (visitador v) {
		v.visitar(this);
	}
	
}
