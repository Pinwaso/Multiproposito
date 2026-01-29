package competitivo;

import java.util.Scanner;

/**
 * Reduciendo envases 532 de Acepta el reto
 * 
 * @author William Andrés.
 * @version 21.10.2025
 */
public class envases_532 {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int numCasosDePrueba = entrada.nextInt();

        for (int i = 0; i < numCasosDePrueba; i++) {
            casoDePrueba();
        }
    }

    private static void casoDePrueba() {
        int pn = entrada.nextInt(); 
        int pt = entrada.nextInt(); 
        System.out.println(pt - pn);
    }
}