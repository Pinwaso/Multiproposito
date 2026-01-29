package competitivo;

import java.util.Scanner;

/**
 * Nombre del ejercicio Es el ejercicio ??? de Acepta el reto
 * 
 * @author William Andrés
 * @version dd.mm.aaaa
 */
public class cinquecento_635 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int año = entrada.nextInt();
		int siglo = ((año - 1) / 100) + 1;
        System.out.println(siglo);
	}
}
