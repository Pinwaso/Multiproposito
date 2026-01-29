package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Saliendo de la crisis Es el ejercicio 247 de Acepta el reto
 * 
 * @author William Andrés
 * @version 11.11.2025
 */
public class saliendo_de_la_crisis_247 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int numero = entrada.nextInt();
		if (numero == 0) {
			return false;
		} else {
			String mensaje = "SI";
			int numeros[] = new int[numero];
			for (int i = 0 ; i < numero; i++) {
				numeros[i] = entrada.nextInt();
			}
			for (int b = 0; b < numeros.length-1; b++) {
				if (numeros[b] > numeros[b+1] || numeros[b] == numeros[b+1]) {
					mensaje = "NO";
				}
			}
			System.out.println(mensaje);
			return true;
		}
	}
}
