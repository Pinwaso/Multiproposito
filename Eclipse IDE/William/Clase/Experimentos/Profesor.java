package Clase.Experimentos;

public class Profesor extends Persona{
	
	public Profesor(int id, String nombre) {
		super(id, nombre);
	}

	@Override
	public int compareTo(Persona o) {
		int comparacion = 0;
		if (o instanceof Alumno) {
			return -1;
		} else if (o instanceof Profesor) {
			comparacion = this.getId() - ((Profesor)o).getId();
			if (comparacion == 0) {
				this.getNombre().compareTo(((Profesor)o).getNombre());
			}
		}
		return comparacion;
	}

	@Override
	public String toString() {
		return "Profesor id= " + getId() + " Nombre= " + getNombre();
	}
}
