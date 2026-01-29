package competitivo;

import java.util.Scanner;
import java.util.Stack;

/**
 *  Es el ejercicio Parentesis balanceados 141 de Acepta el reto
 * 
 * @author William Andrés
 * @version 16.12.2025
 */
public class parentesis_balanceados_141 {
	  static Scanner entrada = new Scanner (System.in);
	  static Stack<Character> pila;

	    public static boolean casoDePrueba() {
	        if (!entrada.hasNext()) {
	            return false;
	        }
	        String cadena = entrada.nextLine();
	        pila = new Stack<>();
	        for (int i = 0; i < cadena.length(); i++) {
	        	char caracter = cadena.charAt(i);
	        	if (caracter == '[' || caracter == '{' || caracter == '(') {
	        		pila.push(caracter);
	        	} else if (caracter == '}'|| caracter == ')' || caracter == ']') {
	        		if (pila.isEmpty()) {
	        			System.out.println("NO");
	        			return true;
	        		}
	        		char caracter_ultimo = pila.pop();
	        		if ((caracter_ultimo != '[' && caracter == ']') || (caracter_ultimo != '{' && caracter == '}') || (caracter_ultimo != '(' && caracter == ')')) {
	        			System.out.println("NO");
	        			return true;
	        		}
	        	}
	        }
	        if (pila.isEmpty()) {
	        	System.out.println("YES");
	        } else {
	        	System.out.println("NO");
	        }
	        return true;
	    } 

	    public static void main(String[] args) {
	        entrada = new Scanner(System.in);
	        while (casoDePrueba()) {
	        }
	    } 
}
