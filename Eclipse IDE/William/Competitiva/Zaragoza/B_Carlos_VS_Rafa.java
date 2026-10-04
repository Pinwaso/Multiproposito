package Competitiva.Zaragoza;

import java.util.Scanner;

public class B_Carlos_VS_Rafa {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {

		int numCasosDePrueba = entrada.nextInt();
		entrada.nextLine();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		String cadena = entrada.nextLine();
		int carlos = 0;
		int maximo_carlos = 0;
		int rafa = 0;
		int maximo_rafa = 0;
		char actual = cadena.charAt(0);

		for (int i = 0; i < cadena.length(); i++) {
			char letra = cadena.charAt(i);
			if (letra == actual) {
				if (letra == 'C') {
					carlos++;
				} else if (letra == 'R') {
					rafa++;
				}
			} else {
				if (letra == 'C') {
					if (rafa > maximo_rafa) {
						maximo_rafa = rafa;
					}
					rafa = 0;
					actual = letra;
				} else if (letra == 'R') {
					if (carlos > maximo_carlos) {
						maximo_carlos = carlos;
					}
					carlos = 0;
					actual = letra;
				}
			}
		}
		
		if (carlos == rafa) {
			System.out.println(carlos + "-0 LOS DOS");
		} else {
			if (carlos < rafa) {
				System.out.println(rafa + "-0 Rafa");
			} else {
				System.out.println(carlos + "-0 Carlos");
			}
		}
	}
}