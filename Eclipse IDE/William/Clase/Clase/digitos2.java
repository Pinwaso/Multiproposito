package Clase.Clase;

import java.util.Scanner;

public class digitos2 {
	public static void main(String[] args) {
		try {
			System.out.print("Introduce un número: ");
			Scanner entrada = new Scanner(System.in);
			int num = entrada.nextInt(); // se recoge en numero
			if (num < 0) {// se omite su signo
				num *= -1;
			}
			String texto = String.valueOf(num); // se convierte el numero entero a string
			int digitos = texto.length(); // se calcula la longitud de la cadena
			System.out.println("El número " + num + " tiene " + digitos + " dígitos.");
			entrada.close();
		} catch (Exception ex) {
			System.out.println("Debes introducir un numero valido");
		}
	}
}
