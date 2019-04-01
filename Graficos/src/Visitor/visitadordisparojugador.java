package Visitor;

import Personajes.*;

public class visitadordisparojugador implements visitador{
	
	private disparojugador propio;
	
	public visitadordisparojugador (disparojugador propio) {
		this.propio = propio;
	}
	
	@Override
	public void visitar(obstaculos obstaculo) {
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
		dragones.setvida(0);
		propio.setvida(0);
	}

	@Override
	public void visitar(frankestein frankestein) {
		frankestein.setvida(0);
		propio.setvida(0);
	}

}
