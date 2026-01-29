package competitivo;

import java.util.Scanner;

/**
 * Caramelos de reyes Es el ejercicio 426 de Acepta el reto
 * 
 * @author William Andrés
 * @version 30.10.2025
 */
public class caramelos_de_reyes_426 {
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
			int resultado = numero, ninos = 0;
			while (numero != 0) {
				numero = entrada.nextInt();
				resultado += numero;
				ninos++;
			}
			if (resultado % ninos == 0) {
				System.out.println("REPARTO JUSTO");
			} else {
				System.out.println("IMPOSIBLE");
			}
			return true;
		}
	}
}