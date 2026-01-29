package competitivo;

import java.util.Scanner;

/**
 * Pasos en la escalera Es el ejercicio 736 de Acepta el reto
 * 
 * @author William Andrés
 * @version 28.10.2025
 */
public class pasos_en_la_escalera_736 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		double escalones = entrada.nextInt();
		double veces = entrada.nextInt();
		System.out.println((int)Math.ceil(escalones / veces));
	}
}
