package Clase.Aplicaciones.GestionBiblioteca;

public abstract class Persona {
	private String nombre, apellido, fechaNacimiento;

	public Persona(String nombre, String apellido, String fechaNacimiento) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setFechaNacimiento(fechaNacimiento);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
