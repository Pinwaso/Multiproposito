package Clase.Clase;

import java.util.Scanner;

//Dado un número, determinar cuántos dígitos tiene. No se pueden utilizar ni 
//variables ni funciones de tipo String. 
public class ejercicio2 {
	static java.util.Scanner entrada;

	public static void main(String[] args) {
		boolean correcto = false;
		int numero=0, digitos=0;
		do {
			try {
				System.out.println("Ingrese un numero");
				entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				if (numero > 0) {
					correcto = true;
				}
			} catch (Exception ex) {
				entrada = new Scanner(System.in);
			}
		} while (!correcto);
		while (numero!=0) {
			numero=numero/10;
			digitos++;
		}
		System.out.print("el numero tiene " + digitos + " digitos");
	}
}
