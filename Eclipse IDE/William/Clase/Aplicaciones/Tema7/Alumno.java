package Clase.Aplicaciones.Tema7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Alumno implements Comparable<Alumno> {

	public Alumno(String nombre, String nia, int edad) {
		super();
		this.nombre = nombre;
		this.nia = nia;
		this.edad = edad;
	}

	private String nombre;
	private String nia;
	private int edad;
	//	constructores, getters y setters

	@Override
	public int compareTo(Alumno a) {
		int comparacion = Integer.compare(this.edad, a.edad);
		if (comparacion == 0) comparacion = this.nombre.compareTo(a.nombre);
		return comparacion;
	}

	/**
	 * @return the nombre
	 */
	protected String getNombre() {
		return nombre;
	}

	/**
	 * @return the nia
	 */
	protected String getNia() {
		return nia;
	}

	/**
	 * @return the edad
	 */
	protected int getEdad() {
		return edad;
	}

	/**
	 * @param nombre the nombre to set
	 */
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param nia the nia to set
	 */
	protected void setNia(String nia) {
		this.nia = nia;
	}

	/**
	 * @param edad the edad to set
	 */
	protected void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return  "|"+nombre + "," + nia + "," + edad+"|";
	}

	public static void main(String pepe[]) {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		alumnos.add(new Alumno("Pep", "1111A", 15));		
		alumnos.add(new Alumno("Jon", "3333A", 14));
		alumnos.add(new Alumno("Pep", "2222A", 15));
		Collections.sort(alumnos); //ordenamos en base al método compareTo de la clase Alumno
		System.out.println(alumnos); //Los muestra ordenados por edad → Jon, Pep, Tom		
		
		//Collections.sort(alumnos, new AlumnoPorNiaComparator());
		  Alumno.ordenarAlumnosPorNia(alumnos);
		System.out.println(alumnos);
	}


	public static void ordenarAlumnosPorNia(ArrayList<Alumno> alumnos) {
		alumnos.sort(new Comparator<Alumno>() {
			@Override
			public int compare(Alumno a1, Alumno a2) {
				return a1.getNia().compareTo(a2.getNia());
			}
		});
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nia, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alumno))
			return false;
		Alumno other = (Alumno) obj;
		return edad == other.edad && Objects.equals(nia, other.nia) && Objects.equals(nombre, other.nombre);
	}

}
class AlumnoPorNiaComparator implements Comparator<Alumno> {
	public int compare(Alumno a1, Alumno a2) {
		return a1.getNia().compareTo(a2.getNia());
	}
}
class AlumnoPorEdadComparator implements Comparator<Alumno> {
	public int compare(Alumno a1, Alumno a2) {
		int comparacion = Integer.compare(a1.getEdad(), a2.getEdad());
		if (comparacion == 0) comparacion = a1.getNombre().compareTo(a2.getNombre());
		return comparacion;
	}
}






