package competitivo;

import java.util.Scanner;
/**
 * Último dígito del factorial Es el ejercicio 114 de Acepta el reto
 * 
 * @author William Andrés
 * @version 21.10.2025
 */
public class ultimo_factorial_114 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int numero = entrada.nextInt(), resultado;
		switch (numero) {
		case 0: resultado = 1; break;
		case 1: resultado = 1; break;
		case 2: resultado = 2; break;
		case 3: resultado = 6; break;
		case 4: resultado = 4; break;
		default: resultado = 0;
		}
		System.out.println(resultado);
	}
}

