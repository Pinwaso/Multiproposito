package Clase.Aplicaciones.Tema7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class cosas {
	/*
	 * 4 alumnos, sacar el alumno de la posicion 2 eliminar el alumno de la pos 1,
	 * insertar alumno de la posicion 1 sacar el ultimo alumno y se cambia por el
	 * primero
	 */
	// Método para añadir notas de los alumnos al map
	public static void agregarNota(Map<Alumno, ArrayList<Double>> notasDam, Alumno a, double nota) {
		ArrayList<Double> notas = notasDam.getOrDefault(a, new ArrayList<>());
		notas.add(nota);
		notasDam.put(a, notas);
	}

	public static void main(String[] args) {

		Map<Alumno, ArrayList<Double>> notasDam = new TreeMap<>();
		Alumno a1 = new Alumno("Pep", "111A", 20);
		Alumno a2 = new Alumno("Jon", "222A", 18);
		Alumno a3 = new Alumno("Sam", "333A", 21);
		Alumno a4 = new Alumno("Bil", "444A", 19);
		Alumno a5 = new Alumno("Kal", "111A", 22);
		agregarNota(notasDam, a1, 9.2); // Pep
		agregarNota(notasDam, a1, 7.5); // Pep
		agregarNota(notasDam, a2, 8.1); // Jon, Pep
		agregarNota(notasDam, a2, 9.0); // Jon, Pep
		agregarNota(notasDam, a3, 7.5); // Jon, Pep, Sam
		agregarNota(notasDam, a4, 8.2); // Jon, Bil, Pep, Sam
		agregarNota(notasDam, a5, 10.0); // se agrega un 10 a Pep
	}
}