package Clase.Clase;

import java.util.Scanner;

// Crea un método que obtenga el número binario de un número N pasado como 
// parámetro.
public class recursividad_5 {
	
	static void binario (int n) {
		if (n > 1) {			
			binario(n / 2);			
		}
		System.out.print(n % 2);
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
		binario(numero);
	}
}