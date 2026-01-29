package competitivo;

import java.util.Scanner;

/**
 * La pieza perdida Es el ejercicio 168 de Acepta el reto
 * 
 * @author William Andrés
 * @version 28.10.2025
 */
public class la_pieza_perdida_168 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int total = entrada.nextInt(); 
		if (total == 0) { 
			return false;
		} else {
			int array[] = new int[total];
			for (int i = 0 ; i < array.length - 1 ; i++) {
				int numero = entrada.nextInt();
				array[numero-1] = numero;
			}
			for (int a = 0 ; a < array.length ; a++) {
				if (array[a] == 0) {
					System.out.println(a+1);
				}
			}
			return true;
		}
	}
}
