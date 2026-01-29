package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  Campo de minas 176 de Acepta el reto
 * 
 * @author William Andrés
 * @version 02.12.2025
 */
public class campo_de_minas_176 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int x = entrada.nextInt();
		int y = entrada.nextInt();
		entrada.nextLine();
		char tabla[][] = new char[y][x];
		if (x == 0 && y == 0) {
			return false;
		} else {
			for (int a = 0; a < tabla.length; a++) {
				String linea = entrada.nextLine();
				for (int b = 0; b < tabla[a].length; b++) {
					tabla[a][b] = linea.charAt(b);
				}
			}
			int encontradas = 0;
			for (int i = 0; i < tabla.length; i++) {
				for (int b = 0 ; b < tabla[i].length; b++) {
					if (puntoCentral(i, b, tabla) >= 6) {
						encontradas=encontradas+1;
					}
				}
			}
			System.out.println(encontradas);
			return true;
		}
	}
	
	static int puntoCentral(int y, int x, char[][] tabla) {
		int minas = 0;
		for (int i = y-1; i <= y+1; i++) {
			for (int b = x-1; b <= x+1; b++) {
				boolean celdacentral = (i == y && b == x);
				if (validarPunto(i, b, tabla) && !celdacentral) {
					if (tabla[i][b] == '*') {
						minas = minas+1;
					}
				}
			}
		}
		return minas;
	}
	
	static boolean validarPunto(int y, int x, char[][] tabla) {
		if ((y >= 0 && y < tabla.length) && (x >= 0 && x < tabla[0].length)) {
			return true;
		} else {
			return false;
		}
	}
}