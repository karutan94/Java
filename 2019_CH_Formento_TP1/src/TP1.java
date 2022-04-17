public class TP1 {
	
	//Calcula el area de un rectangulo
	public double calcularAreaRectangulo(double base, double altura) {
		return (base<=0 || altura<=0)?(0.0):(base * altura);  
	}
	
	//Calcula el perimetro de un rectangulo
	public double calcularPerimetroRectangulo(double base, double altura) {
		return (base<=0 || altura<=0)?(0.0):(2 * (base + altura));
	}
	
	//Convierte de metros a pulgadas
	public double convertirMetroAPulgada(double metros) {
		if (metros>=0) {
			double milimetros = metros * 1000;
			double pulgadas = milimetros / 25.4;
			return pulgadas;
		}
		else {
			double pulgadas = 0.0;
			return pulgadas;
		}			
	}
	
	//Calcula el area de un rombo
	public double calcularAreaRombo(double d1, double d2) {
		return (d1<=0 || d2<=0)?(0.0):((d1*d2)/2);
	}
	
	//Calcula la velocidad de un automovil en km/h
	public double velocidadAutomovil(int minutos, int segundos, int centesimas, double metros) {
		double velocidad = 0.0;
		if (minutos<0 || segundos<0 || segundos>60 || centesimas<0 || centesimas>100) {
			return velocidad;
		}
		else {
			double km = 0.00;
			double hora = 0.00;
			hora = (minutos*60) + (segundos) + (centesimas/100);		//Convierto todo en segundos
			hora = (hora/3600);											//Convierto los segundos a horas
			km = metros/1000;
			return velocidad = km/hora;
		}
	}
	
	//Sumar cifras
	public int sumarCifras(int numero) {
		int suma = 0;
		if (numero<-9999 || numero>9999) {
			return suma = -1;
		}
		else {
			numero = Math.abs(numero);
			int res = 0;
			while (numero != 0) {
				res = numero % 10;
				numero = numero / 10;
				suma = suma +res;
		}
		}
		return suma;
	}
	
	//Calcula aprobados, desaprobados y ausentes de un grupo de alumnos
	private int alumnos;
	private int aprobados;
	private int desaprobados;
	private int ausentes;
	
	public void establecerResultados(int alumnos, int aprobados, int desaprobados) {
		this.alumnos = alumnos;
		this.aprobados = aprobados;
		this.desaprobados = desaprobados;
		this.ausentes = ((alumnos - aprobados - desaprobados)<0)?(0):(alumnos - aprobados - desaprobados);
	}
	
	public double determinarAprobados() {
		if (alumnos>0 && alumnos==(aprobados+desaprobados+ausentes)) {
			return (aprobados*100)/alumnos;
		}
		else
			return -1;
	}
	
	public double determinarDesaprobados() {
		if (alumnos>0 && alumnos==(aprobados+desaprobados+ausentes)) {
			return (desaprobados*100)/alumnos;
		}
		else
			return -1;
	}
	
	public double determinarAusentes() {
		if (alumnos>0 && alumnos==(aprobados+desaprobados+ausentes)) {
			return (ausentes*100)/alumnos;
		}
		else
			return -1;
	}
	
	
	//Calcula la hipotenusa de un triangulo rectangulo
	public double hipotenusa(double c1, double c2) {
		double h = 0.0;
		if (c1<0 || c2<0) {
			return h;
		}
		else {
			h = Math.pow(c1, 2) + Math.pow(c2, 2);
			return h = Math.sqrt(h);
		}
	}

	public double perimetroTEquilatero(double lado) {
		return (lado<=0)?(0.0):(lado * 3);
	}
	
	public double areaTEquilatero(double lado) {
		double area = 0.0;
		if (lado<=0) {
			return area;
		}
		else
			area = (Math.sqrt(3)) / 4;
			return area = area * Math.pow(lado, 2);
	}

}
