package Clase.Clase;

import java.util.Scanner;

// Crea un programa en JAVA que dibuje un triángulo equilátero formado por 
// asteriscos(*). Se debe pedir la altura del triángulo por teclado. Además, añade 
// código adicional para que dibuje dicho rectángulo sin relleno
public class figuras_3 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce la altura del triángulo: ");
		int altura = entrada.nextInt();
		entrada.close();

		for (int fila = 1; fila <= altura; fila++) {
			// Espacios antes de los asteriscos
			for (int espacio = 1; espacio <= altura - fila; espacio++) {
				System.out.print("a");
			}

			// Asteriscos o huecos
			for (int col = 1; col <= (2 * fila - 1); col++) {
				// Primera y última posición de cada fila, o la base
				if (col == 1 || col == (2 * fila - 1) || fila == altura) {
					System.out.print("*");
				} else {
					System.out.print("a");
				}
			}

			System.out.println(); // salto de línea
		}
	}
}