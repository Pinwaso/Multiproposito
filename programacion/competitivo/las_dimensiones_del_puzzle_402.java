package competitivo;

import java.util.Scanner;

/**
 * Las dimensiones del puzzle Es el ejercicio 402 de Acepta el reto
 * 
 * @author William Andrés
 * @version 29.10.2025
 */
public class las_dimensiones_del_puzzle_402 {
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
			int divisor = (int)Math.floor(Math.sqrt(numero));
			while (numero % divisor != 0) {
				divisor--;
			}
			int divisor2 = numero / divisor;
			System.out.println(Math.max(divisor2, divisor));
			return true;
		}
	}
}
