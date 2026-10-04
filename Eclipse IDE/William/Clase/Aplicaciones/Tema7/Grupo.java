package Clase.Aplicaciones.Tema7;

import java.util.ArrayList;
import java.util.Iterator;

public class Grupo implements Iterable<Alumno> {
	private String nombre;
	private ArrayList<Alumno> alumnos;
	
		public Grupo(String nombre) {
			this.nombre = nombre;
			this.alumnos = new ArrayList<>();
		}

		public Iterator<Alumno> iterator() {			
			return alumnos.iterator();
		}
}