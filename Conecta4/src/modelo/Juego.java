package modelo;

import java.util.ArrayList;
import java.util.List;

import observer.Observable;

public class Juego extends Observable implements IJuego{
	
	//Tablero donde se colocan las fichas
	private Tablero tablero;
	//Arreglo de jugadores del juego
	private ArrayList<Jugador> jugadores;
	//Jugador actual, posicion del arreglo de jugadores
	private int jugadorEnTurno;
	//Estado del juego
	private EstadoJuego estado;
	//Cantidad de fichas colocadas, tiene que ser menor o igual a 42
	private int jugadas;

	//Constructor
	public Juego() {
		this.tablero = new Tablero();
		this.jugadores = new ArrayList<Jugador>();
		this.estado = EstadoJuego.ESPERANDO_JUGADORES;
	}
	
	/*Carga un jugador
	 * si flag == true, fue agregado
	 * si flag == false, se alcanzó el límite de jugadores
	 */
	@Override
	public void agregarJugador(String nombre) {
		boolean agregado = false;
		//Si el juego esta en estado esperando jugadores
		if (this.estado.equals(EstadoJuego.ESPERANDO_JUGADORES) && jugadores.size()<2) {
			//Creo un nuevo jugador
			Jugador nuevoJugador = new Jugador(nombre);
			//Si no existe en la colección de jugadores actuales
			if (!this.jugadores.contains(nuevoJugador)) {
				//Lo agrego a la lista de jugadores
				jugadores.add(nuevoJugador);
			}
			//Si hay 2 jugadores, cambio el estado del juego a LISTO_PARA_INICIAR
			if (this.jugadores.size() == 2) {
				this.setEstado(EstadoJuego.LISTO_PARA_INICIAR);
			}
			//Cambio la bandera
			agregado = true;
		}
		if (agregado == true) {
			this.notificar(EstadoJuego.CAMBIO_LISTA_DE_JUGADORES);
		}
		else {
			this.notificar(EstadoJuego.ERROR_AL_AGREGAR_JUGADOR);
		}
	}
	
	@Override
	public void iniciar() {
		//Si el juego esta en LISTO_PARA_INICIAR
		if (!this.estado.equals(EstadoJuego.LISTO_PARA_INICIAR)) {
			this.notificar(EstadoJuego.ESPERANDO_JUGADORES);
			return;
		}
		//Indico que no hay jugadas
		this.jugadas = 0;
		//Indico el primer jugador
		this.jugadorEnTurno = 0;
		//Atiendo el turno del jugador actual
		this.atenderTurnoDeJugadorActual();
	}
	@Override
	//Atiende un nuevo turno del jugador actual
	public void atenderTurnoDeJugadorActual() {
		if  (jugadorEnTurno == 0) {
			this.estado = EstadoJuego.JUGANDO_JUGADOR_1;
			this.notificar(EstadoJuego.JUGANDO_JUGADOR_1);
		}
		else {
			this.estado = EstadoJuego.JUGANDO_JUGADOR_2;
			this.notificar(EstadoJuego.JUGANDO_JUGADOR_2);
		}
	}
	
	/*Coloca una ficha
	 * Valida que haya juego
	 * Valida que haya lugares libres en el tablero, si jugadas <42 quedan lugares libres
	 * Sino es porque el tablero esta lleno
	 * Si el tablero se lleno y no salio antes por algun ganador
	 * Quiere decir que hubo empate
	 */
	@Override
	public void agregarFicha(int columna, Celda color) {
		if (jugadas<=42) {
			if (tablero.colocarFicha(columna, color) == true) {
				jugadas++;
				this.notificar(EstadoJuego.ULTIMA_FICHA_JUGADA);
				//Busqueda vertical
				if (tablero.verificarEnVertical(columna, color) == true){
					this.jugadores.get(jugadorEnTurno).acumularVictorias();
					this.terminarJuego(EstadoJuego.TERMINADO);
				}
				//Busqueda horizontal
				if (tablero.verificarEnHorizontal(this.tablero.getUltimaYFila(), color) == true) {
					this.jugadores.get(jugadorEnTurno).acumularVictorias();
					this.terminarJuego(EstadoJuego.TERMINADO);
				}
				//Busqueda diagonal
				else{
				//Cambio el turno del jugador
					this.setJugadorEnTurno();
					this.atenderTurnoDeJugadorActual();
				}
			}
			else {
				this.notificar(EstadoJuego.COLUMNA_LLENA);
			}
		}
		else {
			this.notificar(EstadoJuego.EMPATE);
		}
	}
	
