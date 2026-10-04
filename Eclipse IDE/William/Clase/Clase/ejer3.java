package Clase.Clase;

import java.util.Scanner;

// Crea un programa en JAVA que lea por teclado una cadena de texto e indique 
// la cantidad de palabras que tiene. De la clase String, únicamente se pueden 
// utilizar los métodos charAt(), trim() y length(). 
public class ejer3 {

	public static void main(String[] args) {
		String cadena = "";
		Boolean enpalabra = false;
		int longitud = 0, palabras = 0;
		System.out.println("Ingrese una cadena de texto");
		Scanner entrada = new Scanner(System.in);
		cadena = (entrada.nextLine()).trim();
		longitud = cadena.length();
		for (int i = 0; i < longitud; i++) {
			char digito = cadena.charAt(i);
			 if (digito != ' ' && !enpalabra) {
	                enpalabra = true;
	                palabras++;
	            }
	            else if (digito == ' ') {
	                enpalabra = false;
	            }
		}
		entrada.close();
		System.out.println("Palabras: " + palabras);
	}
}