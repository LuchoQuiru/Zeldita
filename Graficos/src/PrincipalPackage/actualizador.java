package PrincipalPackage;
import Lista.*;
import Personajes.*;
import Singleton.tabla;

public class actualizador {

	private PositionList<entidades> lista ;
	private tabla tabla;
	jugador jugador;
	
	public actualizador (PositionList<entidades> lista, control control, jugador jugador) {
		this.lista = lista; 
		tabla = tabla.getinstance();
		this.jugador = jugador;
	}
	
	public void actualizar_entidades () {
		boolean debo_eliminar = false;
		for(Position<entidades> p : lista.positions()) {
			debo_eliminar = p.element().mover();
			if (debo_eliminar) {
						try {
								lista.remove(p);
						} catch (InvalidPositionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
						debo_eliminar = true;
						actualizar_jugador();
			}
		}
		chequear_colisiones();
	}
	
	public void actualizar_jugador() {
		jugador.mover();
	}

	public void chequear_colisiones () {
		for(Position<entidades> p : lista.positions()) {
			for(Position<entidades> e : lista.positions()) {
				if (p.element().iguales(e.element())) {
					e.element().aceptar(p.element().getvisitador());
				}
			}
		}
	}
	
	public void agregarDisparo(disparo d) {
		lista.addFirst(d);
	}
	
}
