package competitivo;

import java.util.Scanner;

/**
 * Racimos de uvas Es el ejercicio 433 de Acepta el reto
 * 
 * @author William Andrés
 * @version 30.10.2025
 */
public class racimos_de_uvas_433 {
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
			int total = 0, resultado = 0, niveles = 0;
			while (total <= numero) {
				resultado += 1;
				total += resultado;
				niveles++;
				if (total == numero) break;
			}
			System.out.println(niveles);
			return true;
		}
	}
}