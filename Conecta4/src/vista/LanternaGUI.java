package vista;

import java.util.List;

import com.googlecode.lanterna.terminal.Terminal;

import controlador.Controlador;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class LanternaGUI implements IVistaDeJuego{

	private boolean inicioHabilitado;
	
	private boolean finalizoPartida;
	
	private Controlador controlador;
	
	Terminal terminal;
	
	Screen screen;

	private Screen screenAltaJugador;
	
	//Constructor
	public LanternaGUI(Controlador controlador) throws Exception {
		this.terminal = new DefaultTerminalFactory().createTerminal();
		this.screen = new TerminalScreen(terminal);
		screen.startScreen();
		this.inicioHabilitado = false;
		this.finalizoPartida = false;
		this.controlador = controlador;
		this.controlador.agregarVista(this);
	}
	
	public void menuPrincipal() throws Exception {
		boolean keepRunning = true;
		while (keepRunning) {
			TextGraphics tg = screen.newTextGraphics();
			tg.setForegroundColor(TextColor.ANSI.WHITE);
			tg.putString(0, 2, "Menu Principal");
			tg.setForegroundColor(TextColor.ANSI.GREEN);
			tg.putString(0, 4,"1- Agregar jugador");
			tg.putString(0, 5, "2- Iniciar Juego");
			tg.setForegroundColor(TextColor.ANSI.RED);
			tg.putString(0, 10, "0- Salir");
			tg.setForegroundColor(TextColor.ANSI.GREEN);
			tg.putString(0, 12, "Seleccione una opcion");
			screen.refresh();
			KeyStroke eleccion = terminal.pollInput();
			if (eleccion != null) {
				switch(eleccion.getCharacter()) {
					case '0':
						keepRunning = false;
						break;
					case '1':
						this.altaJugador();
					case '2':
				default:
					break;
				}
			}
		}
		screen.readInput();
		screen.stopScreen();
	}
	
	public void altaJugador() throws Exception {
		Terminal terminalAltaJugador = new DefaultTerminalFactory().createTerminal();
		screenAltaJugador = new TerminalScreen(terminalAltaJugador);
		screenAltaJugador.startScreen();
		TextGraphics tg = screenAltaJugador.newTextGraphics();
		tg.setForegroundColor(TextColor.ANSI.BLUE);
		tg.putString(0, 0, "Alta de jugador");
		tg.setForegroundColor(TextColor.ANSI.GREEN);
		tg.putString(0, 2, "Ingrese nombre del jugador");
		screenAltaJugador.refresh();
		boolean keepRunning = true;
		StringBuilder sb = new StringBuilder();
		while(keepRunning) {
			KeyStroke eleccion = terminalAltaJugador.pollInput();
			if (eleccion != null) {
				switch (eleccion.getKeyType()) {
				case Character:
					sb.append(eleccion.getCharacter());
					break;
				case Enter:
					keepRunning = false;
					this.controlador.juegoAgregarJugador(sb.toString());
					break;
				default:
					break;
				}
			}
		}
		screenAltaJugador.readInput();
		screenAltaJugador.stopScreen();
		screenAltaJugador.close();
	}
	
	public void iniciar() throws Exception {
		TextGraphics text = screen.newTextGraphics();
		text.setForegroundColor(TextColor.ANSI.BLUE);
		text.setBackgroundColor(TextColor.ANSI.WHITE);
		text.putString(0,0, "Conecta4");
		screen.refresh();
		this.menuPrincipal();
	}
	
	@Override
	public void actualizarListaDeJugadoresEnLaPartida(List<String> jugadores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void habilitarInicioDeJuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarJugadorActual(String jugadorActual, int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarFinalDelJuego(String ganador, int victorias) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void errorAlAgregarJugador() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jugadorUnoJugando() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jugadorDosJugando() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void noListoParaIniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnaLlena() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ultimaFichaJugada(int yFila, int xColumna, String color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void empate() {
		// TODO Auto-generated method stub
		
	}

}
