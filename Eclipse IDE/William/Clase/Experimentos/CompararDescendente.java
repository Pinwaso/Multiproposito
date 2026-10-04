package Clase.Experimentos;

import java.util.Comparator;

public class CompararDescendente implements Comparator<Persona>{
	
	@Override
	public int compare(Persona o1, Persona o2) {
	if (o1 instanceof Profesor && o2 instanceof Alumno) {
		return -1;
	}
	if (o1 instanceof Alumno && o2 instanceof Profesor) {
		return 1;
	}
	if (o1 instanceof Alumno && o2 instanceof Alumno) {
		int comparacion = ((Alumno)o2).getId() - ((Alumno)o1).getId();
		if (comparacion == 0) {
			comparacion = ((Alumno)o1).getNombre().compareTo(((Alumno)o2).getNombre());
		}
		return comparacion;
	}
	if (o1 instanceof Profesor && o2 instanceof Profesor) {
		int comparacion = ((Profesor)o2).getId() - ((Profesor)o1).getId();
		if (comparacion == 0) {
			comparacion = ((Profesor)o1).getNombre().compareTo(((Profesor)o2).getNombre());
		}
		return comparacion;
	}
		return 0;
	}
}