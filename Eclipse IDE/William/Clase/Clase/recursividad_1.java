package Clase.Clase;

import java.util.Scanner;

// Crea un método que obtenga la cantidad de dígitos de un número N mayor que cero. Se 
// debe pasar como parámetro el número N
public class recursividad_1 {

	static int digitos (int n) {
		if (n > 0) {
			return digitos(n/10)+1;
		} else {
			return 0;
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
		System.out.println(digitos(numero));
	}
}