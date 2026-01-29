package competitivo;

import java.util.Scanner;

/**
 * Acronimos Es el ejercicio 694 de Acepta el reto
 * 
 * @author William Andrés
 * @version 27.10.2025
 */
public class acronimos_694 {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String args[]) {
        int numCasosDePrueba = entrada.nextInt();
        entrada.nextLine();
        for (int i = 1; i <= numCasosDePrueba; i++) {
            casoDePrueba();
        }
    }
    private static void casoDePrueba() {
        String cadena = entrada.nextLine().trim();
        String palabra = "";
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            if (c != ' ') {
                palabra += c;
            } else {
                if (!palabra.isEmpty() && palabra.charAt(0) >= 'A' && palabra.charAt(0) <= 'Z') {
                    System.out.print(palabra.charAt(0));
                }
                palabra = "";
            }
        }
        if (!palabra.isEmpty() && palabra.charAt(0) >= 'A' && palabra.charAt(0) <= 'Z') {
            System.out.print(palabra.charAt(0));
        }
        System.out.println(); 
    }
}