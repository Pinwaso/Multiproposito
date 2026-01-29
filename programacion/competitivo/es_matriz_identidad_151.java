package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ¿Es matriz identidad? Es el ejercicio 151 de Acepta el reto
 * 
 * @author William Andrés
 * @version 11.11.2025
 */
public class es_matriz_identidad_151 {
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
			for (int a = 0; a < numero; a++) {
				int numeros[] = new int[numero];
				for (int b = 0; b < numero; b++) {
					numeros[b] = entrada.nextInt();
				}
				for (int b = 0; b < numeros.length; b++) {
					if (b == a) {
						if (numeros[b] != 1) {
							mensaje = "NO";
						}
					} else {
						if (numeros[b] != 0) {
							mensaje = "NO";
						}
					}
				}
			}
			System.out.println(mensaje);
			return true;
		}
	}
}