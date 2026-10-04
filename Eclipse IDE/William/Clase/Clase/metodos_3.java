package Clase.Clase;

import java.util.Scanner;

// Implementa un método que, dados dos números, los multiplique.
public class metodos_3 {
	static int multiplicar(Scanner entrada) {
		int a, b, resultado;
		a = entrada.nextInt();
		b = entrada.nextInt();
		return resultado=(a*b);
	}

	public static void main(String[] args) {
		System.out.println("Ingrese 2 numeros para multiplicar");
		Scanner entrada = new Scanner(System.in);
		System.out.println("El resultado es " + multiplicar(entrada));
		entrada.close();
	}
}