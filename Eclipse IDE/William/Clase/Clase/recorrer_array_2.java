package Clase.Clase;

public class recorrer_array_2 {

	public static void main(String[] args) {
		int[][][] array = {{{1,2},{3,4}},{{5,6},{7,8}},{{9,10},{11,12}}};
		for (int a = 0 ; a < array.length ; a++) {
			System.out.println("PISO " + a);
			for (int b = 0 ; b < array[a].length ; b++) {
				System.out.print("FILA " + b + "  ");
				for (int c = 0 ; c < array[a][b].length ; c++) {
					System.out.print(array[a][b][c] + " ");
				}
				System.out.println();
			}
		}
	}
}