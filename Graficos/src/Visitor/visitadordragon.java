package Visitor;

import Personajes.dragones;
import Personajes.Obstaculo;
import Personajes.duendes;
import Personajes.disparoenemigo;
import Personajes.disparojugador;
import Personajes.enemigos;
import Personajes.jugador;

public class visitadordragon extends visitador {
	private enemigos propio;
	
	public visitadordragon (enemigos propio) {
		this.propio = propio; 
	}
	
	@Override
	public void visitar(Obstaculo obstaculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(duendes carafeliz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(disparoenemigo disparoenemigo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visitar(jugador jugador) {
		jugador.setvida(0);
		
	}

	@Override
	public void visitar(disparojugador disparojugador) {
		propio.setvida(0);
		disparojugador.setvida(0);
	}

	@Override
	public void visitar(dragones dragones) {
		// TODO Auto-generated method stub
		
	}
}
