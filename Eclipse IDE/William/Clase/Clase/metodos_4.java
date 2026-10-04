package Clase.Clase;

import java.util.Scanner;

// Utiliza el método anterior para que, dado un número, calcule su tabla de 
// multiplicar del 1 al 10
public class metodos_4 {
	static void tabla(Scanner entrada) {
		int a;
		boolean correcto = false;
		do {
			try {
				a = entrada.nextInt();
				correcto = true;
				for (int x = 1; x <= 10; x++) {
					System.out.println(a + " * " + x + " = " + (a * x));
					// System.out.println(a + " * " + x + " = " + (metodos_3.multiplicar(entrada)));
				}
			} catch (Exception ex) {
				System.out.println("Caracter invalido");
				entrada.nextLine();
			}
		} while (!correcto);
	}

	public static void main(String[] args) {
		System.out.println("Ingrese un numero para su tabla");
		Scanner entrada = new Scanner(System.in);
		tabla(entrada);
	}
}