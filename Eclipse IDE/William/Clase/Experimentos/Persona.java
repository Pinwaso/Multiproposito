package Clase.Experimentos;

public abstract class Persona implements Comparable<Persona>{
	private int id;
	private String nombre;
	
	public Persona(int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}	
}
