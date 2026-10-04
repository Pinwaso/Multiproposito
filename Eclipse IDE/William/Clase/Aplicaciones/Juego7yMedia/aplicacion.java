package Clase.Aplicaciones.Juego7yMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class aplicacion {
	static Scanner entrada = new Scanner (System.in);
	static Stack<Double> mazoPrincipal = new Stack<>();
	static int[] auxiliar;
	static double[] mazoAuxiliar;
	static List<Jugador> jugadores = new ArrayList<>();
//////////////////////////////////////////////////////////////////
///////////////////////////// MÉTODOS ////////////////////////////
//////////////////////////////////////////////////////////////////
/**
 * Método para pedir una cadena String
 * @param mensaje mensaje para mostrar como texto
 * @return devuelve una cadena String sin espacios.
 */
	static String pedirString(String mensaje) {
		System.out.println(mensaje);
		return entrada.nextLine().trim();
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para pedir un número int.
 * @param mensaje String para mostrar mensaje.
 * @return devuelve un numero int positivo.
 */
	static int pedirInt(String mensaje) {
		boolean correcto = false;
		int numero = 0;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextInt();
				entrada.nextLine();
				if (numero > 0) {
					correcto = true;
				} else {
					System.out.println("El número debe ser positivo");
				}
			} catch (Exception ex) {
				System.out.println("Valor inválido");
				entrada.nextLine();
			}
		} while (!correcto);
		return numero;
	}
/**
 * Método para crear una cantidad de jugadores especificado previamente.
 * @param cantidad nuevo de jugadores que se van a crear.
 */
	static void crearJugadores(int cantidad) {
		for (int i = 1; i <= cantidad; i++) {
			Jugador auxiliar = new Jugador(pedirString("Ingrese el nombre del jugador " + i));
			jugadores.add(auxiliar);
		}
	}
//////////////////////////////////////////////////////////////////

	static int Random() {
		return (int) (Math.random() * (39 + 1));
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para repartir cartas a jugadores
 */
	static void repartirCartas() {
		for (Jugador jugador : jugadores) {
			Stack<Double> mazoAuxiliar = new Stack<>();
			for (int i = 0; i < 10; i++) {
				if (mazoPrincipal.isEmpty()) {
					barajar();
				}
				mazoAuxiliar.push(mazoPrincipal.pop());
			}
			jugador.setMazo(mazoAuxiliar);
		}
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para poder barajar el mazo de un jugador
 * @param jugador se pasa un jugador para poder barajar su mazo
 */
	static void barajar() {
		mazoAuxiliar = new double[40];
		auxiliar = new int[40];
		for (int i = 0; i < 4; i++) {
			for (TiposCartas carta : TiposCartas.values()) {
				boolean correcto = false;
				do {
					int aleatorio = Random();
					if (auxiliar[aleatorio] == 0) {
						auxiliar[aleatorio] = 1;
						mazoAuxiliar[aleatorio] = carta.getValor();
						correcto = true;
					}
				} while (!correcto);
			}
		}
		for (int i = 0; i < mazoAuxiliar.length; i++) {
			mazoPrincipal.push(mazoAuxiliar[i]);
		} 
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para que juegue un solo jugador especificado
 * @param jugador jugar que jugará.
 */
	static void jugarJugador(Jugador jugador) {
		boolean correcto = true;
		do {
			System.out.println(jugador.getNombre());
			System.out.println("Puntaje: " + jugador.getPuntaje());
			System.out.println("Jugar? (true) o plantar? (false)");
			boolean decision = entrada.nextBoolean();
			entrada.nextLine();
			if (decision) {
				jugador.jugar();
				if (jugador.getPuntaje() > 7.5) {
					System.out.println("Perdiste con " + jugador.getPuntaje());
					jugador.setEstado("terminado");
					correcto = false;
				}
			} else {
				jugador.setEstado("plantado");
				correcto = false;
			}
		} while (correcto);
	}
//////////////////////////////////////////////////////////////////
/**
 * Método principal para que todos los jugadores puedan jugar
 */
	static void juego() {
		int cantidad = pedirInt("Indique el numero de jugadores");
		crearJugadores(cantidad);
		repartirCartas();
		for (Jugador jugador : jugadores) {
			jugarJugador(jugador);
		}
		verPuntaje();
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para ver el puntaje final de todos los jugadores.
 */
	static void verPuntaje() {
		Collections.sort(jugadores);
		for (Jugador jugador : jugadores) {
			System.out.println(jugador);
		}
		System.out.println("El ganador es: " + jugadores.get(jugadores.size()-1).toString());
	}
//////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		juego();
		ArrayPersonalizado<Jugador> Personalizado = new ArrayPersonalizado<>();
	}
}