package competitivo;

import java.util.Scanner;

/**
 * Metidos en un cajon el ejercicio 682 de Acepta el reto
 * 
 * @author William Andrés
 * @version 27.10.2025
 */
public class metidos_en_un_cajon_682 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int patos = entrada.nextInt();
		System.out.println(patos + " " + patos*2);
	}
}