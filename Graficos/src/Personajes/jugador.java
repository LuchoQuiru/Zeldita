package Personajes;

import Visitor.*;

public class jugador extends personajes {
	
	public jugador (int posx, int posy){
		System.out.println ("Creando jugador");
		this.posx = posx;
		this.posy = posy;
		ruta = "C:/Users/julie/Desktop/3.png";
		this.v = new visitadorjugador();
		this.vida=100;
	}

	public boolean mover() {
		return false;
	}



	@Override
	public void aceptar(visitador v) {
		v.visitar(this);
	}

}
