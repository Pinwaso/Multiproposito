package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Manias tenemos todos Es el ejercicio 175 de Acepta el reto
 * 
 * @author William Andrés
 * @version 18.11.2025
 */
public class manias_tenemos_todos_175 {
	static Scanner entrada = new Scanner(System.in); 
	
	public static void main(String args[]) {
		int numCasosDePrueba = entrada.nextInt();
		entrada.nextLine();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}
	
	private static void casoDePrueba() {
		int[] dias = new int[7];
		int semanas = entrada.nextInt();
		entrada.nextLine();
		for (int i = 0; i < semanas; i++) {
			String linea = entrada.nextLine();
			for (int a = 0; a < 7; a++) {
				if (linea.charAt(a) == '*') {
					dias[a]=dias[a]+1;
				}
			}
		}
		int minimo = Integer.MAX_VALUE, posicion = 0;
		for (int i = 0; i < 7; i++) {
			if (dias[i] < minimo) {
				minimo = dias[i];
				posicion = i;
			}
		}
		System.out.println("LMXJVSD".charAt(posicion) + " " + (dias[posicion]+1));
	}
}