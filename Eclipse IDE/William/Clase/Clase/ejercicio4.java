package Clase.Clase;

import java.util.Scanner;

// Dada una secuencia de números enteros acabada en 0, obtener la suma de 
// aquellos números tales que su número de cifras sea igual a la suma de las 
// mismas. No se pueden utilizar Arrays. Entrada: 1, 5, 111, 66, 201, 273, 0 | Salida: 1 + 
// 111 + 201 = 313
public class ejercicio4 {
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
				if (numero == 0) {
					correcto = false;
				} else {
					mensaje += (" + " + String.valueOf(numero));
					resultado += numero;
				}
			} catch (Exception ex) {
				entrada = new Scanner(System.in);
			}
		} while (correcto);
		mensaje = (mensaje + " = " + resultado);
		System.out.print(mensaje.substring(3));
	}
}


