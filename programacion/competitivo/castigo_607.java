package competitivo;

import java.util.Scanner;

/**
 * Minimizando el castigo Es el ejercicio 607 de Acepta el reto
 * 
 * @author William Andrés
 * @version 21.10.2025
 */
public class castigo_607 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int meta = entrada.nextInt(), casos = 1, recursivo = 0;
		while (casos <= meta) {
			if (meta == 1) {
				break;
			} else if (casos == meta) {
				break;
			}
			casos *= 2;
			recursivo++;
		}
		System.out.println(recursivo);
	}
}
