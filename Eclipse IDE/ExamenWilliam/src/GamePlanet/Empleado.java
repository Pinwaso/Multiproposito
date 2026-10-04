package GamePlanet;

import java.io.Serializable;

/**
 * Clase Empleado que hereda de Persona
 * @version 1.0
 * @author William Andrés
 */
public class Empleado extends Persona implements Serializable{
	/**
	 * Identificación único de versión para la serialización de esta clase.
	 */
	private static final long serialVersionUID = 3560353336514154959L;
	/**
	 * sueldo del empleado como double
	 */
	private double sueldo;
	/**
	 * departamento del empleado como String
	 */
	private String departamento;

	public Empleado(String nombre, int edad, double sueldo, String departamento) {
		super(nombre, edad);
		this.setSueldo(sueldo);
		this.setDepartamento(departamento);
	}

	/**
	 * Método para obtener el sueldo
	 * @return devuelve el sueldo
	 */
	public double getSueldo() {
		return sueldo;
	}
	
	/**
	 * Método para establecer el sueldo
	 * @param sueldo
	 */
	private void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * Método para obtener el departamento
	 * @return devuelve el departamento como String
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * Método para establecer el departamento
	 * @param departamento se le pasa el departamento como String
	 */
	private void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * Método para obtener todos los datos devolviendo un String con todos los atributos
	 */
	@Override
	public String mostrarDatos() {
		return "Empleado Nombre: " + getNombre() + " edad: " + getEdad() + 
				" sueldo: " + getSueldo() + " departamento: " + getDepartamento();
	}
}