package Clase.Clase;

import java.util.Arrays;

public class ordenar_arrays {

	public static void main(String[] args) {
		//arraysort();
		ordenararray();
	}
	
	static void arraysort() {
		int array1[] = { 1, 4, 8 };
		int array2[] = { 6 };
		int nuevoarray[] = new int[array1.length + array2.length];
		System.arraycopy(array1, 0, nuevoarray, 0, array1.length);
		System.arraycopy(array2, 0, nuevoarray, array1.length, array2.length);
		Arrays.sort(nuevoarray);
		System.out.println(Arrays.toString(nuevoarray));
	}
	
	static void ordenararray() {
		boolean correcto = true;
		int array[] = { 3, 29, 46, 23, 99, 72, 84, 36, 50 };
		do {
			correcto = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i + 1] < array[i]) {
					int num1 = array[i], num2 = array[i + 1];
					array[i] = num2;
					array[i + 1] = num1;
					correcto = false;
				}
			}
		} while (!correcto);
		System.out.println(Arrays.toString(array));
	}
}