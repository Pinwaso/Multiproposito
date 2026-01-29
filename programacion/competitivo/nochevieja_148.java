package competitivo;

import java.util.Scanner;

/**
 * Nochevieja Es el ejercicio 148 de Acepta el reto
 * 
 * @author William Andrés
 * @version 28.10.2025
 */
public class nochevieja_148 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		String hora = entrada.nextLine();
		if (hora.equals("00:00")) { 
			return false;
		} else {
			
			int horas = Integer.parseInt(hora.substring(0, 2));
			int minutos = Integer.parseInt(hora.substring(3));
			System.out.println(1440 - (horas * 60) - minutos);
			return true;
		}
	}
}
