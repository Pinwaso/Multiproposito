package Clase.Ejemplos;


public class AdiosMundo extends EjercicioTriangulo1{

	public static void main(String[] args) {
		int[] nulo =null;
		int[][] matriz= {{4,6,9,1,0},{5,8,7},{3,6},{2},nulo};
		
		for (int i=0;matriz.length>i;i++) {
			if (matriz[i]!=null) {
				for (int j=0;matriz[i].length>j;j++) {
					System.out.print(matriz[i][j]+" "); 
				}
				System.out.println("");
			}else {
				System.out.println("fila nula");
			}
			
		}
		
		int tamanoMaximo=0;
		
		
		for (int i=0;i<matriz.length;i++) {
			if (matriz[i]!=null && matriz[i].length>tamanoMaximo) {
				tamanoMaximo=matriz[i].length;
			}
		}
		
		for (int columna=0;columna<tamanoMaximo;columna++) {			
			for (int j=0;j<matriz.length;j++) {				
				if (matriz[j]!=null && matriz[j].length>columna) {
					System.out.print(matriz[j][columna]+" ");
				}else {
					System.out.print("X ");
				}
			}
			System.out.println(""); //3
		}
		
		
		
	}

}
