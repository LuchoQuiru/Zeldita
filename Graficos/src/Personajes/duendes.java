package Personajes;
import java.io.File;

import PrincipalPackage.*;
import Strategy.*;
import Visitor.*;
public class duendes extends enemigos {
	private boolean bandera;
	private jugador jugador;
	private actualizador actualizador;
	
	public duendes (int posx, int posy, jugador jugador,actualizador actualizador){
		this.posx = posx;
		this.posy = posy;
		ruta = "imagenes"+File.separator+"duende.png";
		this.alcancedisparo = 5;
		v = new visitadorenemigo(this);
		this.jugador = jugador;
		this.actualizador = actualizador; 
		this.vida=100;
		bandera = false;
	}
	
	public void aceptar (visitador v) {
		v.visitar(this);
	}

	@Override
	public boolean mover() {
		if (!bandera) {
			this.inteligencia = new inteligencia_aleatoria(this, actualizador);
			bandera = true;
		}
		if(bandera) {
			this.inteligencia = new inteligencia_dirigida (jugador, this, actualizador);
			bandera = false;
		}
		return inteligencia.mover();
	}
	
}
