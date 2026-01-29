package competitivo;

import java.util.Scanner;

/**
 * Suma de digitos Es el ejercicio 140 de Acepta el reto
 * 
 * @author William Andrés
 * @version 28.10.2025
 */
public class suma_de_digitos_140 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int numero = entrada.nextInt();
		if (numero < 0) {
			return false;
		} else {
			String mensaje = "";
			int resultado = 0;
			String cadena = String.valueOf(numero);
			for (int i = 0 ; i < cadena.length() ; i++) {
				mensaje += " + " + cadena.charAt(i);
				resultado += cadena.charAt(i) - '0';
			}
			System.out.println(mensaje.substring(3) + " = " + resultado);
			return true;
		}
	}
}
