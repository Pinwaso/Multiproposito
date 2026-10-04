package Clase.Clase;

import java.util.Scanner;

// Crear un programa en JAVA que dibuje un rectángulo formado por asteriscos(*). 
// Se deben pedir base y altura por teclado. Además, añade código adicional para 
// que dibuje dicho rectángulo sin relleno
public class figuras_1 {

	public static void main(String[] args) {
		int base = 0, altura = 0;
		boolean correcto = false;
		String salida = "";
		do {
			try {
				System.out.println("Ingrese la base y la altura del rectangulo");
				Scanner entrada = new Scanner(System.in);
				base = entrada.nextInt();
				altura = entrada.nextInt();
				entrada.close();
				correcto = true;
			} catch (Exception ex) {
				System.out.println("Ingrese un numero valido");
			}
		} while (!correcto);
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
}