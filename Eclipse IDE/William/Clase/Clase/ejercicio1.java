package Clase.Clase;

import java.util.Scanner;
// Leer una cantidad ‘N’ y luego introducir ‘N’ números enteros. Se pide imprimir el 
// mayor y el menor y las veces que aparece cada uno.

public class ejercicio1 {
	static java.util.Scanner entrada;

	public static void main(String[] args) {
		int operaciones = 0, nummin = Integer.MAX_VALUE, nummax = Integer.MIN_VALUE, max = 0, min = 0;
		boolean correcto = false;
		do {
			try {
				System.out.println("Ingrese un numero de operaciones");
				entrada = new Scanner(System.in);
				operaciones = entrada.nextInt();
				if (operaciones >= 0) {
					correcto = true;
				}
			} catch (Exception ex) {
			}
		} while (!correcto);
		int indice = 1;
		while (indice <= operaciones) {
			try {
				System.out.println("Ingrese el numero " + indice);
				int numero = entrada.nextInt();
				indice++;
				if (numero > nummax) {
					nummax = numero;
					max = 1;
				} else if (numero == nummax) {
					max++;
				}
				if (numero < nummin) {
					nummin = numero;
					min = 1;
				} else if (numero == nummin) {
					min++;
				}
			} catch (Exception ex) {
				entrada = new Scanner(System.in);
			}
		}
		entrada.close();
		System.out.println("numero maximo: " + nummax + " aparecido " + max + (max == 1 ? " vez" : " veces"));
		System.out.println("numero minimo: " + nummin + " aparecido " + min + (min == 1 ? " vez" : " veces"));
	}
}
