package competitivo;

import java.util.Scanner;

/**
 * Hay suficientes Es el ejercicio 715 de Acepta el reto
 * 
 * @author William Andrés
 * @version 27.10.2025
 */
public class hay_suficientes_715 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int uvas = entrada.nextInt();
		int gente = entrada.nextInt();
		System.out.println((gente*12) <= uvas ? "SI" : "NO");
	}
}
