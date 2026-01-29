package competitivo;

import java.util.Scanner;

/**
 * El cumpleaños de George Es el ejercicio 730 de Acepta el reto
 * 
 * @author William Andrés
 * @version 27.10.2025
 */
public class cumpleanos_george_730 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}
	
	private static void casoDePrueba() {
        long numero = entrada.nextLong(); 
        int velas = 0;
        while (numero != 0) {
            if ((numero % 2) == 1) { 
                velas++;
            }
            numero /= 2;
        }
        System.out.println(velas);
    }
}