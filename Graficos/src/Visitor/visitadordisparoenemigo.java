package Visitor;

import Personajes.*;

public class visitadordisparoenemigo implements visitador {
	private disparoenemigo propio;
	
	public visitadordisparoenemigo(disparoenemigo d) {
		propio = d;
	}
	
	public void visitar(obstaculos obstaculo) {
		propio.setvida(0);
	}

	public void visitar(duendes carafeliz) {
		carafeliz.setvida(carafeliz.getvida()-100);
		propio.setvida(0);
	}

	public void visitar(disparoenemigo disparoenemigo) {
		
	}

	public void visitar(jugador jugador) {
		jugador.setvida(jugador.getvida()-20);
		propio.setvida(0);
	}

	@Override
	public void visitar(disparojugador disparojugador) {
		disparojugador.setvida(0);
		propio.setvida(0);
	}

	@Override
	public void visitar(dragones dragones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(frankestein frankestein) {
		
	}

}
