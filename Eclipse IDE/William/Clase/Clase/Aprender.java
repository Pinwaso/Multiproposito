package Clase.Clase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class Aprender {
	
	  static Scanner entrada;

	    public static boolean casoDePrueba() {
	        if (!entrada.hasNext()) {
	        	return false;
	        }
	        Stack<String> nombres = new Stack<>();
	        HashMap<String, Integer> alumnos = new HashMap<>();
	        int cantidad = entrada.nextInt();
	        for (int i = 0; i < cantidad ; i++) {
	        	String nombre = entrada.next().toUpperCase();
	        	int puntaje = entrada.nextInt();
	        	alumnos.put(nombre, alumnos.getOrDefault(nombre, 0) + puntaje);
	        }
	        int puntajeMayor = Integer.MIN_VALUE;
	        for (Entry<String, Integer> persona : alumnos.entrySet()) {
	        	String alumno = persona.getKey();
	        	int puntaje = persona.getValue();
	        	if (puntaje == puntajeMayor) {
	        		nombres.push(alumno);
	        	} else if (puntaje > puntajeMayor) {
	        		nombres.clear();
	        		puntajeMayor = puntaje;
	        		nombres.push(alumno);
	        	}
	        }
	        System.out.println(nombres.size());
	        String resultado = "";
	        do {
	        	resultado+= nombres.pop() + " "; 
	        } while (!nombres.isEmpty());
	        resultado+= puntajeMayor;
	        System.out.println(resultado);
	        return true;
	    } 

	    public static void main(String[] args) {
	        entrada = new Scanner(System.in);
	        while (casoDePrueba()) {
	        }
	    } 
}