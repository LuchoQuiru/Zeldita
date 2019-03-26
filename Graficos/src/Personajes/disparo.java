package Personajes;

import PrincipalPackage.*;
import Singleton.tabla;

public abstract class disparo extends entidades{
	protected int cantidadmovimientos;
	protected String dirmovimiento;
	protected tabla tabla;
	
	public void mover() {
		tabla = tabla.getinstance(); 
		cantidadmovimientos--; 
		if(dirmovimiento == "arriba") {
			tabla.setvalue(false, getx()/20, gety()/20);
			tabla.setvalue(true, getx()/20, (gety()-20)/20);
			sety(gety()-20);
		}
	}
	
}
