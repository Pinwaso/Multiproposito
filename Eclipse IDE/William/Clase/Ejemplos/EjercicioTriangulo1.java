package Clase.Ejemplos;

import java.util.*;

public class EjercicioTriangulo1 {
	
	public static int apublic=4;
	private static int aprivate=3;
	protected static int aprotected=4;
	static int apackage=5;
	
	
    public static void main(String[] args) {
    	
    	
    	
    	
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce una altura: ");
        int nAltura =entrada.nextInt();
        
        System.out.print("Introduce una anchura: ");
        int nAnchura =entrada.nextInt();
        
        System.out.print("¿Con relleno?(true/false): ");
        boolean relleno = entrada.nextBoolean();
       
        
        for (int altura=1; altura <= nAltura; altura++) {
        	for (int anchura= 1; anchura <= altura; anchura++) {
        		if (relleno) {        		
	        		System.out.print("* ");
	            }else {
	            	if (altura==1 || altura==nAltura) {
	            		System.out.print("* ");	            		
	            	}else if (anchura==1 || anchura==altura) {
	            		System.out.print("* ");	            
	            	}else {
	            		System.out.print("  ");
	            	}
	            }
        	}
        	System.out.println("");
        }      
        
        for (int altura=nAltura; altura >=1; altura--) {
        	for (int anchura= altura; anchura >=1; anchura--) {
        		if (relleno) {        		
	        		System.out.print("* ");
	            }else {
	            	if (altura==1 || altura==nAltura) {
	            		System.out.print("* ");	            		
	            	}else if (anchura==1 || anchura==altura) {
	            		System.out.print("* ");	            
	            	}else {
	            		System.out.print("  ");
	            	}
	            }
        	}
        	System.out.println("");
        }  
        
        
       entrada.close();	        
    }    
}
