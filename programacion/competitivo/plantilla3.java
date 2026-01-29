package competitivo;

import java.util.Scanner;

/**
 *  Es el ejercicio ??? de Acepta el reto
 * 
 * @author William Andrés
 * @version dd.mm.aaaa
 */
public class plantilla3 {
	  static Scanner entrada;

	    public static boolean casoDePrueba() {
	        if (!entrada.hasNext()) {
	        	return false;
	        }
	        return true;
	    } 

	    public static void main(String[] args) {
	        entrada = new Scanner(System.in);
	        while (casoDePrueba()) {
	        }
	    } 
}
