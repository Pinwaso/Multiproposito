package Clase.Clase;

import java.util.Arrays;
import java.util.Scanner;

public class William_andres_barco {
	static Scanner entrada = new Scanner(System.in);
	static int[] primeraClase;
	static int[] segundaClase;
	/**
	 * Método para pedir numero de ticket entre -103 y 103
	 * @param mensaje mostrar mensaje personalizado
	 * @return devuelve un número entero
	 */
	static int pedirTicket(String mensaje) {
		boolean correcto = false;
		int ticket = 0;
		do {
			try {
				System.out.println(mensaje);
				ticket = entrada.nextInt();
				entrada.nextLine();
				if (ticket >= -103 && ticket <= 103) {
					correcto = true;
				}
			} catch (Exception ex) {
				System.out.println("Valor inválido");
				entrada.nextLine();
			}
		} while (!correcto);
		return ticket;
	}
	/**
	 * Método para pedir numeros de pasajeros entre 1 y 200
	 * @param mensaje mostrar mensaje personalizado
	 * @return devuelve un número entero
	 */
	static int pedirClase(String mensaje) {
		boolean correcto = false;
		int primeraClase = 0;
		do {
			try {
				System.out.println(mensaje);
				primeraClase = entrada.nextInt();
				entrada.nextLine();
				if (primeraClase >= 1 && primeraClase <= 200) {
					correcto = true;
				}
			} catch (Exception ex) {
				System.out.println("Valor inválido");
				entrada.nextLine();
			}
		} while (!correcto);
		return primeraClase;
	}
	/**
	 * Método para inicializar los arrays de primera y segunda clase
	 * @param primera cantidad de personas de primera clase
	 * @param capacidadTotal cantidad de personas de segunda clase (más la de primera)
	 */
	static void crear(int primera, int capacidadTotal) {
		primeraClase = new int[primera];
		segundaClase = new int[capacidadTotal];
	}
	/**
	 * Método para mostrar los Arrays de primera, segunda clase y todos juntos
	 */
	static void mostrar() {
		System.out.println("Primera");
		System.out.print(Arrays.toString(primeraClase));
		System.out.println("Segunda");
		System.out.print(Arrays.toString(segundaClase));
		System.out.println("Juntos y ordenados sin usar otro Array");
		juntarOrdenadoSinUsarOtroArray();
		Arrays.sort(segundaClase);
		System.out.print(Arrays.toString(segundaClase));
	}
	/**
	 * Método para saber si un numero es mayor que otro
	 * @param numero numero que se va a comparar 
	 * @param array Array donde 
	 * @param posicion posicion del array que se comparará
	 * @return
	 */
	static boolean esMayor(int numero, int[] array, int posicion) {
		boolean correcto = false;
		if (numero > array[posicion]) {
			correcto = true;
		}
		return correcto;
	}
	/**
	 * Método para rellenar los arrays tanto de primera como de segunda clase
	 */
	static void rellenar() {
		for (int i = 0; i < primeraClase.length; i++) {
			boolean correcto = false;
			do {
				try {
					int ticket = pedirTicket("Dame el ticket del pasajero " + i + " de primera");
					if (i == 0) {
						if (ticket <= 103-primeraClase.length) {
							primeraClase[i] = ticket;
							correcto = true;
						}
					} else {
						if (esMayor(ticket, primeraClase, i-1) && ticket <= 103-(primeraClase.length-(i+1))) {
							primeraClase[i] = ticket;
							correcto = true;
						}
					}
				} catch (Exception ex){
					entrada.nextLine();
				}
			} while (!correcto);
		}
		
		int capacidadSegunda = segundaClase.length-primeraClase.length;
		for (int i = 0; i < capacidadSegunda; i++) {
			boolean correcto = false;
			do {
				try {
					int ticket = pedirTicket("Dame el ticket del pasajero " + i + " de segunda");
					if (i == 0) {
						if (ticket <= capacidadSegunda) {
							segundaClase[i] = ticket;
							correcto = true;
						}
					} else {
						if (esMayor(ticket, segundaClase, i-1) && ticket <= 103-(capacidadSegunda-(i+1))) {
							segundaClase[i] = ticket;
							correcto = true;
						}
					}
				} catch (Exception ex){
					entrada.nextLine();
				}
			} while (!correcto);
		}
	}
	/**
	 * Método para hallar la primera pocicion de un "0"
	 * dentro de un array
	 * @return devuelve la primera posicion del "0" encontrado
	 */
	static int hallarCero() {
		int posicion = 0;
		for (int i = 0; i < segundaClase.length; i++) {
			if (segundaClase[i] == 0) {
				posicion = i;
				break;
			}
		}
		return posicion;
	}
	/**
	 * Método para juntar el array de primera con el de segunda clase
	 */
	static void juntarOrdenadoSinUsarOtroArray() {
		System.arraycopy(segundaClase, hallarCero(), primeraClase, 0, primeraClase.length-1);
	}
	/**
	 * Método principal para que funcione la placación
	 */
	static void menu() {
		int numPrimera = pedirClase("Indique la cantidad de pasajeros de primera (Al menos 1 y No puede superar los 200)");
		int numSegunda = pedirClase("Indique la cantidad de pasajeros de segunda");
		int capacidadTotal = numPrimera+numSegunda;
		crear(numPrimera, capacidadTotal);
		rellenar();
		mostrar();
	}

	public static void main(String[] args) {
		menu();
	}
}