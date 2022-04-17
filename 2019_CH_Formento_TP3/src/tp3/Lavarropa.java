package tp3;

public class Lavarropa extends Electrodomestico {

	private String codigo;
	private static int numero = 0;
	private float carga;

	//Constructor
	public Lavarropa() {
		super();
		++Lavarropa.numero;
		this.setCodigo(codigo);
		this.carga = 5;
	}
	
	//Constructor
	public Lavarropa(double precio, float peso) {
		super(precio,peso);
		++Lavarropa.numero;
		this.setCodigo(codigo);
		this.carga = 5;
	}
	
	//Constructor
	public Lavarropa(String codigo, double precio, String color, char clase, float peso, float carga) {
		super(codigo,precio,color,clase,peso);
		++Lavarropa.numero;
		this.setCodigo(codigo);
		this.carga = carga;
	}

	@Override
	public String getCodigo() {
		return codigo;
	}
	
	@Override
	public String setCodigo(String codigo) {
		String numero = Integer.toString(Lavarropa.numero);
		int contador = 5 - numero.length();
		codigo = "LAV-";
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
	
	public float getCarga() {
		return carga;
	}

	public void setCarga(float carga) {
		if (carga>0) {
			this.carga = carga;
		}
		else {
			this.carga = 5;
		}
	}
	
	//Calcula el precio de venta del lavarropa
	public double getVenta() {
		double precio;
		float carga = this.carga;
		float porcentaje = 0;
		precio = super.getVenta();
		if (carga<=30) {
			return precio;
		}
		else {
			carga = carga - 30;
			while (carga>0) {
				carga = carga - 10;
				++porcentaje;
			}
			porcentaje = porcentaje * 10;
			double porcentajeAdicional = (precio * porcentaje) / 100;
			precio = precio + porcentajeAdicional;
			return precio;
		}
	}
}
