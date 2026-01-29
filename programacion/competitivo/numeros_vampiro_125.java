package competitivo;

import java.util.Scanner;

/**
 * Números Vampiro Es el ejercicio 125 de Acepta el reto
 * 
 * @author William Andrés
 * @version dd.mm.aaaa
 */
public class numeros_vampiro_125 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {

		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int numero = entrada.nextInt();
		int longitud = String.valueOf(numero).length();
		int numeros[] = new int[longitud];
		boolean correcto = false;
		if (longitud % 2 == 0) {
			for (int i = 0; i < longitud; i++) {
				numeros[i] = (int) String.valueOf(numero).charAt(i);
			}			
		}
	}
}