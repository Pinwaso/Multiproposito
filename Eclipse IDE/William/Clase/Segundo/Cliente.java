package Clase.Segundo;

import java.io.Serializable;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4950202933306738644L;

	private String nombre;
	
	private int edad;
	
	public Cliente(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}