package PrincipalPackage;
import Lista.*;
import Personajes.*;
import Singleton.tabla;

public class actualizador {

	private PositionList<entidades> lista ;
	private tabla tabla;
	private control control;
	private jugador jugador;
	
	public actualizador (PositionList<entidades> lista, control control, jugador jugador) {
		this.lista = lista; 
		tabla = tabla.getinstance();
		this.control = control; 
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
	
	/*public void actualizar_jugador() {
		System.out.println ("Actualizar_jugador");
		int posx = jugador.getx();
		int posy = jugador.gety();
		
		if (control.getabajo()) {
			if(!tabla.posicion_libre(posx,posy+20)) {
				jugador.sety(posy+20);
			}
		}
		if (control.getarriba()) {
			if(!tabla.posicion_libre(posx,posy-20)) {
				jugador.sety(posy-20);
			}
		}
		if (control.getderecha()) {
			if(!tabla.posicion_libre(posx+20,posy)) {
				jugador.setx(posx+20);
			}
		}
		if (control.getizquierda()) {
			if(!tabla.posicion_libre(posx-20,posy)) {
				jugador.setx(posx-20);
			}
		}
		
	}*/
	
	public void agregarDisparo(disparo d) {
		lista.addFirst(d);
		tabla.setvalue(true, d.getx()/20, d.gety()/20);
	}
	
}
