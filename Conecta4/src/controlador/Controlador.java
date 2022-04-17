package controlador;

import java.util.ArrayList;
import java.util.Collection;

import observer.Observable;
import observer.Observador;
import vista.IVistaDeJuego;
import modelo.Celda;
import modelo.IJuego;
import modelo.EstadoJuego;

public class Controlador implements Observador {

	//Colección de vistas asociadas al controlador del juego
	private Collection<IVistaDeJuego> vistas;
	
	private IJuego juego;

	//Constructor
	public Controlador() {
		this.vistas = new ArrayList<IVistaDeJuego>();
	}
	
	//Agrear vista al controlador
	public void agregarVista(IVistaDeJuego nuevaVista) {
		this.vistas.add(nuevaVista);
	}
	
	//Iniciar juego
	public void iniciarJuego() {
		this.juego.iniciar();
	}
	
	//Agregar jugador
	public void juegoAgregarJugador(String nombre) {
		this.juego.agregarJugador(nombre);
	}
	
	//Reiniciar tablero
	public void juegoReiniciarTablero() {
		this.juego.reiniciarTablero();
	}
	
	//Reiniciar juego
	public void juegoReiniciarJuego() {
		this.juego.reiniciarJuego();
	}
	
	public void juegoColocarFicha(int columna, Celda color) {
		this.juego.agregarFicha(columna, color);
	}
	
	@Override
	public void actualizar(Observable objetoQueCambio, Object arg1) {
		EstadoJuego evento = (EstadoJuego) arg1;
		switch (evento) {
			case ESPERANDO_JUGADORES:
				for (IVistaDeJuego vista: this.vistas) {
					vista.noListoParaIniciar();
				}
				break;
			case CAMBIO_LISTA_DE_JUGADORES:
				for (IVistaDeJuego vista: this.vistas) {
					vista.actualizarListaDeJugadoresEnLaPartida(this.juego.listarJugadores());
				}
				break;
			case ERROR_AL_AGREGAR_JUGADOR:
				for (IVistaDeJuego vista: this.vistas) {
					vista.errorAlAgregarJugador();
				}
				break;
			case LISTO_PARA_INICIAR:
				for (IVistaDeJuego vista: this.vistas) {
					vista.habilitarInicioDeJuego();
				}
				break;
			case JUGANDO_JUGADOR_1:
				for (IVistaDeJuego vista: this.vistas) {
					vista.actualizarJugadorActual(this.juego.getNombreJugadorActual(), this.juego.getJugadorEnTurno());
				}
			case JUGANDO_JUGADOR_2:
				for (IVistaDeJuego vista: this.vistas) {
					vista.actualizarJugadorActual(this.juego.getNombreJugadorActual(), this.juego.getJugadorEnTurno());
				}
				break;
			case COLUMNA_LLENA:
				for (IVistaDeJuego vista: this.vistas) {
					vista.columnaLlena();
				}
				break;
			case ULTIMA_FICHA_JUGADA:
				for (IVistaDeJuego vista: this.vistas) {
					vista.ultimaFichaJugada(this.juego.getUltimaYFila(), this.juego.getUltimaXColumna(), this.juego.getUltimoColor());
				}
				break;
			case EMPATE:
				for (IVistaDeJuego vista: this.vistas) {
					vista.empate();
				}
				break;
			case TERMINADO:
				for (IVistaDeJuego vista: this.vistas) {
					vista.mostrarFinalDelJuego(this.juego.getNombreGanador(), this.juego.getVictoriasGanador());
				}
				break;
		}
	}
}
