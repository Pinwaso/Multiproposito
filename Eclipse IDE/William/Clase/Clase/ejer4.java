package Clase.Clase;

import java.util.Scanner;

// Crea un programa en JAVA que reciba una palabra por teclado e indique si es 
// un palíndromo. Un palíndromo es una palabra que se lee igual de derecha a 
// izquierda, que de izquierda a derecha. Ejemplo: RECONOCER
public class ejer4 {

	public static void main(String[] args) {
		String cadena1 = "", cadena2 = "";
		int longitud = 0;
		System.out.println("ingrese una palabra");
		Scanner entrada = new Scanner(System.in);
		cadena1 = (entrada.nextLine()).trim();
		longitud = cadena1.length();
		for (int i = longitud - 1; i >= 0; i--) {
			char digito = cadena1.charAt(i);
			cadena2 += digito;
		}
		entrada.close();
		if (cadena1.equals(cadena2)) {
			System.out.println("Es palindromo");
		} else {
			System.out.println("No es palindromo");
		}
	}
}