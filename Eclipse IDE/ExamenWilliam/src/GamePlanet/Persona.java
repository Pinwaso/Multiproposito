package GamePlanet;
/**
 * Clase Abstracta Persona, de ella heredan Cliente y Empleado
 * @version 1.0
 * @author William Andrés
 */
public abstract class Persona {
	/**
	 * nombre de la persona como String
	 */
	private String nombre;
	/**
	 * edad de la persona como int
	 */
	private int edad;
	
	/**
	 * Constructor de Persona
	 * @param nombre se le pasa el nombre como String
	 * @param edad se le pasa la edad como int
	 */
	public Persona(String nombre, int edad) {
		this.setNombre(nombre);
		this.setEdad(edad);
	}

	/**
	 * Método para obtener el nombre
	 * @return devuelve el nombre como String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para establecer el nombre
	 * @param nombre se le pasa el nombre como String
	 */
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método para obtener la edad
	 * @return devuelve la edad como int
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Método para establecer la edad
	 * @param edad se le pasa la edad como int
	 */
	protected void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Método abstracto para mostrar los datos
	 * @return Devuelve un String con todos los datos
	 */
	public abstract String mostrarDatos();
}