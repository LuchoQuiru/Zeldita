package Personajes;

import java.io.File;

import PrincipalPackage.*;
import Strategy.*;
import Visitor.*;

public class dragones extends enemigos{
	
	public dragones (int posx, int posy, jugador jugador,actualizador actualizador){
		this.posx = posx;
		this.posy = posy;
		ruta = "imagenes"+File.separator+"dragon.png";
		this.alcancedisparo = 10;
		v = new visitadorenemigo(this);
		inteligencia = new inteligencia_aleatoria(this,actualizador);
		this.vida=100;
	}
	
	public void aceptar (visitador v) {
		v.visitar(this);
	}

	@Override
	public boolean mover() {
		return inteligencia.mover();
	}
	
}
