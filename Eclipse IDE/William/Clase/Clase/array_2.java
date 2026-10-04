package Clase.Clase;

import java.util.Scanner;

public class array_2 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		String[] datos = {"pepe","amarillo","manzana","pi","tangamandapio"};
		array(datos);
	}
	
	static void array(String[] datos) {
		String palabra = "";
		int maslargo = Integer.MIN_VALUE;
		for (String dato : datos) {
			if (dato != null && dato.length() > maslargo) {
				maslargo = dato.length();
				palabra = dato;
			}
		}
		System.out.println("La palabra mas larga es " + palabra);
	}
}