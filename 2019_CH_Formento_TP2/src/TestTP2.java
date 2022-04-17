
public class TestTP2 {

	public static void main(String[] args) {
		TP2 tp2 = new TP2();
		//Numeros primos
		tp2.calcularPrimos(7);
		//Numeros perfectos
		tp2.calcularPerfectos(30);
		//Calcula factorial
		int numero = 5;
		System.out.println("El factorial de " + numero + " es " + tp2.calcularFactorial(numero));
		//Calcular Fibonacci
		tp2.calcularFibonacci(8);
		//Establecer arreglo de enteros
		int[] elementos = {1,5,-1,2,1,-4};
		tp2.setVector(elementos);
		//Calcula positivos
		tp2.calcularPositivos();
		//Cuenta cuantos mayores que un numero dado hay
		System.out.println(tp2.contarMayoresQue(2));
		//Calcula el mayor dentro de un arreglo
		System.out.println(tp2.calcularMayor());
		//Devuelve los que mas se repiten dentro de un arreglo
		tp2.mayorFrecuencia();
		//Devuelve la media de un arreglo
		System.out.println("La media del arreglo es " + tp2.media());
		//Devuelve el desvio de cada numero de un arreglo
		tp2.desvio();
		//Devuelve un numero a buscar
		System.out.println(tp2.buscarEn(-4));
		//Establecer arreglo de strings
		String[] cadenas = {"Texto 1","Otro texto","Hola","mundo"};
		tp2.setVectorString(cadenas);
		//Busca un string pasado
		System.out.println(tp2.buscarEnString("Texto 1"));
		System.out.println("Pausa al programa");
	}
}
