package Clase.Aplicaciones.GestionEmpleados;

public class EmpleadoFijo extends Empleados {
	private double salarioMensual;
	
	public EmpleadoFijo(String nombre, String apellidos, String dni, double salarioMensual) {
		super(nombre, apellidos, dni);
		this.setSalarioMensual(salarioMensual);
	}

	@Override
	public double calcularSalario() {
		return salarioMensual;
	}

	public double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
}