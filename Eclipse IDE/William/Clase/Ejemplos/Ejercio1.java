package Clase.Ejemplos;

import java.util.Scanner;

public class Ejercio1 {
	

		public static void main(String[] args) {
		
			
			Scanner entrada=new Scanner(System.in);
			int cantidadNumeros=0,nmax=Integer.MIN_VALUE,nmin=Integer.MAX_VALUE,
			rmax=0,rmin=0;
			boolean correcto=false;
			do {
					try {
						System.out.print("Introduce el número de elementos que contara el ejercicio");
						cantidadNumeros=entrada.nextInt();
						if (cantidadNumeros>=0) {
							correcto=true;
						}
					}catch (Exception ex) {
						entrada=new Scanner(System.in);
					}
			}while (!correcto);
			int indice=1;
			//opcion 1
			while (indice<=cantidadNumeros) {
				try {				
					System.out.print("Introduce el número "+indice+" de "
				             +cantidadNumeros+" números totales: ");
					int numeroIntroducido=entrada.nextInt();
					indice++;
					//codigo comprobación
					rmax=(numeroIntroducido==nmax)?rmax++:(numeroIntroducido>nmax)?1:rmax;
					nmax=(numeroIntroducido>nmax)? numeroIntroducido:nmax;
					
					if (numeroIntroducido>nmax) {
						nmax=numeroIntroducido;
						rmax=1;
					}else if(numeroIntroducido==nmax) {
						rmax++;
					}
					if (numeroIntroducido<nmin) {
						nmin=numeroIntroducido;
						rmin=1;
					}else if(numeroIntroducido==nmin) {
						rmin++;
					}
				}catch (Exception ex) {entrada=new Scanner(System.in);}
			
			
			
			System.out.println("el número menor es: "+nmin+"\n y aparece "+rmin);
			System.out.println("el número mayor es: "+nmax+"\n y aparece "+rmax);
			}
		/**
			//opcion 2
			for (int indice=1; indice<=cantidadNumeros;indice++) {
				correcto=false;
				do {
					try {				
						System.out.print("Introduce el número "+indice+" de "
					             +cantidadNumeros+" números totales: ");
						cantidadNumeros=entrada.nextInt();
						correcto=true;
						//codigo comprobación
					}catch (Exception ex) {	entrada=new Scanner(System.in);}				
				}while (!correcto);
			}
			//opcion 3
			for (int indice=1; indice<=cantidadNumeros;) {
				try {				
					System.out.print("Introduce el número "+indice+" de "
				             +cantidadNumeros+" números totales: ");
					cantidadNumeros=entrada.nextInt();
					indice++;
					//codigo comprobación
				}catch (Exception ex) {	entrada=new Scanner(System.in);}
			}
			*/
			
			
			
			
			
			
			
			
				
		  }
	}

