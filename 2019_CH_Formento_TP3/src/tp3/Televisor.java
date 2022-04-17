package tp3;

public class Televisor extends Electrodomestico {

	private String codigo;
	private static int numero = 0;
	private int tamanio;
	private boolean sintonizador;

	//Constructor
	public Televisor() {
		super();
		++Televisor.numero;
		this.tamanio = 20;
		this.sintonizador = false;
	}
	
	//Constructor
	public Televisor(double precio, float peso) {
		super(precio,peso);
		++Televisor.numero;
		this.tamanio = 20;
		this.sintonizador = false;
	}
	
	//Constructor
	public Televisor(String codigo, double precio, String color, char clase, float peso, int tamanio, boolean sintonizador) {
		super(codigo,precio,color,clase,peso);
		++Televisor.numero;
		this.tamanio = tamanio;
		this.sintonizador = sintonizador;
	}
	
	@Override
	public String getCodigo() {
		return codigo;
	}

	@Override
	public String setCodigo(String codigo) {		
		String numero = Integer.toString(Televisor.numero);
		int contador = 5 - numero.length();
		codigo = "TEL-";
		if (contador > 0) {
			for (int i = 0; i < contador; i++) {
				codigo = codigo + "0";
			}
			codigo = codigo + numero;
		}
		else {
			codigo = codigo + numero;
		}
		this.codigo = codigo;
		return this.codigo;
	}
	
	public int getTamanio() {
		return tamanio; 
	}

	public void setTamanio(int pulgadas) {
		if (pulgadas>0) {
			this.tamanio = pulgadas;
		}
		else {
			this.tamanio = 20;
		}
	}

	public boolean hasSintonizador() {
		return sintonizador;
	}

	public void setSintonizador(boolean posee) {
		this.sintonizador = posee;
	}

	//Calcula el precio de venta del televisor
	public double getVenta() {
		double precio;
		precio = super.getVenta();
		if (this.tamanio>40) {
			precio = precio * 1.30;
		}
		if (this.sintonizador == true) {
			precio = precio + 1000;
		}
		return precio;
	}
}
