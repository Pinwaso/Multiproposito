package Clase.Ejemplos;

public class pruebaBidimensionales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matriz = {
				{1,2,3,4,5},
				{6,7,8},
				{11}
				};
		for (int fila=0;fila<matriz.length;fila++) {
			//int[] fila=matriz[indice];
			for (int columna=0;columna<matriz[fila].length;columna++) {
				System.out.print(matriz[fila][columna]+" ");
			}
			System.out.println("");
		}
		
		matriz=null;
		
		for (int fila[]:matriz) {
			for (int columna:fila) {
				System.out.print(columna+" ");
			}			
			System.out.println("");
		}
		
		
		
		
	}

}
