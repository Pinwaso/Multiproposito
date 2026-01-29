package competitivo;

import java.util.Scanner;

/**
 * Ahorro infantil Es el ejercicio 424 de Acepta el reto
 * 
 * @author William Andrés
 * @version 30.10.2025
 */
public class ahorro_infantil_424 {
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
			int resultado = 0, maximo = Integer.MIN_VALUE;
			for (int i = 0; i < numero; i++) {
				int operacion = entrada.nextInt();
				resultado += operacion;
				if (resultado > maximo) {
					maximo = resultado;
				}
			}
			System.out.println(resultado + " " + maximo);
			return true;
		}
	}
}
