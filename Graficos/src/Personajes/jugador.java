package Personajes;

import Visitor.*;

public class jugador extends personajes {
	//private Teclado teclado;
	
	public jugador (int posx, int posy){
		this.posx = posx;
		this.posy = posy;
		ruta = "C:/Users/julie/Desktop/3.png";
		//teclado = new Teclado();
		this.v = new visitadorjugador();
		this.vida=100;
	}

	
	
	@Override
	public boolean mover() {
		return false;
	}



	@Override
	public void aceptar(visitador v) {
		v.visitar(this);
	}
	
	/*public void mover () {
		System.out.println ("mover");
		 System.out.println ("teclado abajo: " + teclado.isAbajo());
		 if (teclado.isAbajo()) {
			 posy -= 20;
		 }
		 if (teclado.isArriba()) {
			 posy += 20;
		 }
		 if (teclado.isDerecha()) {
			 posx += 20;
		 }
		 if (teclado.isIzquierda()) {
			 posx -= 20;
		 }
		 posx -= 10;
	}*/
}
