package competitivo;

import java.util.Scanner;

/**
 * ¿Que lado de la calle? Es el ejercicio 217 de Acepta el reto
 * 
 * @author William Andrés
 * @version 28.10.2025
 */
public class que_lado_de_la_calle_217 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int numero = entrada.nextInt();
		if (numero == 0) {
			return false;
		}
		if (numero % 2 == 0) {
			System.out.println("DERECHA");
		} else {
			System.out.println("IZQUIERDA");
		}
		return true;
	}

}
