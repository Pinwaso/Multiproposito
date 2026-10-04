package Clase.Clase;

import java.util.Scanner;

public class hexadecimal_a_decimal {
	// pedir una cadena por teclado
	// comprobar que la cadena solo tiene numeros o las letras ABCDEF
	// Mientras no se cumpla volver a pedir una cadena
	// Mostrar por pantalla el numero decimal
	public static void main(String[] args) {
		Boolean error = false;
		do {
			String cadena;
			error = false;
			System.out.println("Ingrese una cadena en hexadecimal");
			Scanner entrada = new Scanner(System.in);
			cadena = entrada.next();
			cadena = cadena.toLowerCase();
			int digitos = cadena.length();
			for (int i = 0; i < digitos; i++) {
				char caracter = cadena.charAt(i);
				if (!((caracter >= '0' && caracter <= '9') || (caracter >= 'a' && caracter <= 'f'))) {
					error = true;
				}
			}
			if (error) {
				System.out.println("cadena invalida, ingrese de nuevo");
			} else {
				int resultado = 0;
				int valor = 0;
				for (int x = 0; x < digitos; x++) {
					char caracter = cadena.charAt(x);
					switch (caracter) {
						case 'a': valor = 10; break;
						case 'b': valor = 11; break;
						case 'c': valor = 12; break;
						case 'd': valor = 13; break;
						case 'e': valor = 14; break;
						case 'f': valor = 15; break;
						// al ser char, devuelve el equivalente del caracter en bytecode
						// para que sea el valor numerico correspondiente, se resta '0'
						default: valor = (caracter - '0'); break;
					}
					resultado += (valor * (Math.pow(16, x)));
				}
				entrada.close();
				System.out.println(resultado);
			}
		} while (error);
	}
}
