package Clase.Clase;
import java.util.Arrays;
import java.util.Scanner;
// en un array de 6x6, se tiene que mostrar la palabra
public class array_5 {
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		char array[][] = new char[6][6];
		array = rellenararray(array);
		String palabra = pedirpalabra();
		int y = pedirnumero("Ingrese la fila horizontal", "valor invalido");
		int x = pedirnumero("Ingrese la fila vertical", "valor invalido");
		System.out.println("horizontal? (true) vertical? (false)");
		boolean opcion = entrada.nextBoolean();
		if (opcion) {
			mostrararray(rellenarpalabraarrayhorizontal(array, x, y, palabra));
		} else {
			mostrararray(rellenarpalabraarrayvertical(array, x, y, palabra));
		}
	}
	
	static char[][] rellenararray(char[][] array) {
		for (int a = 0 ; a < array.length ; a++) {
			for (int b = 0 ; b < array[a].length ; b++) {
				array[a][b] = ' ';
			}
		}
		return array;
	}
	
	static int longitud(char[][] array, int longitud) {
		if ((longitud) >= array.length ) {
			longitud = array.length;
		}
		return longitud;
	}
	
	static char[][] rellenarpalabraarrayhorizontal(char[][] array, int x, int y, String palabra) {
		int posicion = 0, longitud = palabra.length() + x;
		longitud = longitud(array, longitud);
		for (int a = x ; a < longitud ; a++, posicion++) {
			array[y][a] = palabra.charAt(posicion);
		}
		return array;
	}
	
	static char[][] rellenarpalabraarrayvertical(char[][] array, int x, int y, String palabra) {
		int posicion = 0, longitud = palabra.length() + y;
		longitud = longitud(array, longitud);
		for (int a = x ; a < longitud ; a++, posicion++) {
			array[a][y] = palabra.charAt(posicion);
		}
		return array;
	}
	
	static void mostrararray (char[][] array) {
		for (char[] fila : array) {
			System.out.println(Arrays.toString(fila));
		}
	}
	
	static String pedirpalabra() {
		System.out.println("Ingrese una palabra");
		String palabra = entrada.next();
		return palabra;
	}
	
	static int pedirnumero(String mensaje, String error) {
		boolean correcto = false;
		int valor = 0;
		do {
			try {
				System.out.println(mensaje);
				valor = entrada.nextInt();
				correcto = true;
			} catch (Exception ex) {
				System.out.println(error);
				entrada.nextLine();
			}
		} while (!correcto);
		return valor;
	}
}