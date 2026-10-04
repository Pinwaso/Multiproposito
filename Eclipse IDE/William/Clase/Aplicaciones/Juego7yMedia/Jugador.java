package Clase.Aplicaciones.Juego7yMedia;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Jugador implements Comparable<Jugador>{
//////////////////////////////////////////////////////////////////
//////////////////////////// VARIABLES ///////////////////////////
//////////////////////////////////////////////////////////////////
	private double puntaje;
	private String nombre, estado;
	Stack<Double> Mazo;
//////////////////////////////////////////////////////////////////
////////////////////////// CONSTRUCTORES /////////////////////////
//////////////////////////////////////////////////////////////////
/**
 * Constructor para Jugador.
 * @param nombre se pasa un numero como identificativo del jugador.
 */
	public Jugador(String nombre) {
		this.setPuntaje(0);
		this.setNombre("Jugador: "+nombre);;
		this.setEstado("jugando");
	}
//////////////////////////////////////////////////////////////////
//////////////////////////// GETTERS /////////////////////////////
//////////////////////////////////////////////////////////////////
/**
 * Método para obtener el puntajo.
 * @return devuelve un double con el puntaje del jugador.
 */
	public double getPuntaje() {
		return puntaje;
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para obtener el nombre del jugador.
 * @return devuelve un String con el nombre del jugador.
 */
	public String getNombre() {
		return nombre;
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para obtener el estado del jugador.
 * @return Devuelve un String con el estado del jugador.
 */
	public String getEstado() {
		return estado;
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para establecer el mazo del jugador.
 * @return Devuelve un Stack de doubles con las cartas del jugador. 
 */
	public Stack<Double> getMazo() {
		return Mazo;
	}
//////////////////////////////////////////////////////////////////
///////////////////////////// SETTERS ////////////////////////////
//////////////////////////////////////////////////////////////////
/**
 * Método para establece el puntaje del jugador.
 * @param puntaje double con el puntaje del jugador.
 */
	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para establecer el nombre del jugador.
 * @param nombre int con la identificación del jugador.
 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para establecer el estado del jugador.
 * @param estado String del estado del jugador.
 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para establecer el mazo del jugador.
 * @param mazo Stack de doubles.
 */
	public void setMazo(Stack<Double> mazo) {
		Mazo = mazo;
	}
//////////////////////////////////////////////////////////////////
///////////////////////////// MÉTODOS ////////////////////////////
//////////////////////////////////////////////////////////////////
/**
 * Método para barajar aleatoriamente el mazo del jugador.
 */
	void barajar() {
		puntaje = 0;
		Mazo = new Stack<>();
		for (TiposCartas c : TiposCartas.values()) {
			Mazo.push(c.getValor());
		}
		Collections.shuffle(Mazo);
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para que juegue el jugador sacando una carta del mazo y sumarlo
 * en el puntaje según su valor.
 */
	void jugar() {
		puntaje += Mazo.pop(); 
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para mostrar en texto, los datos del jugador
 */
	@Override
	public String toString() {
		return "Jugador [puntaje=" + puntaje + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
//////////////////////////////////////////////////////////////////
/**
 * Método para comparar un jugador primero por su estado y luego
 * por su puntaje.
 * @param o el jugador. 
 * @return devuelve un int como comparacion.
 */
	@Override
	public int compareTo(Jugador o) {
		int comparacion = 0;
		if (this.getEstado().equals("plantado") && o.getEstado().equals("terminado")) {
			return 1;
		} else if (this.getEstado().equals("terminado") && o.getEstado().equals("plantado")) {
			return -1;
		}
		return (Double.compare(this.getPuntaje(), o.getPuntaje()));
	}
}