package Clase.Experimentos;

import java.util.TreeSet;

public class Aplicacion {

	public void principal() {
		TreeSet<Persona> alumnos = new TreeSet<>(new CompararDescendente());
		System.out.println(alumnos.add(new Alumno(0, "Alvaro")));
		System.out.println(alumnos.add(new Alumno(3, "Teo")));
		System.out.println(alumnos.add(new Alumno(2, "Ruben")));
		System.out.println(alumnos.add(new Alumno(1, "Drazen")));
		System.out.println(alumnos.add(new Alumno(5, "Erika")));
		System.out.println(alumnos.add(new Alumno(0, "Alvaro")));
		System.out.println(alumnos.add(new Profesor(0, "Alvaro")));
		System.out.println(alumnos.add(new Profesor(3, "Alvarito")));
		System.out.println(alumnos.add(new Profesor(2, "Alvarinho")));
		System.out.println(alumnos.add(new Profesor(1, "Alvariño")));
		System.out.println(alumnos.add(new Profesor(5, "Arubaro")));
		System.out.println(alumnos.add(new Profesor(0, "Alvaro")));
		
		for (Object persona : alumnos) {
			System.out.println(persona);
		}
	}
	
	public static void main(String[] args) {
		Aplicacion app = new Aplicacion();
		app.principal();
	}
}