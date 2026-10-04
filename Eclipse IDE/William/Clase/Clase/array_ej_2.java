package Clase.Clase;

import java.util.Arrays;
import java.util.Scanner;

// Ampliar el método anterior para que sea capaz de generar una matriz irregular. Para 
// ello deberemos añadir parámetros adicionales con la cantidad mínima y máxima de 
// filas, y la cantidad mínima y máxima de columnas. Se debe tener en cuenta que 
// cada fila podrá tener una cantidad distinta de elementos.

public class array_ej_2 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		boolean correcto = false;
		int minfilas = pedirvalor("Ingrese la cantidad minima de filas", "Valor invalido");
		int maxfilas = pedirvalor("Ingrese la cantidad maxima de filas", "Valor invalido");
		int mincolumnas = pedirvalor("Ingrese la cantidad minima de columnas", "Valor invalido");
		int maxcolumnas = pedirvalor("Ingrese la cantidad maxima de columnas", "Valor invalido");
		int maximo = pedirvalor("Ingrese el valor maximo", "Valor invalido");

		int[][] matriz = array(mincolumnas, maxcolumnas, minfilas, maxfilas, maximo);
		mostrararray(matriz);
	}

	static int randommatriz(int minimo, int maximo) {
		int numero = (int) (Math.random() * (maximo - minimo + 1) + minimo);
		return numero;
	}

	static int random(int maximo) {
		int numero = (int) ((Math.random() * maximo) + 1);
		return numero;
	}

	static int pedirvalor(String mensaje, String error) {
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

	static int[][] array(int mincolumnas, int maxcolumnas, int minfilas, int maxfilas, int maximo) {
		int[][] matriz = new int[maxcolumnas][maxfilas];
		for (int a = 0; a < randommatriz(mincolumnas, maxcolumnas); a++) {
			for (int b = 0; b < randommatriz(minfilas, maxfilas); b++) {
				matriz[a][b] = random(maximo);
			}
		}
		return matriz;
	}

	static void mostrararray(int[][] array) {
		for (int[] col : array) {
			System.out.println(Arrays.toString(col));
			System.out.println();
		}
	}
}