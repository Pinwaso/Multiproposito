package competitivo;

import java.util.Scanner;

/**
 * Nombre del ejercicio Es el ejercicio ??? de Acepta el reto
 * 
 * @author William Andrés
 * @version dd.mm.aaaa
 */
public class cociendo_huevos_368 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		double huevos = entrada.nextInt();
		double capacidad = entrada.nextInt();
		if (huevos == 0 && capacidad == 0) { 
			return false;
		} else {
			double resultado = huevos / capacidad;
			System.out.println(((int)Math.ceil(resultado))*10);
			return true;
		}
	}
}
