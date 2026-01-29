package competitivo;

import java.util.Scanner;

/**
 * Nombre del ejercicio Es el ejercicio ??? de Acepta el reto
 * 
 * @author William Andrés
 * @version dd.mm.aaaa
 */
public class perimetro_de_un_rectangulo_155 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int base = entrada.nextInt();
		int altura = entrada.nextInt();
		if (base < 0 || altura < 0) { 
			return false;
		} else {
			System.out.println((base*2)+(altura*2));
			return true;
		}
	}
}
