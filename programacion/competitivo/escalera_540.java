package competitivo;

import java.util.Scanner;
/**
 * Por el hueco de la escalera Es el ejercicio 540 de Acepta el reto
 * 
 * @author William Andrés
 * @version 21.10.2025
 */
public class escalera_540 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int pisos = entrada.nextInt();
		int escalones = entrada.nextInt();
		int pisosbajos = entrada.nextInt();
		int escalonesextra = entrada.nextInt();
		int bajada = pisosbajos * escalones + escalonesextra;
		int subida = (pisos * escalones) + bajada;
		System.out.println(bajada + " " + subida);
	}
}