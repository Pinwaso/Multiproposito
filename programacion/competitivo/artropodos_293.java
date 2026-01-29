package competitivo;

import java.util.Scanner;

/**
 * Artropodos – Ejercicio 293 de Acepta el reto
 * 
 * @author William Andrés
 * @version 21.10.2025
 */
public class artropodos_293 {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int numCasosDePrueba = entrada.nextInt();
        for (int i = 0; i < numCasosDePrueba; i++) {
            casoDePrueba();
        }
    }

    private static void casoDePrueba() {
        int insectos = entrada.nextInt();
        int aracnidos = entrada.nextInt();
        int crustaceos = entrada.nextInt();
        int escolopendras = entrada.nextInt();
        int anillos = entrada.nextInt();

        int resultado = (insectos * 6) + (aracnidos * 8) + (crustaceos * 10) + (escolopendras * anillos * 2);

        System.out.println(resultado);
    }
}
