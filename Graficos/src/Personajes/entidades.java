package Personajes;

import Visitor.*;
public abstract class entidades {
	protected String ruta;
	protected int posx;
	protected int posy;
	protected visitador v;
	
	public visitador getvisitador() {
		return v;
	}
	
	public void aceptar (visitador v) {
	}
	
	public String getruta(){
		return ruta;
	}
	
	public boolean iguales(entidades e) {
		return (( e.getx() == posx) && (e.gety()==posy));
	}
	
	public int getx() {
		return posx;
	}
	
	public int gety() {
		return posy;
	}
	
	public void setx(int x) {
		posx = x;
	}
	
	public void sety(int y) {
		posy= y;
	}

	public abstract void mover();
}
