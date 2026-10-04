package Clase.Clase;

import java.util.Scanner;

public class suma_numeros {

	public static void main(String[] args) {
		boolean repetir = true;
		int num1, num2;
		while (repetir) {
			try {
				System.out.println("Introduce 2 numeros");
				Scanner entrada = new Scanner(System.in);
				num1 = entrada.nextInt();
				num2 = entrada.nextInt();
				System.out.println("La suma de ambos numeros es " + (num1 + num2));
				repetir = false;
				entrada.close();
			} catch (Exception ex) {
				System.out.println("No se introducio un numero valido");
			} finally {
				System.out.println("FIN");
			}
		}
	}
}
