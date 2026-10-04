package Clase.Clase;

import java.util.Scanner;

public class digitos {

	public static void main(String[] args) {
		try {
			int num;
			System.out.println("Introduce un numero");
			Scanner entrada = new Scanner(System.in);
			num = entrada.nextInt();
			if (num >= 0 && num <= 9) {
				System.out.println("el numero es de un solo digito");
			} else if (num >= 10 && num <= 99) {
				System.out.println("el numero es de 2 digitos");
			} else if (num >= 100 && num <= 999) {
				System.out.println("el numero es de 3 digitos");
			}
			entrada.close();
		} catch (Exception ex) {
			System.out.println("Debes introducir un numero valido");
		} finally {
			System.out.println("FIN");
		}
	}
}
