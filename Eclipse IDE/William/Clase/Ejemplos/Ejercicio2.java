package Clase.Ejemplos;

import java.util.Scanner;

public class Ejercicio2 {
  public static void main (String[] args) {
	 
	  
	  
	  Scanner entrada=new Scanner(System.in);
	  int numero=0;
	  boolean correcto=false;
	  do {
		  try{
			  System.out.println("Introduzca un número");
			  numero=entrada.nextInt();
			   correcto=true;
		  }catch (Exception ex) {}
	  }while (!correcto);
	  int n=numero,numDig=0;	  
	  while (n!=0) {
		  n=n/10;
		  numDig++;
	  }
	  System.out.println("el número: "+numero+" tiene "+numDig+" digitos");
	  
	  
	  
	  
  }
	
}
