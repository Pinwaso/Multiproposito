package competitivo;

import java.util.Scanner;

/**
 * En la cola de Papá Noel Es el ejercicio 365 de Acepta el reto
 * 
 * @author William Andrés
 * @version 11.11.2025
 */
public class en_la_cola_de_papa_noel_365 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int ninos = entrada.nextInt();
		int cantidadninos[] = new int[ninos];
		int posicion = entrada.nextInt();
		for (int a = 0; a < ninos; a++) {
			cantidadninos[a] = entrada.nextInt();
		}
		int numero = cantidadninos[posicion-1];
		int minutos = 0;
		do {
			for (int a = 0; a < cantidadninos.length; a++) {
				if (a == posicion-1) {
					numero = cantidadninos[a]--;
					minutos+=2;
					if (numero == 1) break;	
				} else if (cantidadninos[a] > 0) {
					cantidadninos[a]--;
					minutos+=2;
				}
			}
		} while (numero != 1);
		System.out.println(minutos);
	}
}