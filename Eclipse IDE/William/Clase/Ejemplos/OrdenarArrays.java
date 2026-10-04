package Clase.Ejemplos;

public class OrdenarArrays {
   /**
    * Variable con el valor pi
    */
	public static double pi;
	
	
	static int[] ordenar(int[] array1, int[] array2) {
		int longitudArray1= devolverLongitud(array1);
	    int longitudArray2= devolverLongitud(array2);
		if (longitudArray1>longitudArray2) {
			return completarTamanoArray(array1,array2);
		}else {
			return completarTamanoArray(array2,array1);
		}	    		
	}
	/**
	 * Metodo que me devuelve la longitud de un array en caso de ser nulo -2
	 * @param array array de enteros
	 * @return int tamaño de la cadena de enteros
	 */
	 	 
	static int devolverLongitud(int[] array) {
		if (array==null)
			return -1;		
		return array.length;
		
	}
	
	static int[] completarTamanoArray(int[] array1, int[] array2) {
	   
		int[] resultado; 
		if (devolverLongitud(array1)==-1) {
			resultado=null;
		}else {
			resultado=new int[devolverLongitud(array1)];
		}
		
		int indice=0;
		for (;indice<devolverLongitud(array2);indice++) {
			if (array1[indice]>array2[indice]) {
				resultado[indice]=array1[indice];
			}else {
				resultado[indice]=array2[indice];
			}
		}
		//for (int indice=devolverLongitud(array2))
		for (;indice<devolverLongitud(array1);indice++) {
			resultado[indice]=array1[indice];
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		int[] array2= {1,32,4,5,7};
		int[] array1= {2,3,4,7};
		int[] resultado= ordenar(array1,array2);
		System.out.print("Los elementos ordenados son: ");
		for(int resu:resultado) {
			System.out.print(resu+" ");
		}
		System.out.println("");
	}
}