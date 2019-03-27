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
			}
		}
	}

	public void chequear_colisiones () {
		System.out.println ("hola");
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
