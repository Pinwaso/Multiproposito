package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Senda pirenaica Es el ejercicio 485 de Acepta el reto
 * 
 * @author William Andrés
 * @version 11.11.2025
 */
public class senda_pirenaica_485 {
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
			int distancias[] = new int[numero];
			for (int a = 0; a < numero; a++) {
				distancias[a] = entrada.nextInt();
			}
			String mensaje = "";
			for (int a = 0; a < distancias.length; a++) {
				int total = 0;
				for (int b = a; b < distancias.length; b++) {
					total += distancias[b];
				}
				mensaje += " " + total; 
			}
			System.out.println(mensaje.substring(1));
			return true;
		}
	}
}