package Personajes;

import java.io.File;

import Visitor.*;

public class disparojugador extends disparo {

	public disparojugador(int posx, int posy, int cantidadmovimientos, String dirmovimiento) {
		this.cantidadmovimientos = cantidadmovimientos; 
		this.posx = posx;
		this.posy = posy;
		this.ruta ="imagenes"+File.separator+"beer.png";
		this.dirmovimiento = dirmovimiento;
		this.vida=100;
		this.v = new visitadordisparojugador(this);
	}

	@Override
	public void aceptar(visitador v) {
		v.visitar(this);
	}

	
}
