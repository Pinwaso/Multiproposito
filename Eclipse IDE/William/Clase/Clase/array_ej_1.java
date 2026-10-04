package Clase.Clase;

import java.util.Arrays;
import java.util.Scanner;

// Crea un generador de matrices aleatorias, que sea capaz de crear una matriz 
// cuadrada, se deberá pasar el tamaño de la matriz como parámetro y el valor máximo 
// que podrá tener cada uno de los elementos de la matriz.

public class array_ej_1 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		boolean correcto = false;
		int valor = pedirvalor("Ingrese el tamaño de la matriz", "Valor invalido");
		int maximo = pedirvalor("Ingrese el valor maximo", "Valor invalido");
		int[][] matriz = array(valor, maximo);
		mostrararray(matriz);
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

	static int[][] array(int valor, int maximo) {
		int[][] matriz = new int[valor][valor];
		for (int a = 0; a < matriz.length; a++) {
			for (int b = 0; b < matriz[a].length; b++) {
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