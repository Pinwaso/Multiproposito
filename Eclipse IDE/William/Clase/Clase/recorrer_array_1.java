package Clase.Clase;

public class recorrer_array_1 {

	public static void main(String[] args) {
		int[][] array1 = {{4,6,3},{5,8,7}};
		for (int[] fila : array1) {
			for (int columna : fila) {
				System.out.print(columna + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int y = 0 ; y < array1[0].length ; y++) {
			for (int x = 0 ; x < array1.length ; x++) {
				System.out.print(array1[x][y] + " ");
			}
			System.out.println();
		}
	}
}