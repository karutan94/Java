import java.io.Serializable;

public class Tablero implements Serializable{
	
	private Celda[][] tablero;
	
	public Tablero() {
		tablero = new Celda[2][2];
	}
	
	public void agregarFicha(int fila, int columna, String color) {
		this.tablero[fila][columna] = new Celda(color);
	}
}
