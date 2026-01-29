package competitivo;

import java.util.Scanner;
/**
 * La otra página Es el ejercicio 621 de Acepta el reto
 * 
 * @author William Andrés
 * @version 21.10.2025
 */
public class paginas_621 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		int pagina = entrada.nextInt();
		System.out.println(pagina % 2 == 0 ? pagina + 1 : pagina - 1);	
	}
}