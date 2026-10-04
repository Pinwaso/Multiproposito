package Clase.Ejemplos;

import java.util.Scanner;

public class Suma {

	public static int suma(int sum) {
		if (sum>1) {			 
			 
			int temporal=suma(sum-1)+sum;
			System.out.print("+"+sum); 
			 return temporal;
		}else {
		     System.out.print(sum);
		     return 1;
		}		
	}	
	public static void main(String[] args) {
 	   System.out.print("Introduzca un numero: ");   
		Scanner sc=new Scanner(System.in);
		   try {        	   
        	   int resultado=suma(sc.nextInt());			 
        	   System.out.println("="+resultado);
           }catch(Exception ex) {
        	   System.out.println("no ha introducido un numero");
           }finally {
        	   sc.close();
        	   String pepe="   hola me llamo lucas   ";
        	   System.out.println(pepe.trim().toUpperCase().toLowerCase());
        	   pepe.trim().trim().trim().trim();
           }
		  
	}

}
