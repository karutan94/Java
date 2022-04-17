package tp3;

public abstract class Electrodomestico {
	
	private String codigo;
	private double precio;
	private String color;
	private char clase;
	private float peso;
	
	//Constructor por defecto
	public Electrodomestico() {												
		this.color = "BLANCO";
		this.clase = 'F';
		this.precio = 1700;
		this.peso = 5;
	}
	
	//Constructor con precio y peso
	public Electrodomestico(double precio, float peso) {
		//Llama al constructor
		this();																
		this.precio = precio;
		this.peso = peso;
	}
	
	//Constructor con parametros definidos
	public Electrodomestico(String codigo, double precio, String color, char clase, float peso) {
		//Llama al constructor con precio y peso
		this(precio, peso);										
		this.codigo = codigo;
		this.color = color;
		this.clase = clase;
	}
	
	public abstract String getCodigo();
	
	public abstract String setCodigo(String codigo);	
	
	public double getPrecio() {
		return precio;
	}
	
	//Valida que el precio sea mayor a 0
	public void setPrecioBase(double precio) {
		if (precio<0) {
			this.precio = 1700;
		}
		else {
			this.precio = precio;
		}
	}
	public String getColor() {
		return color;
	}
	
	//Valida el color y lo asigna
	public void setColor(String color) {								
		String colorMayuscula = color.toUpperCase();
		if ((colorMayuscula != "BLANCO") && (color != "NEGRO") && (color != "ROJO") && (color != "AZUL") && (color != "GRIS")) {
			this.color = "BLANCO";
		}
		else {
			this.color = color;
		}
	}
	public char getClase() {
		return clase;
	}
	
	//Valida la clase y la asigna
	public void setClase(char clase) {									
		char claseMayuscula = Character.toUpperCase(clase);
		if ((claseMayuscula != 'A') && (claseMayuscula != 'B') && (claseMayuscula != 'C') && (claseMayuscula != 'D') && (claseMayuscula != 'E') && (claseMayuscula != 'F')){
			this.clase = 'F';
		}
		else {
			this.clase = clase;
		}
	}
	
	public float getPeso() {
		return peso;
	}
	
	//Valida que el peso sea mayor a 0
	public void setPeso(float peso) {
		if (peso<0) {
			this.peso = 5;
		}
		else {
			this.peso = peso;
		}
	}
	
	//Calcula el precio de venta del producto
	public double getVenta() {
		double multiplicador = 0;
		switch (clase) {
		case 'A':
			multiplicador = 4;
		case 'B':
			multiplicador = 3.5;
		case 'C':
			multiplicador = 3;
		case 'D':
			multiplicador = 2.5;
		case 'E':
			multiplicador = 2;
		case 'F':
			multiplicador = 1;
		}
		double venta = precio * multiplicador;
		if ((peso>=0) || (peso>=19)){
			venta = venta * 1.1;
		}
		if ((peso>=20) || (peso>=49)){
			venta = venta * 1.5;
		}
		if ((peso>=50) || (peso>=79)){
			venta = venta * 1.8;
		}
		if (peso>=80){
			venta = venta + venta;
		}
		return venta;
	}
}
