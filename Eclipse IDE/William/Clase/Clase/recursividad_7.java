package Clase.Clase;

import java.util.Scanner;

// Crea un método que obtenga la suma de los números naturales desde 1 hasta N. Se debe 
// pasar como parámetro el número N, debe ser mayor que cero. Se debe imprimir toda la 
// cadena por consola. Por ejemplo, para N=4 → ( 1+2+3+4 = 10)
public class recursividad_7 {
	/*
	 * static String natural (int n) { String mensaje = ""; int resultado = 0; for
	 * (int i = 1; i <= n; i++) { mensaje += ("+"+i); resultado += i; } mensaje
	 * +=("="+resultado); return mensaje.substring(1); }
	 */

	static int sumanatural(int n) {
		if (n > 1) {
			int temporal = sumanatural(n - 1) + n;
			System.out.print("+" + n);
			return temporal;
		} else {
			System.out.print(n);
			return 1;
		}
	}

	public static void main(String[] args) {
		boolean correcto = false;
		int numero = 0;
		do {
			try {
				System.out.println("Ingrese un numero positivo");
				Scanner entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				if (numero > 0) {
					correcto = true;
				} else {
					System.out.println("Ingrese un numero valido");
				}
			} catch (Exception ex) {
				System.out.println("Ingrese un numero valido");
			}
		} while (!correcto);
		System.out.println(sumanatural(numero));
	}
}