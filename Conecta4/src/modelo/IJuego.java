package modelo;

import java.util.ArrayList;
import java.util.List;

public interface IJuego {
	
	void agregarJugador(String nombre);
	
	void iniciar();
	
	void atenderTurnoDeJugadorActual();
	
	void agregarFicha(int columna, Celda color);
	
	void terminarJuego(EstadoJuego estadoActual);
	
	int getJugadorEnTurno();
	
	void setJugadorEnTurno();
	
	Jugador getJugadorActual();
	
	String getNombreJugadorActual();
	
	EstadoJuego getEstado();
	
	void setEstado(EstadoJuego nuevoEstado);
	
	ArrayList<Jugador> getListaDeJugadores();
	
	List<String> listarJugadores();
	
	Jugador getGanador();
	
	String getNombreGanador();
	
	int getVictoriasGanador();
	
	int getUltimaYFila();
	
	int getUltimaXColumna();
	
	String getUltimoColor();
	
	void reiniciarTablero();
	
	void reiniciarJuego();
}
