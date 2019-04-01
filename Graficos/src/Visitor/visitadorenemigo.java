package Visitor;

import Personajes.*;

public class visitadorenemigo implements visitador{

	private enemigos propio;
	
	public visitadorenemigo (enemigos propio) {
		this.propio = propio; 
	}
	
	@Override
	public void visitar(obstaculos obstaculo) {
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
		this.propio.setvida(0);
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

	@Override
	public void visitar(frankestein frankestein) {
		// TODO Auto-generated method stub
		
	}

}
