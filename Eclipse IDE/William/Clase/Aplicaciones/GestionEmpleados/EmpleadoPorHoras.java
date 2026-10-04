package Clase.Aplicaciones.GestionEmpleados;

public class EmpleadoPorHoras extends Empleados {

	private int horasTrabajadas;
	private double tarifaPorHora;
	
	public EmpleadoPorHoras(String nombre, String apellidos, String dni, int horasTrabajadas, double tarifaPorHora) {
		super(nombre, apellidos, dni);
		this.setHorasTrabajadas(horasTrabajadas);
		this.setTarifaPorHora(tarifaPorHora);
		this.setSalario(calcularSalario());
	}

	@Override
	public double calcularSalario() {
		return horasTrabajadas*tarifaPorHora;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public double getTarifaPorHora() {
		return tarifaPorHora;
	}

	public void setTarifaPorHora(double tarifaPorHora) {
		this.tarifaPorHora = tarifaPorHora;
	}
	
}
