package competitivo;

import java.util.Scanner;

/**
 * Cuadrado con cerillas - Ejercicio 340 de Acepta el reto
 * 
 * @author William Andrés
 * @version 21.10.2025
 */

public class cuadrado_cerillas_340 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int base = entrada.nextInt();
		int altura = entrada.nextInt();
		System.out.println((2 * (base * altura)) + base + altura);
	}
}