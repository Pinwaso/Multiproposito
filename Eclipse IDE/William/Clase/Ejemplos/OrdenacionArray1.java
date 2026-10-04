package Clase.Ejemplos;

import java.util.Arrays;

public class OrdenacionArray1 {

	public static void main(String[] args) {
		/**
		int[] array= {3,29,46,23,99,72,84,36,50,1};
		System.out.println("array sin ordenar: "+Arrays.toString(array));
	    
		for (int indice1=0;indice1<array.length-1;indice1++) {
			System.out.println("iteracion "+indice1+"array sin ordenar: "+Arrays.toString(array));			
			for (int indice=indice1+1;indice<array.length;indice++) {
				if (array[indice]<array[indice1]) {
					int aux=array[indice1];
					array[indice1]=array[indice];
					array[indice]=aux;
				}
			}
		}
		*/
		int[] array1= {3,29,46,23,99,72,84,36,50,1};
		Arrays.sort(array1);
		
		System.out.println("array ordenado: "+Arrays.toString(array1));
		for (int origen=0;origen<array1.length-1;origen++) {
			for (int destino=1;destino<array1.length-origen;destino++) {			
				if (array1[destino-1]>array1[destino]) {
					int aux=array1[destino-1];
					array1[destino-1]=array1[destino];
					array1[destino]=aux;
				}
			}
		}
		System.out.println("array ordenado: "+Arrays.toString(array1));
	

	
	}
}
