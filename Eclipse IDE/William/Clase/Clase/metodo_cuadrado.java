package Clase.Clase;

import java.util.Scanner;

public class metodo_cuadrado {
// Implementa un método que a partir del lado, dibuje en cuadrado formado por 
// asteriscos. Crea un método adicional para dibujar dicho cuadrado sin relleno.
	static void cuadrado(int base, int altura) {
		String salida = "";
		for (int i = 1; i <= altura; i++) {
			for (int x = 1; x <= base; x++) {
				salida += ("*");
			}
			System.out.println(salida);
			salida = "";
		}
	}

	static void cuadradorelleno(int base, int altura) {
		String salida = "";
		for (int i = 1; i <= altura; i++) {
			for (int x = 1; x <= base; x++) {
				if (i == 1 || i == altura) {
					salida += ("*");
				} else {
					if (x == 1 || x == base) {
						salida += ("*");
					} else {
						salida += (" ");
					}
				}
			}
			System.out.println(salida);
			salida = "";
		}
	}

	public static void main(String[] args) {
		boolean correcto = false;
		int base = 0, altura = 0, relleno = 0;

		do {
			try {
				System.out.println("ingrese base y altura del cuadrado");
				Scanner entrada = new Scanner(System.in);
				base = entrada.nextInt();
				altura = entrada.nextInt();
				correcto = true;
			} catch (Exception ex) {
			}
		} while (!correcto);
		correcto = false;
		do {
			try {
				System.out.println("con o sin relleno?: con relleno=1, sin relleno=0");
				Scanner entrada = new Scanner(System.in);
				relleno = entrada.nextInt();
				if (relleno == 1) {
					correcto = true;
					entrada.close();
					cuadrado(base, altura);
				} else if (relleno == 0) {
					cuadradorelleno(base, altura);
					correcto = true;
					entrada.close();
				}
			} catch (Exception ex) {
			}
		} while (!correcto);
	}
}