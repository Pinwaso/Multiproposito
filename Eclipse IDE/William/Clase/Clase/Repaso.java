package Clase.Clase;

import java.util.Scanner;

public class Repaso {

	public static void main(String[] args) {
		Repaso aplicasion = new Repaso();
		aplicasion.aplicacion();
	}
	
	private void aplicacion() {
		System.out.println("Ingrese la ruta del archivo");
		Scanner sc = new Scanner(System.in);
		String ruta = sc.nextLine().trim();
		sc.close();
	}
}