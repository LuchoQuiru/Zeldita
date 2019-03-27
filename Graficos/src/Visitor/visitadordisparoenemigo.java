package Visitor;

import Personajes.*;

public class visitadordisparoenemigo extends visitador {
	private disparoenemigo propio;
	
	public visitadordisparoenemigo(disparoenemigo d) {
		propio = d;
	}
	
	public void visitar(Obstaculo obstaculo) {
		System.out.println ("visitar carafeliz");
		propio.setvida(0);
	}

	public void visitar(carafeliz carafeliz) {
		System.out.println ("visitar carafeliz");
		carafeliz.setvida(carafeliz.getvida()-100);
		propio.setvida(0);
	}

	public void visitar(disparoenemigo disparoenemigo) {
		
	}

	public void visitar(jugador jugador) {
		System.out.println ("visitando al jugador");
		jugador.setvida(jugador.getvida()-20);
		propio.setvida(0);
	}

}
