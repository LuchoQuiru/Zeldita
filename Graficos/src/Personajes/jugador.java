package Personajes;

import Visitor.*;

public class jugador extends personajes {
	
	public jugador (int posx, int posy){
		this.posx = posx;
		this.posy = posy;
		ruta = "C:/Users/julie/Desktop/3.png";
		this.v = new visitadorjugador(this);
		this.vida=100;
	}

	public int getvida() {
		System.out.println ("vida jugador: " + vida);
		return vida;
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