	@Override
	//Termina el juego
	public void terminarJuego(EstadoJuego estadoActual) {
		//Cambio el estado del juego a terminado
		this.estado = EstadoJuego.TERMINADO;
		/*Si el juego termina por tablero lleno y nadie hizo cuatro en linea,
		 * notifico que terminó en empate, pero igual cambio el estado del juego a TERMINADO
		 * Si no notifico que termino y que hay un ganador
		 */
		if (estadoActual.equals(EstadoJuego.EMPATE)) {
			this.notificar(EstadoJuego.EMPATE);
		}
		else {
			this.notificar(EstadoJuego.TERMINADO);
		}
	}
	
	@Override
	//Get jugador en turno
	public int getJugadorEnTurno() {
		return this.jugadorEnTurno;
	}
	
	@Override
	//Siguiente jugador
	public void setJugadorEnTurno() {
		/*Si es el turno del primer jugador
		 * cambio al siguiente
		 */
		if (jugadorEnTurno == 0) {				
			this.jugadorEnTurno = 1;
		}
		else {
			/*Si es el turno del segundo jugador
			 * cambio al primero
			 */
			this.jugadorEnTurno = 0;
		}
	}
	
	@Override
	//Get estado del juego
	public EstadoJuego getEstado() {
		return this.estado;
	}
	
	@Override
	//Set estado del juego
	public void setEstado(EstadoJuego nuevoEstado) {
		this.estado = nuevoEstado;
	}
	
	@Override
	//Get lista de jugadores
	public ArrayList<Jugador> getListaDeJugadores(){
		return this.jugadores;
	}
	
	@Override
	//Reinicia el tablero para jugar de nuevo con los mismo jugadores
	public void reiniciarTablero() {
		this.estado = EstadoJuego.LISTO_PARA_INICIAR;
		this.tablero.vaciarTablero();
	}
	
	@Override
	//Reinicia el juego
	public void reiniciarJuego() {
		this.setEstado(EstadoJuego.ESPERANDO_JUGADORES);
		this.jugadores = new ArrayList<Jugador>();
		this.tablero.vaciarTablero();
		this.jugadas = 0;
	}

	@Override
	public List<String> listarJugadores() {
		List<String> nombres = new ArrayList<String>();
		for (Jugador jugador : jugadores) {
			nombres.add(jugador.getNombre());
		}
		return nombres;
	}
	
	@Override
	public Jugador getGanador() {
		Jugador ganador = this.jugadores.get(jugadorEnTurno);
		return ganador;
	}

	@Override
	public String getNombreGanador() {
		return this.getGanador().getNombre();
	}

	@Override
	public int getVictoriasGanador() {
		return this.getGanador().getVictorias();
	}

	@Override
	public Jugador getJugadorActual() {
		return this.jugadores.get(this.jugadorEnTurno);
	}

	@Override
	public String getNombreJugadorActual() {
		return this.getJugadorActual().getNombre();
	}

	@Override
	public int getUltimaYFila() {
		return this.tablero.getUltimaYFila();
	}

	@Override
	public int getUltimaXColumna() {
		return this.tablero.getUltimaXColumna();
	}

	@Override
	public String getUltimoColor() {
		String color;
		if (this.tablero.getUltimoColorFicha().equals(Celda.ROJO)) {
			color = "ROJO";
		}
		else {
			color = "AZUL";
		}
		return color;
	}
}
