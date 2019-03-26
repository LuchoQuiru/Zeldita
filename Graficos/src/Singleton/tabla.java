package Singleton;

public class tabla {
	private static tabla instancia;
	private boolean [][] tabla;
	
	private tabla(){
		tabla = new boolean[30][30];
		for (int i = 0 ; i<30 ; i++) {
			for (int j = 0 ; j<30 ; j++) {
				tabla[i][j] = false;
			}
		}
	}
	public static tabla getinstance () {
		if (instancia == null) {
			instancia = new tabla();
		}
		return instancia;
	}
	
	public boolean posicion_libre (int i, int j) {
		if (i<0 || j<0 || i>599 || j>599)
			return false;
		return tabla[i/20][j/20];
	}
	
	public boolean getvalue(int i, int j) {
		return tabla[i][j];
	}
	public void setvalue(boolean b, int i, int j) {
		if(i>=0 || j>=0 || i<30 || j<30)
			tabla[i][j] = b;
	}
}
