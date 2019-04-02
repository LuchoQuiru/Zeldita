package Personajes;

import java.io.File;

import Visitor.*;

public class obstaculos extends entidades {
	
	public obstaculos (int posx, int posy, int i){
		this.posx = posx;
		this.posy = posy;
		if (i==1) 
			ruta = "imagenes"+ File.separator + "tree.png";
		else 
			ruta = "imagenes" + File.separator+"shovel.png";
		this.v= new visitadorobstaculo();
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