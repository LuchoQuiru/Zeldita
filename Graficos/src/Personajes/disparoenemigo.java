package Personajes;

import Visitor.*;

public class disparoenemigo extends disparo {
	
	public disparoenemigo(int posx, int posy, int cantidadmovimientos, String dirmovimiento) {
		this.cantidadmovimientos = cantidadmovimientos; 
		this.posx = posx;
		this.posy = posy;
		this.ruta = "C:/Users/julie/Desktop/balaE.png";
		this.dirmovimiento = dirmovimiento;
		this.vida=100;
		this.v = new visitadordisparoenemigo(this);
	}

	@Override
	public void aceptar(visitador v) {
		v.visitar(this);
	}
	

}
