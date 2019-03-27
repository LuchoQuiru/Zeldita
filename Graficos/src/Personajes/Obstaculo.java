package Personajes;

import Visitor.*;

public class Obstaculo extends entidades {

	public Obstaculo (int posx, int posy){
		this.posx = posx;
		this.posy = posy;
		ruta = "C:/Users/julie/Desktop/obstaculo.png";
		this.v= new visitadorobstaculo();
		this.vida=100;
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