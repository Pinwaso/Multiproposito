package competitivo;

import java.util.Scanner;

/**
 * Contando desde cero Es el ejercicio 663 de Acepta el reto
 * 
 * @author William Andrés
 * @version 27.10.2025
 */
public class contando_desde_cero_663 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int ano = entrada.nextInt();
		System.out.println(ano >= 1 ? ano-1 : ano);
	}
}