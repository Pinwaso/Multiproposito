package Clase.Ejemplos;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Clase que sirve para completar un array de tamano n y valor m pasados como parametro
 */

public class ejercicio1 {
	

	/**
    * Devuelve un array de un tamaño máximo pasado, rellenado con valores  aleatorios entre 0 y el parametro pasado 
    * @param tamano tamaño del array
    * @param maximo el número máximo de las celdas
    * @return array[][] de enteros.
    */
   static int[][]  completarArray(int tamano,int maximo){
	   int array[][] =new int[tamano][tamano];
	   for (int filas=0;filas<array.length;filas++) {
		   for (int columnas=0;columnas<array[filas].length;columnas++) {
			   array[filas][columnas]= (int)(Math.random()*(maximo+1));
		   }
	   }
	   return array;	   
   }
   
    static int[][]  completarArray(int cMinFilas,int cMaxFilas,int cMinColumn,int cMaxColumnas,int maximo){
    	
    	int valor=(int)(Math.random()*(cMaxFilas-cMinFilas+1)+cMinFilas);
    	int[][] array=new int[valor][];
	    for (int indice=0;indice<valor;indice++) {
	    	int columnas=(int)(Math.random()*(cMaxColumnas-cMinColumn+1)+cMinColumn);
            array[indice]=new int[columnas];
	    }
	    for (int filas=0;filas<array.length;filas++) {
			   for (int columnas=0;columnas<array[filas].length;columnas++) {
				   array[filas][columnas]= (int)(Math.random()*(maximo+1));
			   }
		   }	    
		return array;
	
	}	
   
   static void  mostarArray(int[][] array){
	   for(int[] fila: array) {
		   for (int celda: fila) {
			System.out.print(celda+" ");   
		   }		   
		   System.out.println(" ");
	   }
   }
	static int pedirNumero(String mensaje,Scanner entrada) {
			int dato=0;
			boolean correcto=false;
			do {
				try {
					entrada=new Scanner(System.in);
					System.out.print(mensaje);
		        	dato=entrada.nextInt();
		        	correcto=true;
		        }catch (Exception ex) {
		        	System.out.println("Número incorrecto");
		        	entrada=new Scanner(System.in);
		        }
			}while(!correcto);
			return dato;
	}
	
   
	public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int tamano=pedirNumero("Introduce el tamaño de la matriz: ",entrada);
        int valor=pedirNumero("Introduce el valor máximo de la matriz: ",entrada);
        mostarArray(completarArray(2,8,1,101, valor));
		entrada.close();
		
	}

}
