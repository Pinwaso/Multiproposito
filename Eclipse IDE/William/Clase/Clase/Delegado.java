package Clase.Clase;

import java.util.ArrayList;
import java.util.Scanner;

public class Delegado {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int cantidad = entrada.nextInt();
		int saltos = entrada.nextInt();
		if (cantidad == 0 && saltos == 0) {
			return false;
		} else {
			ArrayList<Integer> alumnos = new ArrayList<>();
			for (int i = 1; i <= cantidad; i++) {
				alumnos.add(i);
			}
			int indice = 0;
			saltos = saltos;
			while (alumnos.size() > 1) {
				indice = (indice + saltos) % alumnos.size();
				alumnos.remove(indice);
			}
			System.out.println(alumnos.get(0));
			return true;
		}
	}
}
