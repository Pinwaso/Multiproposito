package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Matrices triangulares Es el ejercicio 160 de Acepta el reto
 * 
 * @author William Andrés
 * @version 11.11.2025
 */
public class matrices_triangulares_160 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
	     int numero = entrada.nextInt();
	        if (numero == 0) return false;
	        boolean superior = true, inferior = true;
	        for (int i = 0; i < numero; i++) {
	            for (int j = 0; j < numero; j++) {
	                int valor = entrada.nextInt();
	                if (i > j && valor != 0) {
	                    superior = false;
	                }
	                if (i < j && valor != 0) {
	                    inferior = false;
	                }
	            }
	        }
	        if (superior || inferior)
	            System.out.println("SI");
	        else
	            System.out.println("NO");
	        return true;
	}
}