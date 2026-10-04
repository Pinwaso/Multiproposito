package Clase.Aplicaciones.Tema7;

import java.util.ArrayList;
import java.util.Collections;

public class Alumno1 implements PersonaCentroEducativo {
    String nombre;
	
    public Alumno1(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public static void main(String arg[]) {		
		ArrayList<PersonaCentroEducativo> instituto = new ArrayList<>();
		instituto.add(new Alumno1("Pep"));
		instituto.add(new Alumno1("Tom"));
		instituto.add(new Alumno1("Jon"));
		instituto.add(new Alumno1("Tim"));
		instituto.add(new Alumno1("Ada"));
		instituto.add(new Docente1("Kal"));
		instituto.add(new Docente1("Ana"));
		instituto.add(new Docente1("Sam"));
		instituto.add(new Docente1("Pol"));
		instituto.add(new Docente1("Ben"));
		System.out.println("Alumnos y docentes ordenados por nombre");
		Collections.sort(instituto, new NombreComparatorCentroEducativo());
		System.out.println(instituto);
	}

	@Override
	public String toString() {
		return "Alumno1 [nombre=" + nombre + "]";
	}

}
