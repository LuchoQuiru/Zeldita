package PrincipalPackage;
import Lista.*;
import Personajes.*;
import Singleton.tabla;

public class actualizador {

	private PositionList<entidades> lista ;
	private tabla tabla;
	
	public actualizador (PositionList<entidades> lista) {
		this.lista = lista; 
		tabla = tabla.getinstance();
	}
	
	public void actualizar_entidades () {
		for(Position<entidades> p : lista.positions()) {
			p.element().mover();
		}
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
		tabla.setvalue(true, d.getx()/20, d.gety()/20);
	}
	
}
