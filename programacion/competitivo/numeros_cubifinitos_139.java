package competitivo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Es el ejercicio 139 de Acepta el reto
 * 
 * @author William Andrés
 * @version 13.01.2026
 */
public class numeros_cubifinitos_139 {
	static Scanner entrada = new Scanner(System.in);
	static ArrayDeque<Integer> pila = new ArrayDeque<>();
	static ArrayList<Integer> salidos = new ArrayList<>();
	
	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int numero = entrada.nextInt();
		if (numero == 0) {
			int tamano = pila.size();
			for (int i = 0; i < tamano; i++) {
				mensaje();
			}
			return false;
		} else {
			pila.add(numero);
			return true;
		}
	}
	private static int cubo(int numero) {
		return numero*numero*numero;
	}
	private static int cubifinito(int numero) {
		int total = 0;
		while (numero!=0) {
			total+=cubo(numero % 10);
			numero=numero/10;
		}
		return total;
	}
	private static void mensaje() {
		int valorActual=pila.poll();
		boolean correcto = false;
		do {
			if (valorActual == 1) {
				System.out.println("1 -> cubifinito.");
				break;
			} else if (salidos.contains(valorActual)) {
				System.out.println(valorActual + " -> no cubifinito.");
				break;
			} else {
				System.out.print(valorActual + " - ");
			}
			salidos.add(valorActual);
			valorActual=cubifinito(valorActual);
		} while (!correcto);
	}
}