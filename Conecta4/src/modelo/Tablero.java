package modelo;

public class Tablero {

	private Celda[][] tablero;
	
	private int ultimaXColumna;
	
	private int ultimaYFila;
	
	private Celda ultimoColorFicha;
	
	//Constructor
	public Tablero() {
		//Crear tablero vacio
		tablero = new Celda[7][6];
		vaciarTablero();
	}

	//Vaciar tablero
	public void vaciarTablero(){
		for (int yFila=0; yFila<5; yFila++) {
			for (int xColumna=0; xColumna<6; xColumna++) {
				this.tablero[yFila][xColumna] = Celda.VACIO;
			}
		}
	}
	
	//Coloca una ficha en el tablero
	public boolean colocarFicha(int xColumna, Celda color){
		boolean bandera = false;
		int yFila = 5;
		while (!bandera && yFila>0) {
			if (tablero[yFila][xColumna] == Celda.VACIO) {
				tablero[yFila][xColumna] = color;
				this.ultimaYFila = yFila;
				this.ultimaXColumna = xColumna;
				this.ultimoColorFicha = color;
				bandera = true;
			}
			else {
				yFila--;
			}	
		}
		return bandera;
	}

	/*Busqueda vertical
	 * X
	 * X
	 * X
	 * X
	 */
	public boolean verificarEnVertical(int xColumna, Celda color) {
		boolean bandera = false;
		int yFila = 5;
		int contadorDeFichasIguales = 0;
		while (!bandera || yFila>0) {
			if (tablero[yFila][xColumna].equals(color)) {
				contadorDeFichasIguales++;
				if (contadorDeFichasIguales == 4) {
					bandera = true;
				}
			}
			else {
				contadorDeFichasIguales = 0;
			}
		}
		return bandera;
	}
	
	/*Busqueda horizontal
	 * X X X X
	 */
	public boolean verificarEnHorizontal(int yFila, Celda color) {
		boolean bandera = false;
		int xColumna = 0;
		int contadorDeFichasIguales = 0;
		while (!bandera || xColumna<6) {
			if (tablero[yFila][xColumna].equals(color)) {
					contadorDeFichasIguales++;
					if (contadorDeFichasIguales == 4) {
						bandera = true;
					}
				}
				else {
					contadorDeFichasIguales = 0;
				}
			xColumna++;
			}
		return bandera;
	}
	
	public int getUltimaXColumna() {
		return ultimaXColumna;
	}

	public int getUltimaYFila() {
		return ultimaYFila;
	}
	
	public Celda getUltimoColorFicha() {
		return ultimoColorFicha;
	}
}
