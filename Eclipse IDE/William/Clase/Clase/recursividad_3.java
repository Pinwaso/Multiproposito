package Clase.Clase;

import java.util.Scanner;

// Crea un método que dado un número positivo, lo imprima invertido por pantalla.
public class recursividad_3 {
	
	static void invertido (int n) {
		if (n > 0) {
			// al aplicar %10, da el ultimo caracter de un numero
			System.out.print(n % 10);
			invertido(n/10);
		}
	}

	public static void main(String[] args) {
		boolean correcto = false;
		int numero = 0;
		do {
			try {
				System.out.println("Ingrese un numero positivo");
				Scanner entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				if (numero > 0) {
					correcto = true;
					entrada.close();
				} else {
					System.out.println("Ingrese un numero valido");
				}
			} catch (Exception ex) {
				System.out.println("Ingrese un numero valido");
			}
		} while (!correcto);
		invertido(numero);
	}
}
