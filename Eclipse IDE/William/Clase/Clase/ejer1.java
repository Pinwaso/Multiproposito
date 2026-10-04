package Clase.Clase;

import java.util.Scanner;
// Crea un programa que te pida una palabra y escriba las letras separadas por 
// espacios. Ejemplo, a partir de "Pepe" escribirá "P e p e ".

public class ejer1 {

	public static void main(String[] args) {
		String cadena = "", mensaje = "";
		int digitos = 0;
		System.out.println("Ingrese una cadena");
		Scanner entrada = new Scanner(System.in);
		cadena = entrada.next();
		digitos = cadena.length();
		for (int i = 0; i < digitos; i++) {
			char digito = cadena.charAt(i);
			mensaje += (digito + " ");
		}
		entrada.close();
		System.out.println(mensaje);
	}
}