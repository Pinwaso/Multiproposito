package competitivo;

import java.util.Scanner;

/**
 * Escudos del ejercito romano 119 de Acepta el reto
 * 
 * @author William Andrés
 * @version 28.10.2025
 */
public class escudos_del_ejercito_romano_119 {
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
			double resultado = 0;
			int escudos = 0;
			while (numero >= 1) {
				resultado = Math.floor(Math.sqrt(numero));
				numero -= (int)Math.pow(resultado, 2);
				escudos += (resultado * resultado) + (resultado*2) + (resultado*2);
			}
			System.out.println(escudos);
			return true;
		}
	}
}
