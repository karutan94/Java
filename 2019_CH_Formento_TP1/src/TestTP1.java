public class TestTP1 {

	public static void main(String[] args) {
		TP1 tp1 = new TP1();
		System.out.println("El área del rectángulo es " + tp1.calcularAreaRectangulo(2.00, 4.00));
		System.out.println("El perimetro del rectángulo es " + tp1.calcularPerimetroRectangulo(2.00, 4.00));
		double metros = 1;
		System.out.println(metros + " metros son " + tp1.convertirMetroAPulgada(metros) + " pulgadas");
		System.out.println("El área del rombo es " + tp1.calcularAreaRombo(1.345, 4.567));
		System.out.println("La velocidad del automóvil es de " + tp1.velocidadAutomovil(30, 30, 56, 356.123) + "km/h");
		int numero = 3975;
		System.out.println("La suma de las cifras del numero " + numero + " es " + tp1.sumarCifras(numero));
		tp1.establecerResultados(50, 34, 1);
		System.out.println("Porcentaje de aprobados " + tp1.determinarAprobados());
		System.out.println("Porcentaje de desaprobados " + tp1.determinarDesaprobados());
		System.out.println("Porcentaje de ausentes " + tp1.determinarAusentes());
		System.out.println("La hipotenusa del triángulo rectángulo es" + tp1.hipotenusa(2.451, 9.567));
		System.out.println("El perimetro del triángulo equilatero es " + tp1.perimetroTEquilatero(5.95));
		System.out.println("El área del triángulo equilatero es " + tp1.areaTEquilatero(5.95));
	}
}
