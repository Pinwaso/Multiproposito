package competitivo;

import java.util.Scanner;

public class eslabones_perdidos_453 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int especies = entrada.nextInt();
		if (especies == 0) {
			return false;
		} else {
			int conexiones = entrada.nextInt();
			for (int i = 0; i < conexiones; i++) {
				int num1 = entrada.nextInt();
				int num2 = entrada.nextInt();
			}
			if (conexiones+1 >= especies) {
				System.out.println("TODAS");
			} else {
				System.out.println("FALTA ALGUNA");
			}
			return true;
		}
	}
}