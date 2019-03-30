package Personajes;

import Singleton.*;

public abstract class disparo extends entidades{
	protected int cantidadmovimientos;
	protected String dirmovimiento;
	protected tabla tabla;
	
	public boolean mover() {
		boolean ret = false;
		if (vida==0)
			ret=true;
		else {
			tabla = tabla.getinstance(); 
			cantidadmovimientos--; 
			if(dirmovimiento == "arriba") {
				sety(gety()-20);
			}
			if(dirmovimiento == "abajo") {
				sety(gety()+20);
			}
			if(dirmovimiento == "derecha") {
				setx(getx()+20);
			}
			if(dirmovimiento == "izquierda") {
				setx(getx()-20);
			}
			if(cantidadmovimientos == 0) 
				ret = true;
		}
		return ret;
	}
	
}
