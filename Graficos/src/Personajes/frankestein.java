package Personajes;

import PrincipalPackage.actualizador;
import Strategy.inteligencia_dirigida;
import Visitor.*;

public class frankestein extends enemigos{

	public frankestein (int posx, int posy, jugador jugador,actualizador actualizador){
		this.posx = posx;
		this.posy = posy;
		ruta = "C:/Users/julie/Desktop/frankestein.png";
		this.alcancedisparo = 5;
		v = new visitadorenemigo(this);
		this.inteligencia = new inteligencia_dirigida(jugador, this, actualizador);
		this.jugador = jugador;
		this.vida=100;
	}
	
	@Override
	public boolean mover() {
		return inteligencia.mover();
	}

	@Override
	public void aceptar(visitador v) {
		v.visitar(this);
	}

}
