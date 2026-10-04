package Clase.Aplicaciones.CuentaBancaria;

import java.util.Date;
import java.util.Objects;

public class cliente {
	private String nombre, apellido, localidad;
	
	public cliente (String nombre, String apellido, String localidad) {
		setNombre(nombre);
		setApellido(apellido);
		setLocalidad(localidad);
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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "cliente [nombre=" + nombre + ", apellido=" + apellido + ", localidad=" + localidad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, localidad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		cliente other = (cliente) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(localidad, other.localidad)
				&& Objects.equals(nombre, other.nombre);
	}
}
