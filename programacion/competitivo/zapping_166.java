package competitivo;

import java.util.Scanner;

/**
 * Zapping Es el ejercicio 166 de Acepta el reto
 * 
 * @author William Andrés
 * @version 28.10.2025
 */
public class zapping_166 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int programaactual = entrada.nextInt(); 
		int programaobjetivo = entrada.nextInt();
		if (programaactual == 0 && programaobjetivo == 0) { 
			return false;
		} else {
			int adelante = (programaobjetivo - programaactual + 99) % 99;
			int atras = (programaactual - programaobjetivo + 99) % 99;
			System.out.println(Math.min(adelante, atras));
			return true;
		}		
	}
}