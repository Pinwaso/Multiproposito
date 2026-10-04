package Clase.Clase;

import java.util.Scanner;

// Crea un método que compruebe si un número es binario. Un número binario está 
// formado únicamente por ceros y unos.
public class recursividad_4 {
	
	static boolean comprobarbinario(int n) {
		if (n == 0 || n == 1) {
			return true;
		}
		int ultimodigito = n % 10;
		if (ultimodigito != 0 && ultimodigito != 1) {
			return false;
		}
		return comprobarbinario(n / 10);
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
		System.out.println(comprobarbinario(numero));
	}
}