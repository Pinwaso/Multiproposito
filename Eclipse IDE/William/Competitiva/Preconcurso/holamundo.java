package Competitiva.Preconcurso;

import java.util.Scanner;

public class holamundo {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		entrada.nextLine();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		System.out.println("Hello World!");
	}
}