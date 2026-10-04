package Competitiva.Zaragoza;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A_clasificacion_de_acepta_el_reto {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int numero = entrada.nextInt();
		if (numero == 0) {
			return false;
		}
		TreeMap<Integer, Integer> jugadores = new TreeMap<>(Collections.reverseOrder());
		LinkedHashMap<Integer, Integer> auxiliar = new LinkedHashMap<>(); 
		for (int i = 0 ; i < numero; i++) {
			int jugador = entrada.nextInt();
			int tiempo = entrada.nextInt();
			
			int tiempo_viejo = jugadores.getOrDefault(jugador, Integer.MAX_VALUE);
			if (tiempo_viejo < tiempo) {
				tiempo = tiempo_viejo;
			}
			jugadores.put(jugador, tiempo);
		}
		for (Map.Entry<Integer, Integer> jugador : jugadores.entrySet()) {
			System.out.print(jugador.getKey() + " ");
			System.out.println(jugador.getValue());
		}
		return true;
	}
}