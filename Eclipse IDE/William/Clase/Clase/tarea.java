package Clase.Clase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tarea {
	static Scanner entrada = new Scanner (System.in);
//////////////////////////////////////////////////////////////////////
///////////////////////////// FUNCIONES //////////////////////////////
//////////////////////////////////////////////////////////////////////
/**
 * Método para pedir un numero int
 * @param mensaje es un mensaje informativo para el usuario
 * @param error mensaje en caso de error
 * @return devuelve un numero int
 */
	static int pedirInt(String mensaje, String error) {
		boolean correcto = false;
		int numero = 0;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextInt();
				entrada.nextLine();
				correcto = true;
			} catch (Exception ex) {
				System.out.println(error);
				entrada.nextLine();
			}
			return numero;
		} while (!correcto);
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método para pedir un numero int en un rango determinado
 * @param mensaje es un mensaje informativo para el usuario
 * @param error mensaje en caso de error
 * @param rang_min rango minimo para dar un numero int
 * @param rang_max rango maximo para dar un numero int
 * @return devuelve un numero int
 */
	static int pedirIntCondicional(String mensaje, String error, int rang_min, int rang_max) {
		boolean correcto = false;
		int numero = 0;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextInt();
				entrada.nextLine();
				if (numero >= rang_min && numero <= rang_max) {
					correcto = true;
				}
			} catch (Exception ex) {
				System.out.println(error);
				entrada.nextLine();
			}
			return numero;
		} while (!correcto);
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método para saber si un numero es primo o no
 */
	static void numerosPrimos() {
		int numero = pedirInt("Ingrese un numero", "Valor invalido");
		int raiz_cuadrada = (int)Math.sqrt(numero);
		boolean correcto = false;
		for (int i = 2; i <= raiz_cuadrada; i++) {
			if (numero % i == 0) {
				correcto = true;
			}
		}
		System.out.println(correcto == true ? "NO ES PRIMO" : "SI ES PRIMO");
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método principal para mostrar el menu de operaciones del array
 */
	static void array() {
		int[] numeros = rellenarArray();
		boolean correcto = false;
		do {
			menuArray();
			int opcion = pedirInt("Ingrese una opcion", "Valor invalido");
			switch(opcion) {
			case 0: correcto = true; break;
			case 1: busqueda(numeros); break;
			case 2: numeros = ordenar(numeros); break;
			case 3: numeros = buscarYreemplazar(numeros); break;
			case 4: numeros = eliminarNumero(numeros); break;
			case 5: mostrarArray(numeros); break;
			case 6: numeros = modificarLongitud(numeros); break;
			default: System.out.println("Valor invalido"); break;
			}
		} while (!correcto);
	}
///////////////////////////////////////////////////////////////////////
/**
 * Método para modificar la longitud del array
 * @param numeros se pasa el array de numeros que se quiere modiricar su longitud
 * @return devuelve el array de numeros con la longitud modificada
 */
	static int[] modificarLongitud(int[] numeros) {
		int longitud = pedirIntCondicional("Ingrese la longitud del nuevo array", "Valor invalido", 0, 100);
		numeros = Arrays.copyOf(numeros, longitud);
		return numeros;
	} 
///////////////////////////////////////////////////////////////////////
/**
 * Método para eliminar un valor del array de números
 * @param numeros se pasa el array de numeros que se quiere buscar
 * @return devuelve el array con el elemento eliminado
 */
	static int[] eliminarNumero(int[] numeros) {
		boolean correcto = true;
		do {
			int valor = pedirInt("Ingrese un numero a eliminar", "Valor invalido");
			if (buscar(numeros, valor) > -1) {
				numeros[valor] = 0;
			}
		} while (!correcto);
		return numeros;
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método para buscar y reemplazar un valor del array de números
 * @param numeros se pasa el array de numeros que se quiere buscar y reemplazar
 * @return devuelve el array de numeros modificado
 */
	static int[] buscarYreemplazar(int[] numeros) {
		boolean correcto = false;
		int indice = 0;
		do {
			indice = pedirInt("Ingrese un numero a buscar", "Valor invalido");
			if (buscar(numeros, indice) > -1) {
				correcto = true;
			} else {
				System.out.println("No esta ese numero en el array");
			}
		} while (!correcto);
		correcto = false;
		int nuevo_valor = 0;
		do {
			nuevo_valor = pedirInt("Ingrese el nuevo valor", "Valor invalido");
			if (buscar(numeros, nuevo_valor) == -1) {
				numeros[indice] = nuevo_valor;
				System.out.println("Valor cambiado exitosamente");
				correcto = true;
			} else {
				System.out.println("Ese valor ya existe");
			}
		} while (!correcto);
		return numeros;
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método para mostrar los valores del array
 * @param numeros se pasa el array de numeros que se quiere mostrar
 */
	static void mostrarArray(int[] numeros) {
		String mensaje = "";
		for (int a : numeros) {
			mensaje+=(", " + a);
		}
		System.out.println("Array de numeros:");
		System.out.println(mensaje.substring(2));
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método para ordenar un array de numeros
 * @param numeros se pasa el array de numeros que se quiere ordenar
 * @return devuelve el array de números ordenados
 */
	static int[] ordenar(int[] numeros) {
		boolean correcto = false;
		do {
			correcto = true;
			for (int i = 1; i < numeros.length; i++) {
				if (numeros[i-1] > numeros[i]) {
					int auxiliar = numeros[i];
					numeros[i] = numeros[i-1];
					numeros[i-1] = auxiliar;
					correcto = false;
				}
			}
		} while (!correcto);
		System.out.println("Array ordenado (eso creo)");
		return numeros;
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método para buscar un valor dentro de un array de numeros
 * @param numeros se pasa el array de numeros que se quiere buscar
 * @param numero se pasa el valor que se quiere buscar
 * @return devuelve el indice el valor si es que se encontro, caso contrario devuelve -1
 */
	static int buscar(int[] numeros, int numero) {
		int resultado = -1;
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] == numero) {
				resultado = i;
				break;
			}
		}
		return resultado;
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método para informar si un numero existe en un array de numeros
 * @param numeros se pasa el array de números que se quiere buscar
 */
	static void busqueda(int[] numeros) {
		int numero = pedirInt("Ingrese un numero", "Valor invalido");
		if (buscar(numeros, numero) == -1) {
			System.out.println("No existe el numero en el array");
		} else {
			System.out.println("El numero si existe en el array");
		}
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método para rellenar el array de numeros
 * @return devuelve un array de numeros con valores establecidos
 */
	static int[] rellenarArray() {
		ArrayList<Integer> auxiliar = new ArrayList<>();
		int[] numeros = new int[10];
		System.out.println("A continuacion, ingrese 10 numeros:");
		for (int i = 0; i < numeros.length;) {
			int numero = pedirIntCondicional("Ingrese el numero " + (i+1) + ". Dicho numero debe ser entre 100 y 200 ", "Valor invalido", 100, 200);
			if (auxiliar.contains(numero)) {
				System.out.println("Esta repetido");
			} else {
				numeros[i] = numero;
				auxiliar.add(numero);
				i++;
			}
		}
		return numeros;	
	}
//////////////////////////////////////////////////////////////////////
/////////////////////////////// MENUES ///////////////////////////////
//////////////////////////////////////////////////////////////////////
/**
 * Método para mostrar el menú principal
 */
	static void menuPrincipal() {
		System.out.println("""
				=======================
				| 1 - NUMEROS PRIMOS  |
				| 2 - ARRAYS          |
				| 0 - SALIR           |
				=======================
				""");
	}
//////////////////////////////////////////////////////////////////////
/**
 * Método para mostrar el menú del array 
 */
	static void menuArray() {
		System.out.println("""
				============================
				| 1 - BUSQUEDA             |
				| 2 - ORDENAR              |
				| 3 - BUSCAR Y REEMPLAZAR  |
				| 4 - ELIMINAR NUMERO      |
				| 5 - MOSTRAR ARRAY        |
				| 6 - MODIFICAR LONGITUD   |
				| 0 - SALIR                |
				============================
				""");
	}
//////////////////////////////////////////////////////////////////////
//////////////////////// APLICACION PRINCIPAL ////////////////////////
//////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		boolean correcto = false;
		do {
			menuPrincipal();
			int opcion = pedirInt("Ingrese una opcion", "Valor invalido");
			switch(opcion) {
			case 0: correcto = true; break;
			case 1: numerosPrimos(); break;
			case 2: array(); break;
			default: System.out.println("Valor incorrecto");
			}
		} while (!correcto);
	}
}