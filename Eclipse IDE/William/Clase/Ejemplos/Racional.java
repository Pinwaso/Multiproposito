package Clase.Ejemplos;

import java.io.IOException;
import java.util.Scanner;

public class Racional {
	private int denominador, nominador;
	private Scanner entrada;

	public Racional() {
		denominador = 0;
		nominador = 0;
		entrada = new Scanner(System.in);
	}

	private double suma() {
		return this.denominador + this.nominador;
	}

	private double multiplicacion() {
		return this.nominador * this.denominador;
	}

	private double resta() {
		return this.nominador - this.denominador;
	}

	private double division() throws Exception {
		if (denominador == 0) {
			throw new Exception("el denominador no puede ser cero");
		}
		return this.nominador / this.denominador;
	}

	private boolean isEqual() {
		return (this.nominador == this.denominador);
	}

	private int solicitarNumero(String mensaje) {

		int numero = 0;
		boolean correcto = false;
		do {
			try {
				System.out.print(mensaje + " ");
				numero = entrada.nextInt();
				correcto = true;
			} catch (Exception ex) {
				entrada = new Scanner(System.in);
				System.out.println("No ha introducido un número entero");
			}
		} while (!correcto);
		return numero;
	}

	public static void main(String[] args) {
		int opcion = 0;
		Racional racional = new Racional();
		do {
			System.out.print("\033[2J"); // Borra la pantalla completa
			System.out.print("\033[H"); // Mueve el cursor a la esquina superior izquierda

			System.out.println("1. Introduce número A\r\n" + "2. Introduce número B\r\n" + "3. Suma de A y B\r\n"
					+ "4. Resta de A y B\r\n" + "5. Multiplicación de A y B\r\n" + "6. División de A y B\r\n"
					+ "7. Son iguales A y B\r\n" + "8. Salir");
			opcion = racional.solicitarNumero("Introduce tu opción");
			switch (opcion) {
			case 1: {
				racional.setNominador(racional.solicitarNumero("Introduce el nominador"));
				break;
			}
			case 2: {
				racional.setDenominador(racional.solicitarNumero("Introduce el denominador"));
				break;
			}
			case 3: {
				System.out.println("La suma es: " + racional.suma());
				;
				break;
			}
			case 4: {
				System.out.println("La resta es: " + racional.resta());
				;
				break;
			}
			case 5: {
				System.out.println("La multiplicación es: " + racional.multiplicacion());
				;
				break;
			}
			case 6: {
				try {
					System.out.println("La división es: " + racional.division());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 7: {
				System.out.println("Son iguales: " + racional.isEqual());
				break;
			}
			default: {
				System.out.println("Debe introducir un número comprendido entre 1 y 8");
			}
			}
		} while (opcion != 8);
	}
	/**
	 * @return the denominador
	 */
	int getDenominador() {
		return denominador;
	}
	/**
	 * @return the nominador
	 */
	int getNominador() {
		return nominador;
	}
	/**
	 * @param denominador the denominador to set
	 */
	void setDenominador(int denominador) {
		this.denominador = denominador;
	}
	/**
	 * @param nominador the nominador to set
	 */
	void setNominador(int nominador) {
		this.nominador = nominador;
	}
}