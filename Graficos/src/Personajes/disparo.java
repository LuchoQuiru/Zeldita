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
			
			if(dirmovimiento == "arriba" && posy != 0)
				sety(gety()-20);
			else
				if(dirmovimiento == "abajo" && posy+20 != 600)
					sety(gety()+20);
				else
					if(dirmovimiento == "derecha" && posx+20 != 600)
						setx(getx()+20);
					else
						if(dirmovimiento == "izquierda" && posx != 0)
							setx(getx()-20);
						else
							cantidadmovimientos = 0;
			
			if(cantidadmovimientos == 0) 
				ret = true;
		}
		return ret;
	}
	
}
