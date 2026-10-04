package Clase.Clase;

import java.util.Scanner;

// Crea un método que obtenga el resultado de elevar un número a otro. Ambos números se 
// deben pasar como parámetros. Los números deben ser positivos.
public class recursividad_2 {
	
	static int potencia (int base, int exponente) {
		if (exponente == 0) {
			return 1;
		} else {
			return base * potencia(base, (exponente-1));
		}
	}

	public static void main(String[] args) {
		boolean correcto = false;
		int base = 0, exponente = 0;
		do {
			try {
				System.out.println("Ingrese la base positiva y exponente positivo");
				Scanner entrada = new Scanner(System.in);
				base = entrada.nextInt();
				exponente = entrada.nextInt();
				if (base > 0 && exponente > 0) {
					correcto = true;
					entrada.close();
				} else {
					System.out.println("Ingrese un numero valido");
				}
			} catch (Exception ex) {
				System.out.println("Ingrese un numero valido");
			}
		} while (!correcto);
		System.out.println(potencia(base, exponente));
	}
}