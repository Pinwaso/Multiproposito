package competitivo;

import java.util.Scanner;
/**
 * Los problemas de ser rico - Ejercicio 191 de Acepta el reto
 * 
 * @author William Andrés
 * @version 21.10.2025
 */
public class problemas_ser_rico_191 {
	static Scanner entrada = new Scanner(System.in);

    public static void main(String args[]) {
    	int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
    }
    
	private static void casoDePrueba() {
		int n = entrada.nextInt();
        int mayor = entrada.nextInt();
        int dif = entrada.nextInt();
        int total = n * mayor - dif * (n * (n - 1)) / 2;
        System.out.println(total);
	}
}