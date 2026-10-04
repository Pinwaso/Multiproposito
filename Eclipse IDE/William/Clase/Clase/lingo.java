package Clase.Clase;

import java.util.ArrayList;
import java.util.Scanner;

public class lingo {
	static Scanner entrada = new Scanner (System.in);
	static final String VERDE = "\u001B[92m";
	static final String AMARILLO = "\u001B[33m";
	static final String RESET = "\u001B[0m";
	static ArrayList<Character> letras;
	static char[][] respuestas;
	static char[][] palabras = {{'L','I','N','G','O'}, 
								{'P','E','R','R','O'}, 
								{'C','A','S','A','S'},
								{'M','A','N','O','S'},
								{'B','E','B','E','S'},
								{'R','E','M','A','R'},
								{'A','G','U','A','S'},
								{'C','I','N','C','O'},
								{'B','I','N','G','O'},
								{'R','U','B','E','N'},
								{'J','O','R','G','E'},
								{'D','I','S','C','O'},
								{'C','I','S','C','O'},
								{'P','I','S','C','O'},
								{'G','A','T','O','S'},
								{'P','A','T','O','S'},
								{'G','A','T','A','S'},
								{'R','A','T','O','N'},
								{'R','A','T','A','S'},
								{'J','O','K','E','R'},
								{'P','O','K','E','R'},
								{'M','A','T','E','O'},
								{'M','O','R','G','E'},
								{'B','O','L','S','A'},
								{'B','O','L','S','O'},
								{'P','O','L','L','O'}
							   };
/////////////////////////////////////////////////////////////
///////////////////////// MÉTODOS ///////////////////////////	
/////////////////////////////////////////////////////////////
/**
 * Método principal para la aplicacion
 */
	static void jugar() {
		respuestas = new char[6][5];
		String palabra = seleccionarPalabraAleatoria();
		for (int i = 0; i < palabra.length(); i++) {
			respuestas[0][i] = palabra.charAt(i);
		}
		rellenarLetras();
		for (int i = 1; i < respuestas.length; i++) {
			String palabraUsuario = introducirPalabraUsuario().toUpperCase();
			for (int a = 0; a < palabras[0].length; a++) {
				respuestas[i][a] = palabraUsuario.charAt(a);
			}
			if (mostrarResultado(palabraUsuario)) {
				System.out.println("Ganaste");
				break;
			}
			if (i == respuestas.length-1) {
				System.out.println("Perdiste");
			}
		}
	}
/////////////////////////////////////////////////////////////
/**
 * Método para mostrar el resultado actual del juegp
 * @param palabraUsuario se pasa la palabra ingresada para analizarla
 */
	static boolean mostrarResultado(String palabraUsuario) {
		String mensaje = "";
		int contador = 0;
		for (int i = 0; i < 5; i++) {
			if (palabraUsuario.charAt(i) == respuestas[0][i]) {
				mensaje += (" " + VERDE + palabraUsuario.charAt(i) + RESET);
				contador=contador+1;
			} else if (letras.contains(palabraUsuario.charAt(i))) {
				mensaje += (" " + AMARILLO + palabraUsuario.charAt(i) + RESET);
			} else {
				mensaje += (" " + palabraUsuario.charAt(i));
			}
		}
		System.out.println(mensaje.substring(1));
		if (contador == 5) {
			return true;
		} else {
			return false;
		}
	}
/////////////////////////////////////////////////////////////
/**
 * Método para rellenar una lista de letras que contiene la palabra
 */
	static void rellenarLetras () {
		letras = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			if (!letras.contains(respuestas[0][i])) {
				letras.add(respuestas[0][i]);
			}
		}
	}
/////////////////////////////////////////////////////////////
/**
 * Método para seleccionar una palabra a partir del array palabras
 * @return devuelve el String seleccionado del array palabras
 */
	static String seleccionarPalabra() {
		menu();
		int opcion = pedirIntCondicional("Seleccione una de las palabras", "Valor invalido", 0, palabras.length-1);
		String palabra = "";
		for (int i = 0; i < palabras[0].length; i++) {
			palabra += palabras[opcion][i];
		}
		return palabra;
	}
/////////////////////////////////////////////////////////////
/**
* Método para seleccionar una palabra a partir del array palabras de manera aleatoria
* @return devuelve el String seleccionado del array palabras
*/
	static String seleccionarPalabraAleatoria() {
		String palabra = "";
		int indiceAleatorio = random(palabras[0].length-1);
		for (int i = 0; i < palabras[0].length; i++) {
			palabra += palabras[indiceAleatorio][i];
		}
		return palabra;
	}
/////////////////////////////////////////////////////////////
/**
 * Método para dar un número máximo 
 * @param maximo parámetro máximo del rango de números aleatorios
 * @return devuelve un número aleatorio
 */
	static int random(int maximo) {
		int numero = (int) ((Math.random() * maximo + 1));
		return numero;
	}
/**
 * Método para dar una palabra de 5 caracteres
 * @return devuelve un String de 5 caracteres
 */
	static String introducirPalabraUsuario() {
		String palabra = "";
		boolean correcto = false;
		do {
			System.out.println("Ingrese una palabra de 5 caracteres");
			palabra = entrada.nextLine().trim();
			if (palabra.length() == 5) {
				correcto = true;
			} else {
				System.out.println("Palabra invalida");
			}
		} while (!correcto);
		return palabra;
	}
/////////////////////////////////////////////////////////////
/**
 * Método para pedir un numero int
 * @param mensaje mensaje informativo
 * @param error mensaje de error
 * @return devuelve un numero int
 */
	static int pedirIntCondicional(String mensaje, String error, int min, int max) {
		boolean correcto = false;
		int numero = 0;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextInt();
				entrada.nextLine();
				if (numero >= min && numero <= max) {
					correcto = true;
				}
			} catch (Exception ex) {
				System.out.println(error);
				entrada.nextLine();
			}
		} while (!correcto);
		return numero;
	}
/////////////////////////////////////////////////////////////
////////////////////////// MENUES ///////////////////////////	
/////////////////////////////////////////////////////////////
/**
 * Método para mostrar menú de seleccion de palabras
 */
	static void menu () {
		for (int a = 0; a < palabras.length; a++) {
			System.out.print(a + " - ");
			for (int b = 0; b < palabras[a].length; b++) {
				System.out.print(palabras[a][b]);
			}
			System.out.println();
		}
	}
/////////////////////////////////////////////////////////////
////////////////// APLICACION PRINCIPAL /////////////////////	
/////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		jugar();
	}
}