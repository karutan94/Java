package modelo;

public class Jugador {
	
	private static int contadorJugador = 0;
	private int numero;
	private String nombre;
	private int victorias;
	
	//Constructor
	public Jugador(String nombre) {
		/*Controlo que el numero de jugador sea 0 y 1
		 * Así coincide con el índice del arreglo de jugadores en la clase juego
		 */
		if (contadorJugador>1) {
			contadorJugador = 0;
		}
		this.numero = contadorJugador;
		++contadorJugador;
		this.victorias = 0;
		//Si se ingresa un nombre vacio o nulo lo cargo por defecto como jugador + el numero de jugador
		if (nombre == null || nombre.equals(""))
			this.nombre = "Jugador " + String.valueOf(numero++);
		else
			this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getNumero() {
		return numero;
	}

	public int getVictorias() {
		return victorias;
	}
	
	public void acumularVictorias() {
		++this.victorias;
	}	
}
