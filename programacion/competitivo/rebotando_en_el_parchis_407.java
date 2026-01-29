package competitivo;

import java.util.Scanner;

/**
 * Rebotando en el parchis Es el ejercicio 407 de Acepta el reto
 * 
 * @author William Andrés
 * @version 29.10.2025
 */
public class rebotando_en_el_parchis_407 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int casillas = entrada.nextInt();
		int posicion = entrada.nextInt();
		int dados = entrada.nextInt();
		if (casillas == 0 && posicion == 0 && dados == 0) { 
			return false;
		} else {
			if ((dados + posicion) > casillas) {
				System.out.println(casillas - (dados + posicion - casillas));
			} else {
				System.out.println(dados + posicion);
			}
			return true;
		}
	}
}
