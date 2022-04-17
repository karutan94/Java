package vista;

import java.util.List;

public interface IVistaDeJuego {

	public void actualizarListaDeJugadoresEnLaPartida(List<String> jugadores);
	
	public void habilitarInicioDeJuego();
	
	public void actualizarJugadorActual(String jugadorActual, int numero);
	
	public void mostrarFinalDelJuego(String ganador, int victorias);
	
	public void errorAlAgregarJugador();
	
	public void jugadorUnoJugando();
	
	public void jugadorDosJugando();
	
	public void noListoParaIniciar();

	public void columnaLlena();
	
	public void ultimaFichaJugada(int yFila, int xColumna, String color);
	
	public void empate();
}
