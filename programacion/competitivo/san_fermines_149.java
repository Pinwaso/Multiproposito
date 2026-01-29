package competitivo;

/**
 * San Fermines Es el ejercicio 149 de Acepta el reto
 * 
 * @author Nadie
 * @version 03.11.2025
 */

public class san_fermines_149 {
	static java.util.Scanner entrada;

	public static void main(String args[]) {
		entrada = new java.util.Scanner(System.in);
		while (casoDePrueba())
			;
	}

	private static boolean casoDePrueba() {
		if (!entrada.hasNext())
			return false;

		int numToros = entrada.nextInt(); // Número de toros que corren el encierro
		int velocidad; // Velocidad de cada toro
		int maxVelocidad = 0; // Velocidad máxima

		for (int i = 0; i < numToros; i++) {
			velocidad = entrada.nextInt();
			if (velocidad > maxVelocidad) {
				maxVelocidad = velocidad;
			}
		}

		System.out.println(maxVelocidad);

		return true;
	}
}