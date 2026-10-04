package Clase.Ejemplos;

import java.util.Scanner;

public class EjemploSobrecarga {
	static int base2=3;
	int lado1=5;
    int lado2=5;
	
	
	
	public static double calcularArea(Integer base, Integer altura) {
		System.out.println(base2);
		int base2=43;
		base2++;
		System.out.println(base2);
		
		
		base=1;
		altura=1;
		System.out.println("entramos enteros");
		return base*altura;
	}
	
	
	public static double calcularArea(double lado) {
		return lado*lado;
	}
	public static double calcularArea(double base, double altura) {
		return base*altura;
	}
	
	public static String solicitarLado(String mensaje,Scanner sc) {		
		System.out.println(mensaje);
		return sc.nextLine();
	}	
	
	public static void main(String[] args) {
		Scanner entrada= new Scanner(System.in);
		String cadena1=solicitarLado("introduce cadena 1", entrada);
		String cadena2=solicitarLado("introduce cadena 2", entrada);
		System.out.println(cadena1);
		System.out.println(cadena2);

	}

}
