package competitivo;

/**
 * La fiesta aburrida 117 de Acepta el reto
 * 
 * @author William Andrés.
 * @version 21.10.2025
 */

public class la_fiesta_aburrida_117 {
	static java.util.Scanner entrada;

	public static void main(String[] args) {
		entrada = new java.util.Scanner(System.in);
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		entrada = new java.util.Scanner(System.in);
		String cadena = entrada.next();
		cadena = entrada.next();
		System.out.println("Hola, " + cadena + ".");
	}
}