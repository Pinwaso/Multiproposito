package competitivo;

import java.util.Scanner;

/**
 * Nombre del ejercicio Es el ejercicio ??? de Acepta el reto
 * 
 * @author William Andrés
 * @version dd.mm.aaaa
 */
public class plantilla {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		entrada.nextLine();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		// caso do prueba
	}
}