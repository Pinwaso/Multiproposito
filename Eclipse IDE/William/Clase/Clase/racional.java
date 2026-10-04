package Clase.Clase;

import java.util.Scanner;

public class racional {
	static Scanner entrada = new Scanner (System.in);
	private int numerador;
	private int denominador;
	
	public racional() {
		this.numerador = 0;
		this.denominador = 1;
	}
	
	public racional (int numerador, int denominador) {
		this.setNumerador(numerador);;
		this.setDenominador(denominador);
	}
	
	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		if (denominador != 0) {
			this.denominador = denominador;
		} else {
			this.denominador = 1;
		}
	}
	
	@Override
	public String toString() {
		return "racional [numerador=" + numerador + ", denominador=" + denominador + "]";
	}
	
	public static void main(String[] args) {

		racional numeroA = new racional();
		racional numeroB = new racional();
		boolean fin = false;
		do {
			System.out.println("""
					1 - Introduce numero A
					2 - Introduce numero B
					3 - Suma de A y B
					4 - Resta de A y B
					5 - Multiplicacion de A y B
					6 - Division de A y B
					7 - Son iguales A y B
					8 - Salir
					""");
			int valor = pedirnumero("", "valor invalido");
			switch (valor) {
			case 1:
				numeroA.setNumerador(pedirnumero("Ingrese el numerador del numero A", "valor invalido"));
				numeroA.setDenominador(pedirnumero("Ingrese el denominador del numero A", "valor invalido"));
				break;
			case 2:
				numeroB.setNumerador(pedirnumero("Ingrese el numerador del numero B", "valor invalido"));
				numeroB.setDenominador(pedirnumero("Ingrese el denominador del numero B", "valor invalido"));
				break;
			case 3:
				System.out.println((numeroA.getNumerador() * numeroB.getDenominador()) + (numeroB.getNumerador() * numeroA.getDenominador()) + " / " + (numeroA.getDenominador() * numeroB.getDenominador()));
				break;
			case 4:
				System.out.println((numeroA.getNumerador() * numeroB.getDenominador()) - (numeroB.getNumerador() * numeroA.getDenominador()) + " / " + (numeroA.getDenominador() * numeroB.getDenominador()));
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:
				fin = true;
				break;
			default: 
				System.out.println("valor invalido");
			}
		} while (!fin);
	}
	
	static int pedirnumero(String mensaje, String error) {
		boolean correcto = false;
		int valor = 0;
		do {
			try {
				System.out.println(mensaje);
				valor = entrada.nextInt();
				correcto = true;
			} catch (Exception ex) {
				System.out.println(error);
				entrada.nextLine();
			}
		} while (!correcto);
		return valor;
	}
}