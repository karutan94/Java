package observer;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Observable {

		protected Collection<Observador> observadores;
		
		public void notificar(Object arg) {
			for (Observador observador : observadores) {
				observador.actualizar(this, arg);
			}
		}
		
		public void agregarObservador(Observador nuevoObservador) {
			this.observadores.add(nuevoObservador);
		}
		
		public Observable() {
			this.observadores = new ArrayList<Observador>();
		}
}
