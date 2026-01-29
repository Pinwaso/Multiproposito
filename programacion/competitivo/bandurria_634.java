package competitivo;

import java.util.Scanner;

/**
 * Bandurria Hero Es el ejercicio 634 de Acepta el reto
 * 
 * @author William Andrés
 * @version 22.10.2025
 */
public class bandurria_634 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {

		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int puntuacion = 0, suma = 10;
		String cadena = entrada.next();
		for (int x = 0; x <= cadena.length() - 1; x++) {
			char caracter = cadena.charAt(x);
			if (caracter == 'O') {
				puntuacion += suma;
				suma += 10;
			} else {
				suma = 10;
			}
		}
		System.out.println(puntuacion);
	}
}