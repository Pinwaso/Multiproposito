package Clase.Clase;

import java.util.Scanner;

// Crea un método que compruebe si una palabra está ordenada alfabéticamente.
public class recursividad_6 {
	
	   static boolean estaordenada(String palabra) {
	        if (palabra.length() <= 1) {
	            return true;
	        }
	        char primero = palabra.charAt(0);
	        char segundo = palabra.charAt(1);
	        if (primero > segundo) {
	            return false;
	        }
	        return estaordenada(palabra.substring(1));
	    }
	   
	public static void main(String[] args) {
		boolean correcto = false;
		String palabra = "";
		do {
			try {
				System.out.println("Ingrese una palabra");
				Scanner entrada = new Scanner(System.in);
				palabra = entrada.next();
				correcto = true;
				entrada.close();
			} catch (Exception ex) {
				System.out.println("Ingrese una palabra valida");
			}
		} while (!correcto);
		System.out.println(estaordenada(palabra));
	}
}
