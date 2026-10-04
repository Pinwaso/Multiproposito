package Clase.Clase;

import java.util.Scanner;

public class calcular_dni {
	static Scanner entrada = new Scanner (System.in);
	
	public static void main(String[] args) {
		char equivalencias[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int dni = pedirnumero("Ingrese el numero de DNI", "Valor invalido");
		if (comprobarnumero(dni)) {
			System.out.println("" + equivalencias[dni % 23] + dni);
		}
	}
	
	/**
	 * Método para pedir un valor numérico, este comprueba que sea un número de 8 digitos
	 * @param mensaje mensaje para ingresar el número
	 * @param error mensaje de error
	 * @return devuelve un número de 8 dígitos
	 */
	static int pedirnumero(String mensaje, String error) {
		boolean correcto = false;
		int numero = 0;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextInt();
				if (String.valueOf(numero).length() == 8) {
					correcto = true;
				} else {
					System.out.println(error);
				}
			} catch (Exception ex) {
				System.out.println(error);
				entrada.nextLine();
			}
		} while (!correcto);
		return numero;
	}
	
	/**
	 * Metodo para comprobar que el número pueda tener una letra
	 * @param dni numero previamente comprobado
	 * @return booleanos para saber si puede tener letra o no
	 */
	static boolean comprobarnumero(int dni) {
		int resultado = dni % 23;
		if (resultado < 0 && resultado > 22) {
			System.out.println("El numero no supera el caso de prueba");
			return false;
		}
		return true;
	}
}