package Personajes;

import Visitor.*;

public class obstaculos extends entidades {
	
	public obstaculos (int posx, int posy, int i){
		this.posx = posx;
		this.posy = posy;
		if (i==1) 
			ruta = "C:/Users/julie/Desktop/tree.png";
		else 
			ruta = "C:/Users/julie/Desktop/shovel.png";
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