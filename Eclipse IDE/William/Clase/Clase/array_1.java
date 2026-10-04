package Clase.Clase;

import java.util.Scanner;

public class array_1 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		int numero = entrada.nextInt();
		int[] datos = {4,5,8,6,8,7,4,8,9};
		array(datos,numero);
	}
	
	static void array(int[] datos, int valor) {
		int veces = 0;
		for (int dato : datos) {
			if (dato == valor) {
				veces++;
			}
		}
		System.out.println("El numero " + valor + " salio " + veces + (veces == 1 ? " vez" : " veces"));
	}
}
