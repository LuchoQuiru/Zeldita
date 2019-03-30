package Visitor;

import Personajes.*;

public class visitadordisparojugador extends visitador{
	
	private disparojugador propio;
	
	public visitadordisparojugador (disparojugador propio) {
		this.propio = propio;
	}
	
	@Override
	public void visitar(Obstaculo obstaculo) {
		propio.setvida(0);
	}

	@Override
	public void visitar(duendes carafeliz) {
		carafeliz.setvida(carafeliz.getvida()-100);
		propio.setvida(0);
	}

	@Override
	public void visitar(disparoenemigo disparoenemigo) {
		disparoenemigo.setvida(0);
		this.propio.setvida(0);
		
	}


	@Override
	public void visitar(jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(disparojugador disparojugador) {
		
	}

	@Override
	public void visitar(dragones dragones) {
		// TODO Auto-generated method stub
		
	}

}
