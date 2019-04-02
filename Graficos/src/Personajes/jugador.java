package Personajes;

import java.io.File;

import Visitor.*;

public class jugador extends personajes {
	private String ruta_jugando;
	private String ruta_perder; 
	
	public jugador (int posx, int posy){
		this.posx = posx;
		this.posy = posy;
		ruta_jugando ="imagenes"+File.separator+"fantasma.png";
		ruta_perder ="imagenes"+File.separator+"X.png";
		ruta = ruta_jugando;
		this.v = new visitadorjugador(this);
		this.vida=100;
		this.alcancedisparo = 10;
	}
	
	public void setRutaPerder () {
		ruta = ruta_perder;
	}
	
	public void setRutaJugando() {
		ruta = ruta_jugando ;
	}
	
	public boolean mover() {
		if (vida==0)
			return true;
		else
			return false;
	}



	@Override
	public void aceptar(visitador v) {
		v.visitar(this);
	}

}
