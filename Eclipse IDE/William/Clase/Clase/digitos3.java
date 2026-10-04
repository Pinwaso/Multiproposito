package Clase.Clase;

import java.util.Scanner;

public class digitos3 {
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
			switch (digitos) {
				case 1: System.out.println("el numero tiene 1 digito"); break;
				case 2: System.out.println("el numero tiene 2 digito"); break;
				case 3: System.out.println("el numero tiene 3 digito"); break;
				case 4: System.out.println("el numero tiene 4 digito"); break;
				case 5: System.out.println("el numero tiene 5 digito"); break;
				case 6: System.out.println("el numero tiene 6 digito"); break;
				case 7: System.out.println("el numero tiene 7 digito"); break;
				case 8: System.out.println("el numero tiene 8 digito"); break;
				case 9: System.out.println("el numero tiene 9 digito"); break;
				default: System.out.println("el numero tiene mas de 9 digitos"); break;
			}
			entrada.close();
		} catch (Exception ex) {
			System.out.println("Debes introducir un numero valido");
		}
	}
}
