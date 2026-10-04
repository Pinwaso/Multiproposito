package Clase.Experimentos;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class experimento {
	static Scanner entrada = new Scanner(System.in);
	TreeMap<Integer, HashSet<Alumno>> lista = new TreeMap<>();
	
	public void añadir() {
		System.out.println("ingrese id");
		int id = entrada.nextInt();
		entrada.nextLine();
		System.out.println("ingrese nombre");
		String nombre = entrada.nextLine();
		int clave = id%10000;
		HashSet<Alumno> alumnos = lista.getOrDefault(clave, null);
		if (alumnos == null) {
			alumnos = new HashSet<Alumno>();
			alumnos.add(new Alumno(id, nombre));
			lista.put(clave, alumnos);
		} else {
			alumnos.add(new Alumno(id, nombre));
		}	
	}
	
	public void eliminar() {
		System.out.println("ingrese el id");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		int clave = id%10000;
		if (lista.containsKey(clave)) {
			for (Alumno alumno : lista.get(clave)) {
				if (alumno.getId() == id) {
					lista.get(clave).remove(alumno);
					break;
				}
			}
		}
	}
	
	public void mostrar() {
		System.out.println("Cantidad de elementos: " + lista.size());
		for (Map.Entry<Integer, HashSet<Alumno>> alumnos : lista.entrySet()) {
			for (Alumno alumno : alumnos.getValue()) {
				System.out.println(alumno);
			}
		}
	}
	
	public void aplicacion() {
		boolean correcto = false;
		do {
			System.out.println("""
					1 añadir
					2 eliminar
					3 mostrar
					4 salir
					""");
			int opcion = entrada.nextInt();
			entrada.nextLine();
			switch(opcion) {
				case 1:
					añadir();
					break;
				case 2:
					eliminar();
					break;
				case 3:
					mostrar();
					break;
				case 4:
					correcto = true;
					break;
				default:
					System.out.println("valor invalido");
					break;
			}
		} while (!correcto);	
	}
	
	public static void main(String[] args) {
		/*Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
		System.out.println("s1 antes union: " + s1);
		s1.addAll(s2);
		System.out.println("s1 despues union: " + s1);*/
		experimento a = new experimento();
		a.aplicacion();
	}
}