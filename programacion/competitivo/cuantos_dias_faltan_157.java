package competitivo;

import java.util.Scanner;

/**
 * ¿Cuantos dias faltan? Es el ejercicio 157 de Acepta el reto
 * 
 * @author William Andrés
 * @version 11.11.2025
 */
public class cuantos_dias_faltan_157 {
	static Scanner entrada = new Scanner(System.in);
	static int meses[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	static int diastotales = 0;
	
	public static void main(String args[]) {
		for (int dias : meses) {
			diastotales += dias;
		}
		int numCasosDePrueba = entrada.nextInt();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {	
		int totales = diastotales;
		int dia = entrada.nextInt();
		int mes = entrada.nextInt();
		if (mes == 1) {
			totales -= dia;
		} else {
			for (int b = 0 ; b < mes; b++) {
				totales -= meses[b];
			}
			totales += meses[mes-1]-dia;
		}
		System.out.println(totales);
	}
}
