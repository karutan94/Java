import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Aplicacion {

	public static void main(String[] args) throws Exception {
		Tablero t = new Tablero();
		t.agregarFicha(0, 0, "rojo");
		t.agregarFicha(0, 1, "azul");
		t.agregarFicha(1, 0, "azul");
		t.agregarFicha(1, 1, "rojo");
		System.out.println("Se va a guardar el tablero");
		//Guardar archivo
		FileOutputStream fileOut=new FileOutputStream("tablero.obj");
		ObjectOutputStream salida=new ObjectOutputStream(fileOut);
		salida.writeObject(t);
		salida.writeObject(t);
		salida.close();
		System.out.println("Se va a resetear el tablero");
		System.out.println("Tablero reseteado");
		//Leer archivo
		FileInputStream fileIn=new FileInputStream("tablero.obj");
		ObjectInputStream entrada=new ObjectInputStream(fileIn);
		
		while(fileIn.available() != 0) {
			Tablero obj1=(Tablero)entrada.readObject();
			t = obj1;
			System.out.println("Tablero cargado");
		}
		entrada.close();
		
	}
}
