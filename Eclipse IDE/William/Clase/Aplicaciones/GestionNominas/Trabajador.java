package Clase.Aplicaciones.GestionNominas;

public abstract class Trabajador {
	private String dni, nombre;
	private double salarioBase, salarioFinal;
	
	public Trabajador(String dni, String nombre, double salarioBase) {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setSalarioBase(salarioBase);
	}

	@Override
	public String toString() {
		return "Trabajador [dni=" + dni + ", nombre=" + nombre + ", salarioBase=" + salarioBase + "]";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getSalarioFinal() {
		return salarioFinal;
	}

	public void setSalarioFinal(double salarioFinal) {
		this.salarioFinal = salarioFinal;
	}
}