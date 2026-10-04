package Clase.Ejemplos;

import java.util.Arrays;
import java.util.Scanner;

public class RellenarArray {

	static Scanner entrada;
	/**
	 * 
	 * @param mensaje
	 * @param mensajeError
	 * @return
	 */
	private static int solicitarNumero(String mensaje,String mensajeError) {
		int variable=0;
		boolean correcto=false;
		do {
			try {
	            System.out.print (mensaje);
	        	variable=entrada.nextInt();
	        	correcto=true;
	        }catch (Exception ex) {	       
	        	System.out.println (mensajeError);
	        }
		}while (!correcto);
		return variable;
	}
	
	private static int[][] rellenarArray (int filas, int columnas){
		int[][] array=new int[filas][columnas];
		for (int nfilas=0;nfilas<filas;nfilas++) {
			for (int ncolumnas=0;ncolumnas<columnas;ncolumnas++) {				
				array[nfilas][ncolumnas]= solicitarNumero("Introduzca el dato de la fila: "+nfilas+" y la columna: "+ncolumnas+" ","Tiene que introducir un número");                
			}
		}
		return array;
	}
	
	private static void mostrarArray (int[][] array) {
	
		/*
		for (int nfilas=0;nfilas<array.length;nfilas++) {
			for (int ncolumnas=0;ncolumnas<array[nfilas].length;ncolumnas++) {				
				System.out.print(array[nfilas][ncolumnas]+" ");                
			}
			System.out.println();
		}*/
	}
	
	
	public static void main(String[] args) {
		System.out.println("---");
		for (String dato:args) {
			System.out.println (dato);
		}
		System.out.println("---");
		
		int[][] array4 = {{3,8,5},{4,1,8,4},{5,2}};
		for(int[] fila : array4) {
		System.out.println(Arrays.toString(fila));
		Arrays.sort(fila);
		System.out.println(Arrays.toString(fila));
	
		
		
	
}
	}
}
