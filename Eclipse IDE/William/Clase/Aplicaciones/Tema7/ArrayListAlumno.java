package Clase.Aplicaciones.Tema7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListAlumno extends ArrayList<Alumno> {

	public ArrayListAlumno() {
		// TODO Auto-generated constructor stub
	}

	public ArrayListAlumno(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

	public ArrayListAlumno(Collection c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String pepe[]) {
		ArrayListAlumno alumnos = new ArrayListAlumno();
		
		alumnos.add(new Alumno("Pep", "1111A", 15));		
		System.out.println(alumnos); //Los muestra ordenados por edad → Jon, Pep, Tom
		alumnos.add(new Alumno("Jon", "3333A", 14));
		System.out.println(alumnos); //Los muestra ordenados por edad → Jon, Pep, Tom
		alumnos.add(new Alumno("Pep", "2222A", 15));
		System.out.println(alumnos); //Los muestra ordenados por edad → Jon, Pep, Tom

		
		//Collections.sort(alumnos); //ordenamos en base al método compareTo de la clase Alumno
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
	
	private int compareAlumnos(Alumno origen,Alumno destino) {	
			return origen.getNia().compareTo(destino.getNia());
		}
		
	
	public boolean add(Alumno e) {
		int margenInferior=0;
		int margenSuperior= this.size();
		int posicion= ((margenSuperior - margenInferior)/2)+margenInferior;
		
		
		int indice;
		for (indice=0;indice<this.size();indice++) {
			if (this.compareAlumnos(this.get(indice),e)>=0) {
				break;
			}				
		}								
		this.add(indice, e);
		return (this.get(indice).equals(e));
	}
	

}
