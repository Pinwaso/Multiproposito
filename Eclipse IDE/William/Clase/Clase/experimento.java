package Clase.Clase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class experimento {

	public static void main(String[] args) {
		/*Map<String, Double> notasDeAlumnos = new HashMap<>();
		// Añadimos las notas de los alumnos
		notasDeAlumnos.put("Tim", 9.7);
		notasDeAlumnos.put("Bob", 8.5);
		notasDeAlumnos.put("Jon", 7.8);
		notasDeAlumnos.put("Bob", 8.8);
		notasDeAlumnos.put("Bob", notasDeAlumnos.getOrDefault("Bob", 0.0) + 1); // Bob → 9.8
		notasDeAlumnos.put("Jon", notasDeAlumnos.getOrDefault("Kal", 5.0) + 1); // Jon → 6.0
		notasDeAlumnos.put("Kal", notasDeAlumnos.getOrDefault("Bob", 5.0)); // Kal → 9.8
		notasDeAlumnos.put("Kal", notasDeAlumnos.getOrDefault("Sam", 0.0)); // Kal → 0.0
		// Mostramos datos con entrySet()
		System.out.println("Notas alumnos:");
		for (Map.Entry<String, Double> pares : notasDeAlumnos.entrySet()) {
			System.out.println("La nota de " + pares.getKey() + " es " + pares.getValue());
		}
		// Mostramos nombres de los alumnos con keySet() y nota media
		System.out.println("Alumnos:" + notasDeAlumnos.keySet()); // Alumnos:[Bob, Kal, Jon, Tim]
		double sumaNotas = 0;
		for (Double nota : notasDeAlumnos.values())
			sumaNotas += nota;
		System.out.println("Nota media: " + sumaNotas / notasDeAlumnos.size()); // Nota media: 6.375
		
		String s = "Cadena de ejemplo!!\nHoy es miércoles día 29 de marzo de 2023\n\nFIN";
		// Utilizamos HashMap para almacenar las palabras y sus frecuencias
		Map<String, Integer> frecuenciaPalabras = new HashMap<>();
		// Convertimos a minúsculas y dividimos la cadena en palabras con split
		String[] palabras = s.toLowerCase().split("\\s+");
		// Recorremos el array de palabras
		for (String palabra : palabras) {
		 // Incrementamos la frecuencia de la palabra en el mapa
		 frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
		}
		// Imprimimos los resultados
		System.out.println("Frecuencia de palabras en la cadena de entrada:");
		for (Map.Entry<String, Integer> claveValor : frecuenciaPalabras.entrySet()) {
		 System.out.println(claveValor.getKey() + ": " + claveValor.getValue());
		}*/
		
		List<String> listNames = Arrays.asList("John", "Peter", "Tom", "Mary",
		"David", "Sam");
		List<Integer> listNumbers = Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8);
		//System.out.println(listNames);
		//System.out.println(listNumbers);
		
		List<String> listWords = new ArrayList<String>();
		listWords.add("casa");
		listWords.add("pepe");
		listWords.add("raton");
		listWords.add("hola");
		listWords.add("pereftarato de polietireno");
		// add elements to the list
		Object[] arrayWords = listWords.toArray();
		//Y el método toArray(T[] a) devuelve una matriz de tipo T,por ejemplo:
		
		String[] words = listWords.toArray(new String[0]);
		Integer[] numbers = listNumbers.toArray(new Integer[0]);
		
		System.out.println(words.toString());
		System.out.println(numbers.toString());
	}
}