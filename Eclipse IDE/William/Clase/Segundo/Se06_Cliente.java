package Clase.Segundo;

import java.io.*;

public class Se06_Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5962011454915100648L;
	
	private String nombre;
	private int edad;
	
	public Se06_Cliente() {
		this.nombre = null;
	}
	
	public Se06_Cliente(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
