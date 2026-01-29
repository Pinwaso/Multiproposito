package competitivo;

import java.util.Scanner;

/**
 * Nombre del ejercicio Es el ejercicio ??? de Acepta el reto
 * 
 * @author William Andrés
 * @version dd.mm.aaaa
 */
public class dia_mundial_piano_676 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			prueba();
		}
	}

	private static boolean casoDePrueba(int ano) {
		return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
	}
	private static void prueba() {
		int ano1 = entrada.nextInt();
		int ano2 = entrada.nextInt();
		int anobiciesto = 0;
		for (int i = ano1; i <= ano2; i++) {
			if (casoDePrueba(i)) {
				anobiciesto++;
			} 
		}
		System.out.println((ano2 - ano1 - anobiciesto +1) + " " + anobiciesto);
	}
}