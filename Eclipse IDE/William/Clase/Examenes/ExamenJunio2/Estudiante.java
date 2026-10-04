package Clase.Examenes.ExamenJunio2;

import java.io.Serializable;

public class Estudiante implements Comparable<Estudiante>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre, apellido, dni;
	private double notaMedia;
	
	public Estudiante(int id, String nombre, String apellido, String dni, double notaMedia) {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		this.setNotaMedia(notaMedia);
	}
	
	@Override
	public int compareTo(Estudiante o) {
		int comparasAo = this.getApellido().compareTo(o.getApellido());
		if (comparasAo == 0) {
			comparasAo = this.getNombre().compareTo(o.getNombre());
		}
		if (this.getDni().compareTo(o.getDni()) == 0) {
			comparasAo = 0;
		}
		return comparasAo;
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	private void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	private void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
}