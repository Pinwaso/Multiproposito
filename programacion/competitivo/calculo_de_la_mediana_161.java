package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Cálculo de la mediana Es el ejercicio 161 de Acepta el reto
 * 
 * @author William Andrés
 * @version 04.11.2025
 */
public class calculo_de_la_mediana_161 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int numero = entrada.nextInt();
		if (numero == 0) {
			return false;
		} else {
			int[] array = new int[numero];
			for (int a = 0 ; a < numero ; a++) {
				array[a] = entrada.nextInt();
			}
			Arrays.sort(array);
			int longitud = array.length;
			if (longitud % 2 == 0) {
				int posicion1 = longitud / 2;
				posicion1 = array[posicion1];
				int posicion2 = (longitud / 2)-1;
				posicion2 = array[posicion2];
				System.out.println( (posicion2*2) + ( ( (posicion1*2) - (posicion2*2) ) / 2) );
			} else {
				int posicion = longitud / 2;
				System.out.println(array[posicion] * 2);
			}
			return true;
		}
	}
}
