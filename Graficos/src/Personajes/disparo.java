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
				tabla.setvalue(false, getx()/20, gety()/20);
				tabla.setvalue(true, getx()/20, (gety()-20)/20);
				sety(gety()-20);
			}
			if(cantidadmovimientos == 0) 
				ret = true;
		}
		return ret;
	}
	
}
