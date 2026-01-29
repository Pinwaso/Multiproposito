package competitivo;

import java.util.Scanner;

/**
 * La abuela María
 * Ejercicio 337 de Acepta el reto
 * 
 * @author William Andrés
 * @version 04.11.2025
 */
public class la_abuela_maria_337 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		casoDePrueba();
	}

	private static void casoDePrueba() {
		int numero = entrada.nextInt();
		if (numero == 0) {
		} else {
			for (int a = 0 ; a < numero ; a++) {
				int arriba[] = new int[6];
				int abajo[] = new int[6];
				int resultado = 0;
				for (int b = 0 ; b < 6 ; b++) {
					arriba[b] = entrada.nextInt();
				}
				for (int c = 0 ; c < 6 ; c++) {
					abajo[c] = entrada.nextInt();
				}
				resultado = arriba[0] + abajo[0];
				String mensaje = "SI";
				for (int d = 1 ; d < 6 ; d++) {
					if (resultado != (arriba[d] + abajo[d])) {
						mensaje = "NO";
					}
				}
				System.out.println(mensaje);
			}
		}
	}
}
