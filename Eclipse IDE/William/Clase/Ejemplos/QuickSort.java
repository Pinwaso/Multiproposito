package Clase.Ejemplos;

import java.util.Arrays;

public class QuickSort {
	public static void quicksort(int A[]) {
		quicksort(A, 0, A.length-1);
	}
	public static void quicksort(int A[], int izq, int der) {
		int pivote = A[izq]; // tomamos primer elemento como pivote
		int i = izq; // i realiza la búsqueda de izquierda a derecha
		int j = der; // j realiza la búsqueda de derecha a izquierda
		int aux;
		while(i < j){ // mientras no se crucen las búsquedas
			while(A[i] <= pivote && i < j) 
				i++; // busca elemento mayor que pivote
			while(A[j] > pivote) 
				j--; // busca elemento menor que pivote
			if (i < j) { // si no se han cruzado
				aux = A[i]; // los intercambia
				A[i] = A[j];
				A[j] = aux;
			}
		}
		A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
		A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
		if(izq < j-1) { 
			quicksort(A, izq, j-1);
			System.out.print("derecha ");
			for (int indice=izq;indice<j-1;indice++) {
			 System.out.print(A[indice]+" ");
			}
			System.out.println("");
		} // ordenamos subarray izquierdo
		if(j+1 < der) { 
			quicksort(A, j+1, der);		
			System.out.print("izquierda ");
			for (int indice=j+1;indice<der;indice++) {
				System.out.print(A[indice]+" ");
			}			
			System.out.println("");		
		}
	}
	public static void main(String[] args) {
		int[] array= {43,20,35,68,93,4,16,50};
		System.out.println("inicial" +Arrays.toString(array));

		quicksort(array);
		System.out.println("final" +Arrays.toString(array));

	}

}
