package Personajes;

public class jugador extends entidades {
	//private Teclado teclado;
	
	public jugador (int posx, int posy){
		this.posx = posx;
		this.posy = posy;
		ruta = "C:/Users/julie/Desktop/3.png";
		//teclado = new Teclado();
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
