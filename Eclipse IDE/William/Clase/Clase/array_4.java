package Clase.Clase;

import java.util.Scanner;

// Crea un método que reciba dos Arrays como parámetros, y devuelva un Array 
// con los valores máximos en cada una de las posiciones. Se debe tener en 
// cuenta que los Arrays podrán ser de tamaños distintos.
public class array_4 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		int array1[] = { 4, 8, 15, 1 };
		int array2[] = { 7, 2, 11, 18, 7, 6, 3 };
		funcion(array1, array2);
	}
	static void funcion(int array1[], int array2[]) {
		if (array1.length > array2.length) {
			arrays(array1, array2);
		} else if (array1.length < array2.length) {
			arrays(array2, array1);
		} else {
			array2(array1, array2);
		}
	}
	static void arrays (int array1[], int array2[]) {
		int nuevo[] = new int[array1.length];
		for (int x = 0; x <= array2.length - 1; x++) {
			if (array1[x] > array2[x]) {
				nuevo[x] = array1[x];
			} else if (array1[x] < array2[x]) {
				nuevo[x] = array2[x];
			} else {
				nuevo[x] = array2[x];
			}
		}
		for (int y = array2.length; y <= array1.length - 1; y++) {
			nuevo[y] = array1[y];
			
		}
		for (int numero : nuevo) {
			System.out.print(numero + " ");
		}
	}
	static void array2(int array1[], int array2[]) {
		int nuevo[] = new int[array1.length];
		for (int x = 0; x <= array1.length - 1; x++) {
			if (array1[x] > array2[x]) {
				nuevo[x] = array1[x];
			} else if (array1[x] < array2[x]) {
				nuevo[x] = array2[x];
			} else {
				nuevo[x] = array2[x];
			}
		}
		for (int numero : nuevo) {
			System.out.print(numero + " ");
		}
	}
}