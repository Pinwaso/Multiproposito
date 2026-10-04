package Clase.Clase;

import java.util.Scanner;
// array de 2 dimensiones, preguntando cuantas filas y columnas
// 3 filas y 2 columnas serian int[3][2]
public class recorrer_array_3 {
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Cuantas filas quiere?");
		int filas = entrada.nextInt();
		System.out.println("Cuantas columnas quiere?");
		int columnas = entrada.nextInt();
		
		int array[][] = new int[filas][columnas];
		
		for (int a = 0 ; a < array.length ; a++) {
			for (int b = 0 ; b < array[a].length ; b++) {
				boolean correcto = false;
				do {
					try {
						System.out.println("Ingrese el numero del array " + "[" + a + "]" + "[" + b + "]");
						array[a][b] = entrada.nextInt();
						correcto = true;
					} catch (Exception ex) {
						entrada.nextLine();
					}
				} while (!correcto);
			}
		}
		for (int[] columna : array) {
			for (int fila : columna) {
				System.out.println(fila + " ");
			}
			System.out.println();
		}
	}
}