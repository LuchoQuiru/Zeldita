package Visitor;

import Personajes.*;

public class visitadorobstaculo extends visitador {

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
		disparoenemigo.setvida(0);
	}


	@Override
	public void visitar(jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(disparojugador disparojugador) {
		disparojugador.setvida(0);
	}

	@Override
	public void visitar(dragones dragones) {
		// TODO Auto-generated method stub
		
	}


}
