package competitivo;

/**
 * Hola mundo Es el ejercicio 116 de Acepta el reto
 * 
 * @author William Andrés
 * @version 21.10.2025
 */
public class hola_mundo_116 {
	static java.util.Scanner entrada;

	public static void main(String args[]) {
		entrada = new java.util.Scanner(System.in);
		int numCasosDePrueba = entrada.nextInt();
		if (numCasosDePrueba >= 0 && numCasosDePrueba <= 5) {
			for (int i = 1; i <= numCasosDePrueba; i++) {
				casoDePrueba();
			}
		}
	}

	private static void casoDePrueba() {
		System.out.println("Hola mundo.");
	}
}
