package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  Es el ejercicio 697 de Acepta el reto
 * 
 * @author William Andrés
 * @version 13.01.2026
 */
public class espiral_galactica_697 {
	static Scanner entrada = new Scanner(System.in);
	static int[][] tabla;
	static int resultado;
	static int X;
	static int Y;

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int tamano = entrada.nextInt();
		if (tamano == 0) {
			return false;
		} else {
			tabla = new int[tamano][tamano];
			resultado = 0;
			X = tamano / 2;
			Y = tamano / 2;
			for (int i = 0; i < tabla.length; i++) {
				for (int a = 0; a < tabla[i].length; a++) {
					tabla[i][a] = entrada.nextInt();
				}
			}
		}
		entrada.nextLine();
		sumartabla();
		System.out.println(resultado);
		return true;
	}
	
	
	static boolean puntovalido() {
		if ((X >= 0 && X < tabla[0].length) && (Y >= 0 && Y < tabla.length)) {
			return true;
		}
		return false;
	}
	static void sumartabla() {
		int contador = 2;
		boolean correcto = false;
		resultado+=tabla[Y][X];
		--Y;
		do {
			if(!derecha(contador)) break;
			++contador;
			if(!abajo(contador)) break;
			++contador;
			if(!izquierda(contador)) break;
			++contador;
			if(!arriba(contador)) break;
			++contador;
		} while (!correcto);
	}
	static boolean arriba(int contador) {
		for (int i = 0; i < contador; i++) {
			if (!puntovalido()) {
				return false;
			}
			resultado+=tabla[Y][X];
			--Y;
		}
		return true;
	}
	static boolean izquierda(int contador) {
		for (int i = 0; i < contador; i++) {
			if (!puntovalido()) {
				return false;
			}
			resultado+=tabla[Y][X];
			--X;
		}
		return true;
	}
	static boolean abajo(int contador) {
		for (int i = 0; i < contador; i++) {
			if (!puntovalido()) {
				return false;
			}
			resultado+=tabla[Y][X];
			++Y;
		}
		return true;
	}
	static boolean derecha(int contador) {
		for (int i = 0; i < contador; i++) {
			if (!puntovalido()) {
				return false;
			}
			resultado+=tabla[Y][X];
			++X;
		}
		return true;
	}
}