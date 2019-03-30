package Visitor;

import Personajes.*;

public class visitadorjugador extends visitador{
	private jugador jugador;
	
	public visitadorjugador (jugador jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public void visitar(Obstaculo obstaculo) {
	}

	@Override
	public void visitar(duendes duende) {
		duende.setvida(0);
		this.jugador.setvida(0);
	}

	@Override
	public void visitar(disparoenemigo disparoenemigo) {
		disparoenemigo.setvida(0);
		this.jugador.setvida(0);
	}


	@Override
	public void visitar(jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(disparojugador disparojugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(dragones dragones) {
		dragones.setvida(0);
		this.jugador.setvida(0);
	}

}
