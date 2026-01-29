package competitivo;

import java.util.Scanner;

/**
 * Saltando al otro lado Es el ejercicio 705 de Acepta el reto
 * 
 * @author William Andrés
 * @version 12.11.2025
 */
public class saltando_al_otro_lado_705 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int posiciones = entrada.nextInt();
		int piedras[] = new int[posiciones + 1];
		int maximadistancia = Integer.MIN_VALUE;
		for (int a = 1; a < piedras.length; a++) {
			piedras[a] = entrada.nextInt();
		}
		for (int a = piedras.length-1 ; a >= 1; a--) {
			int distancia = piedras[a] - piedras[a-1];
			if (distancia > maximadistancia) {
				maximadistancia = distancia;
			} else if (distancia == maximadistancia) {
				maximadistancia=maximadistancia+1;
			}
		}
		System.out.println(maximadistancia);
	}
}