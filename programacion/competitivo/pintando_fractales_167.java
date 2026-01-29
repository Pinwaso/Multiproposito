package competitivo;

import java.util.Scanner;
/**
 * Pintado fractales Es el ejercicio 167 de Acepta el reto
 * 
 * @author William Andrés
 * @version 03.11.2025
 */
public class pintando_fractales_167 {
	static java.util.Scanner entrada;

	public static void main(String args[]) {
		entrada = new java.util.Scanner(System.in);
		while (casoDePrueba())
			;
	}

	private static boolean casoDePrueba() {
		if (!entrada.hasNext()) {
			return false;
		}
		int numero = entrada.nextInt();
		int longitud = 0;
		int exponente = 1;
		while (numero != 0) {
			longitud += (numero*4*exponente);
			exponente *= 4;
			numero /= 2;
		}
		System.out.println(longitud);
		return true;
	}
}