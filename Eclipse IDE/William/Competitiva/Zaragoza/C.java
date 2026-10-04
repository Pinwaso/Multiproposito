package Competitiva.Zaragoza;

import java.util.Scanner;

public class C {
	  static Scanner entrada;

	    public static boolean casoDePrueba() {
	        if (!entrada.hasNext()) {
	        	return false;
	        }
	        String[] cadena = entrada.nextLine().split(" ");
	        int numero = Integer.valueOf(cadena[0]);
	        String letras = cadena[1];
	        
	        
	        return true;
	    } 

	    public static void main(String[] args) {
	        entrada = new Scanner(System.in);
	        while (casoDePrueba()) {
	        }
	    } 
}
