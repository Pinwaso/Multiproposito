package Clase.Clase;

import java.util.Scanner;

// Crea un programa en JAVA que dibuje un triángulo rectángulo formado por 
// asteriscos(*). Se debe pedir la altura del triángulo por teclado. Además, añade 
// código adicional para que dibuje dicho triángulo sin relleno
public class figuras_2 {

	public static void main(String[] args) {
		int altura = 0, base = 1;
		boolean correcto = false;
		String salida = "";
		do {
			try {
				System.out.println("Ingrese la base y la altura del rectangulo");
				Scanner entrada = new Scanner(System.in);
				altura = entrada.nextInt();
				//base=altura;
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
			base++;
			System.out.println(salida);
			salida = "";
		}
	}
}