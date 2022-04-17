package tp3;

import java.util.ArrayList;

public class Almacen {
	
	//ArrayList que contiene electrodomesticos
	private ArrayList<Electrodomestico> electrodomesticos;
	private ArrayList<Integer> cantidades;
	
	public Almacen(){
		this.electrodomesticos = new ArrayList<>();
		this.cantidades = new ArrayList<>();
		/*En electrodomesticos tengo un arreglo que que almacena electrodomestico del tipo lavarropa y televisor
		 * En cantidades guardo la cantidad que hay de un electrodomestico
		 * Ambos arreglos coinciden sus indices
		 * El electrodomestico 0 tiene sus cantidades en la posicion 0 de cantidades
		 */
	}
	
	//Agregar electrodomestico
	public void agregarElectrodomestico(Electrodomestico electrodomestico, int cantidad) {
		int posicion = 0;
		int cantidadActual = 0;
		boolean encontrado = false;
		for (Electrodomestico electrodomestico2 : electrodomesticos) {
			if (electrodomestico2.getCodigo().equals(electrodomestico.getCodigo())) {
				/*Cuando encuentro que el codigo que pasaron como parametro coincide con uno dentro del almacen
				 * busco la posicion en que se encuentra y obtengo la cantidad dentro de esa posicion
				 * le sumo la cantidad de elementos pasados como parametro para agregar
				 * despues al arreglo de cantidades le agrego el stock actualizado
				 */
				cantidadActual = cantidades.get(posicion) + cantidad;
				cantidades.add(posicion, cantidadActual);
				encontrado = true;
			}
			++posicion;
		}
		/*Si no lo encuentra la bandera queda en false entonces lo agrego al final de ambos arreglos
		 */
		if (encontrado == false) {
			electrodomesticos.add(electrodomestico);
			cantidades.add(cantidad);
		}
	}
	
	//Entregar electrodomestico
	public int engregarElectrodomestico(String codigo, int cantidad) {
		int posicion = 0;
		int cantidadActual = 0;
		int entregados = 0;
		boolean encontrado = false;
		for (Electrodomestico electrodomestico : electrodomesticos) {
			if (electrodomestico.getCodigo().equals(codigo)) {
				cantidadActual = cantidades.get(posicion);
				cantidadActual = cantidadActual - cantidad;
				if (cantidadActual<=0) {
					this.cantidades.add(posicion, 0);
					entregados = cantidad + cantidadActual;
				}
				else {
					this.cantidades.add(posicion, cantidadActual);
					entregados = cantidad;
				}
				encontrado = true;
			}
			++posicion;
		}
		if (encontrado == true) {
			return entregados;
		}
		else {
			return 0;
		}
	}
	
	//Reportar stock
	public int reportarStock(String codigo) {
		int posicion = 0;
		int cantidad = 0;
		for (Electrodomestico electrodomestico : electrodomesticos) {
			if (electrodomestico.getCodigo().equals(codigo)) {
				cantidad = cantidades.get(posicion);
			}
			++posicion;
		}
		return cantidad;
	}
	
	//Valorizar stock
	public double valorizarStock() {
		int posicion = 0;
		double precio = 0;
		int cantidad = 0;
		double valorizacion = 0;
		for (Electrodomestico electrodomestico : electrodomesticos) {
			precio = electrodomestico.getPrecio();
			cantidad = cantidades.get(posicion);
			valorizacion = valorizacion + (cantidad * precio);
			++posicion;
		}
		return valorizacion;
	}
	
	//Valorizar stock por clase
	public double valorizarStock(char clase) {
		int posicion = 0;
		double precio = 0;
		int cantidad = 0;
		double valorizacion = 0;
		for (Electrodomestico electrodomestico : electrodomesticos) {
			if (electrodomestico.getClase() == clase) {
				precio = electrodomestico.getPrecio();
				cantidad = cantidades.get(posicion);
				valorizacion = valorizacion + (cantidad * precio);
			}
			++posicion;
		}
		return valorizacion;
	}
	
	//Valorizar stock por tipo
	public double valorizarStock(String tipo) {
		int posicion = 0;
		double precio = 0;
		int cantidad = 0;
		double valorizacion = 0;
		String tipoABuscar;
		tipo = tipo.toUpperCase();
		for (Electrodomestico electrodomestico : electrodomesticos) {
			tipoABuscar = electrodomestico.getCodigo().substring(0, 3);
			if (tipo == tipoABuscar) {
				precio = electrodomestico.getPrecio();
				cantidad = cantidades.get(posicion);
				valorizacion = valorizacion + (cantidad * precio);
			}
			++posicion;
		}
		return valorizacion;
	}
}
