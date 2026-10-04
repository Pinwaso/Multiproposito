package Clase.Clase;

import java.util.Scanner;
// Crea un método que reciba un Array de Strings y un char. Deberá mostrar 
// todas las Strings cuya primera letra sea el char pasado como parámetro.
public class array_3 {
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		char caracter = 'h';
		String valores[] = {"hola", "higado", "pepas","jamon","patatas","momo","fantasma"};
		funcion(valores, caracter);
	}

	static void funcion (String valores[], char caracter) {
		for (String valor : valores) {
			if (valor.charAt(0) == caracter /*&& valor != null && valor.isEmpty()==false*/) {
				System.out.println(valor);
			}
		}
	}
}