package Clase.Clase;

import java.util.Scanner;
import java.util.Arrays;

public class William_andres_prueba {
	static int[][] tablero;
	static int[] numeros;
	static int filas;
	static int columnas;
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		if (inicializarTablero()) {
			rellenarTablero();
			mostrarTablero();
			System.out.println(Arrays.toString(numeros));
			System.out.println(opcionMasRepetida());
		} else {
			System.out.println("Insuficiente");
		}
	}
	
	public static void rellenarTablero() {
		int totalmas = 0;
		for (int a = 0; a < tablero.length-1; a++) {
			int total = 0;
			for (int b = 0; b < tablero[a].length-1; b++) {
				boolean correcto = false;
				do {
					int numero = random(filas, columnas);
					if (numeros[numero] == 0) {
						tablero[a][b] = numero;
						total += numero;
						numeros[numero]++;
						correcto = true;
					} else {
						numeros[numero]++;
					}
				} while (!correcto);
				if (b == tablero[a].length-2) {
					totalmas += total;
					tablero[a][tablero[a].length-1] = total;
				}
			}
		}
		for (int a = 0; a < columnas-1; a++) {
			int total = 0;
			for (int b = 0; b < filas-1; b++) {
				total += tablero[b][a];
				if (b == filas-2) {
					totalmas += total;
					tablero[filas-1][a] = total;
				}
			}
		}
		tablero[filas-1][columnas-1] = totalmas;
	}
	
	public static String opcionMasRepetida() {
		String mensaje = "";
		int maximo = Integer.MIN_VALUE, digito = 0, apariciones = 0;
		for (int a = 0; a < numeros.length ; a++) {
			if (numeros[a] > maximo) {
				maximo = a;
				apariciones = 1;
				mensaje = (","+a);
			} else if (numeros[a] == maximo) {
				apariciones++;
				mensaje += (","+a);
			}
		}
		return "Los números que más veces han salido han sido: " + mensaje.substring(1) + " con " + apariciones + " apariciones";
	}
	
	public static boolean inicializarTablero() {
		filas = pedirnumero("Ingrese la cantidad de filas", "Valor inválido");
		columnas = pedirnumero("Ingrese la cantidad de columnas", "Valor inválido");
		if (filas < 2 || columnas < 2) {
			return false;
		} else {
			numeros = new int[filas*columnas];
			tablero = new int[filas][columnas];
			return true;
		}
	}
	
	public static void mostrarTablero() {
		for (int[] fila : tablero) {
			System.out.println(Arrays.toString(fila));
		}
	}
	
	static int random(int filas, int columnas) {
		int maximo = filas*columnas;
		int numero = (int) (Math.random() * maximo);
		return numero;
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