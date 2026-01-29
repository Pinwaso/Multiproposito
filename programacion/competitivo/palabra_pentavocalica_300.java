package competitivo;

import java.util.Scanner;

/**
 * Palabras pentavocálicas Es el ejercicio 300 de Acepta el reto
 * 
 * @author William Andrés
 * @version 21.10.2025
 */
public class palabra_pentavocalica_300 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		String cadena = entrada.next().toLowerCase();

		for (int x = 0; x <= cadena.length() - 1; x++) {
			char caracter = cadena.charAt(x);
			switch (caracter) {
				case 'a': a = 1; break;
				case 'e': e = 1; break;
				case 'i': i = 1; break;
				case 'o': o = 1; break;
				case 'u': u = 1; break;
			}
		}
		if ((a + e + i + o + u) == 5) {
			System.out.println("SI");
		} else {
			System.out.println("NO");
		}
	}
}