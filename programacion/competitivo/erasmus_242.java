package competitivo;

import java.util.Scanner;

/**
 * Erasmus Es el ejercicio 242 de Acepta el reto
 * 
 * @author William Andrés
 * @version 19.11.2025
 */
public class erasmus_242 {
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
			for (int i = 0; i < numero; i++) {
				
			}
			return true;
		}
	}
}