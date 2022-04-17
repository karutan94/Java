import java.util.ArrayList;


public class TP2 {
	
	//Calcula los numeros primos anteriores a un numero dado
	
	private ArrayList<Integer> primos = new ArrayList<Integer>();
	
	public int[] calcularPrimos(int numero) {
		while (numero>1) {
			numero = numero - 1;
			if ((Math.pow(2, numero-1)) % numero == 1) {	//Utilizo el teorema de Fermat para calcular los numeros primos
				primos.add(numero);				
				}
			if (numero==2) {			//Si el numero es 2 no me lo agrega porque el modulo es 0, entonces lo agrego manualmente
				primos.add(2);							
			}
		}
		int arregloprimos[] = primos.stream().mapToInt(in -> in).toArray();
		return arregloprimos;
	}
	
	//Calcula los numeros perfectos anteriores a un numero dado
	
	private ArrayList<Integer> perfectos = new ArrayList<Integer>();
	
	public int[] calcularPerfectos(int numero) {
		int suma, i;
		for (i=numero; i>1; i--) {
			suma = 0;
			for(int divisor=1; divisor<i; divisor++){  // Se divide desde 1 hasta i-1 
                if(i % divisor == 0){
                   suma = suma + divisor;     // si es divisor se suma
                }
			}
			if (i==suma){           //Si el numero es igual a la suma de sus divisores es perfecto
				perfectos.add(i);
			}
		}
		int arregloperfectos[] = perfectos.stream().mapToInt(in -> in).toArray();
		return arregloperfectos;
	}
	
	//Calcula el factorial
	
	public int calcularFactorial(int numero) {
		if (numero==0) {
			return 1;
		}
		else
			return numero * calcularFactorial(numero - 1);
	}
	
	//Calcula Fibonacci
	
	private ArrayList<Integer> fibonacci = new ArrayList<Integer>();
	
	public int[] calcularFibonacci(int numero) {
		if (numero==0) {
			fibonacci.add(0);
		}
		if (numero==1) {
			fibonacci.add(0);
			fibonacci.add(1);
		}
		if (numero>1) {
			fibonacci.add(0);
			fibonacci.add(1);
			for (int i=2; i<numero; i++) {
				int suma = fibonacci.get(i-1) + fibonacci.get(i-2);
				fibonacci.add(i, suma);
			}	
		}
		int arreglofibonacci[] = fibonacci.stream().mapToInt(in -> in).toArray();
		return arreglofibonacci;
	}
	
	//Establecer arreglo de enteros
	
	private ArrayList<Integer> arreglo = new ArrayList<Integer>();
	
	public void setVector(int[] elementos) {
		for (int i = 0; i<elementos.length; i++) {
			arreglo.add(elementos[i]);
		}
	}
	
	//Calcular positivos de un arreglo
	
	private ArrayList<Integer> positivos = new ArrayList<Integer>();
	
	public int[] calcularPositivos() {
		for (int i=0; i<arreglo.size(); i++) {
			if (arreglo.get(i)>0) {
				positivos.add(arreglo.get(i));
			}
		}
		int[] arregloPositivos = positivos.stream().mapToInt(in -> in).toArray();
		return arregloPositivos;
	}
	
	//Cuenta cuantos mayores que un numero dado hay

	public int contarMayoresQue(int numero) {
		int mayores = 0;
		for (int i=0; i<arreglo.size(); i++) {
			if (arreglo.get(i)>numero) {
				mayores++;
			}
		}
		return mayores;
	}
	
	//Calcula el mayor dentro del arreglo
	
	public int calcularMayor() {
		int mayor;
		mayor = arreglo.get(0);
		for (int i=1; i<arreglo.size(); i++) {
			if (arreglo.get(i)>mayor) {
				mayor = arreglo.get(i);
			}
		}
		return mayor;
	}
	
	//Devuelve un arreglo de numeros con los de mayor frecuencia
	
	private ArrayList<Integer> mayorfrecuencia = new ArrayList<Integer>();
	
	public int[] mayorFrecuencia() {
		int numero;
		int contador = 0;
		int repetotal = 0;
		for (int i=0; i<arreglo.size(); i++) {
			numero = arreglo.get(i);
			for (int j=i+1; j<arreglo.size();  j++) {
				if (numero==arreglo.get(j)) {
					contador++;
				}
			}
			if (contador==repetotal) {
				mayorfrecuencia.add(numero);
			}
			if (contador>repetotal) {
				mayorfrecuencia.clear();
				mayorfrecuencia.add(numero);
				repetotal = contador;
			}
			contador = 0;
		}
		int[] arreglomayorfrecuencia = mayorfrecuencia.stream().mapToInt(in -> in).toArray();
		return arreglomayorfrecuencia;
	}
	
	//Calcula la media del arreglo
	public double media() {
		int suma = 0;
		double doublemedia = arreglo.size();
		for (int i=0; i<arreglo.size(); i++) {
			suma = suma + arreglo.get(i);
		}
		doublemedia = suma/doublemedia; 
		return doublemedia;
	}
	
	//Devuelve un arreglo con el desvio de cada numero
	
	private ArrayList<Double> desvio = new ArrayList<Double>();
	
	public double[] desvio() {
		double doubledesvio;
		double media = media();
		for (int i=0; i<arreglo.size(); i++) {
			doubledesvio = 0;
			doubledesvio = arreglo.get(i) - media;
			desvio.add(i, doubledesvio);
		}
		double[] arreglodesvio = desvio.stream().mapToDouble(db -> db).toArray();
		return arreglodesvio;
	}
	
	//Devuelve un numero a buscar
	public int buscarEn(int numero) {
		boolean flag = false;
		for (int i=0; i<arreglo.size(); i++) {
			if (numero==arreglo.get(i)) {
				flag=true;
			}
		}
		if (flag==true) {
			return numero;
		}
		else {
			return 0;
		}
	}
	
	//Establecer arreglo de string
	
	private ArrayList<String> arraystring = new ArrayList<String>();
	
	public void setVectorString(String[] cadenas) {
		for (int i=0; i<cadenas.length; i++) {
			arraystring.add(cadenas[i]);
		}
	}
	
	//Busca un string pasado
	
	public String buscarEnString(String texto) {
		boolean flag = false;
		for (int i=0; i<arraystring.size(); i++) {
			if (texto==arraystring.get(i)) {
				flag = true;
			}
		}
		if (flag==true) {
			return texto;
		}
		else {
			return null;
		}
	}
}