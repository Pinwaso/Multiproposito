package competitivo;

import java.util.Scanner;

/**
 * Area de un rectangulo Es el ejercicio 164 de Acepta el reto
 * 
 * @author William Andrés
 * @version 28.10.2025
 */
public class area_de_un_rectangulo_164 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int coordenada1x = entrada.nextInt();
		int coordenada1y = entrada.nextInt();
		int coordenada2x = entrada.nextInt();
		int coordenada2y = entrada.nextInt();
		
		if ((coordenada2x - coordenada1x) < 0 || (coordenada2y - coordenada1y) < 0) { 
			return false;
		} else {
			System.out.println((coordenada2x - coordenada1x) * (coordenada2y - coordenada1y));
			return true;
		}
	}
}
