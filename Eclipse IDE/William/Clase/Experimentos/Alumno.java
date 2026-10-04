package Clase.Experimentos;

public class Alumno extends Persona {

	public Alumno(int id, String nombre) {
		super(id, nombre);
	}

	@Override
	public int compareTo(Persona o) {
		int comparacion = 0;
		if (o instanceof Profesor) {
			return 1;
		} else if (o instanceof Alumno) {
			comparacion = this.getId() - ((Alumno)o).getId();
			if (comparacion == 0) {
				this.getNombre().compareTo(((Alumno)o).getNombre());
			}
		}
		return comparacion;
	}

	@Override
	public String toString() {
		return "Alumno id= " + getId() + " Nombre= " + getNombre();
	}
}