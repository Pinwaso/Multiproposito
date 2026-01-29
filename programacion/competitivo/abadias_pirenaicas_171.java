package competitivo;

import java.util.Scanner;
/**
 * Abadías pirenaicas Es el número 171 de Acepta el reto
 * 
 * @author Nadie
 * @version 03.11.2025
 */
public class abadias_pirenaicas_171 {
	static java.util.Scanner entrada;

	public static void main(String args[]) {
		entrada = new java.util.Scanner(System.in);
		while (casoDePrueba()) {
		}
	}
	private static boolean casoDePrueba() {
		int numMontes = entrada.nextInt();
		if (numMontes == 0) {
			return false;
		}
		int[] montes = new int[numMontes];
		for (int i = 0; i < numMontes; i++) {
			montes[i] = entrada.nextInt();
		}
		int numAbadias = 0;
		int maxAltura = 0;
		for (int i = numMontes - 1; i >= 0; i--) {
			if (montes[i] > maxAltura) {
				numAbadias++;
				maxAltura = montes[i];
			}
		}
		System.out.println(numAbadias);
		return true;
	}
}