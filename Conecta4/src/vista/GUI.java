package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements IVistaDeJuego {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
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
