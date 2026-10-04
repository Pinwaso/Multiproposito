package Clase.Aplicaciones.GestionEmpleados;

public abstract class Empleados {
	private String nombre, apellidos, dni;
	private double salario;
	
	public Empleados(String nombre, String apellidos, String dni) {
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setDni(dni);
	}

	@Override
	public String toString() {
		return "Empleados [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", salario=" + salario
				+ "]";
	}

	public abstract double calcularSalario();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}