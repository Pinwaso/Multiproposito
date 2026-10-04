package Clase.Clase;

import java.util.Scanner;

public class ejercicio3 {
	// Escribir un programa que pida números enteros hasta que se introduzca un
	// valor
	// menor o igual a cero. A continuación debe mostrar la suma total de dichos
	// números. Se deben incluir todos los números que hemos ido introduciendo por
	// teclado. No se pueden utilizar Arrays. Entrada: 3, 4, 5, 6, 8 | Salida:
	// 3+4+5+6+8=26
	static java.util.Scanner entrada;
	public static void main(String[] args) {
		boolean correcto = true;
		int numero = 0, resultado = 0;
		String mensaje = "";
		do {
			try {
				System.out.println("Ingrese un numero para sumar");
				entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				if (numero <= 0) {
					correcto = false;
				} else {
					mensaje+=("+"+Integer.toString(numero));
					resultado+=numero;
				}
			} catch (Exception ex) {
				entrada = new Scanner(System.in);
			}
		} while (correcto);
		mensaje=(mensaje+"="+resultado);
		System.out.print(mensaje.substring(1));
	}
}