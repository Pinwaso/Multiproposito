package Clase.Ejemplos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prueba {

	public static void prueba() throws Exception {
		throw new Exception("Mensaje de error...");	
	}
	
	public static void main(String[] args) {
		try {
			Prueba.prueba();
			
		}  catch (Exception e) {
			System.out.println(e.getMessage());			
		}
		finally {
			System.out.println("Fin del programa");
		}
		System.out.println("Esto NO se muestra");

	}
}
