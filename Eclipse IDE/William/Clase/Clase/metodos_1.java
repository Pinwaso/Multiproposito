package Clase.Clase;

import java.util.Scanner;

//Implementa un método que, dado un nombre, muestre un saludo.
public class metodos_1 {
	static String nombre(Scanner entrada) {
		return entrada.nextLine();
	}

	public static void main(String[] args) {
		System.out.println("ingrese su nombre");
		Scanner entrada = new Scanner(System.in);
		System.out.println("Hola " + nombre(entrada));
		entrada.close();
	}
}