package Personajes;

public abstract class entidades {
	protected String ruta;
	protected int posx;
	protected int posy;
	
	public String getruta(){
		return ruta;
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
}
