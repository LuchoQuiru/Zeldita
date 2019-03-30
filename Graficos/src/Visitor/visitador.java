package Visitor;

import Personajes.*;

public abstract class visitador {

	public abstract void visitar(Obstaculo obstaculo);
	public abstract void visitar(duendes carafeliz);
	public abstract void visitar(disparoenemigo disparoenemigo);
	public abstract void visitar(jugador jugador);
	public abstract void visitar(disparojugador disparojugador);
	public abstract void visitar(dragones dragones);

}
