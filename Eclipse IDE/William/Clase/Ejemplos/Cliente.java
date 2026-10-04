package Clase.Ejemplos;

import java.util.Date;

public class Cliente {
	private String nombre, apellidos;
	private String direccion, localidad;
	private Date fNacimiento;
	Cliente (String aNombre, String aApellidos, String aDireccion,
			String aLocalidad, Date aFNacimiento) {
		nombre = aNombre;
		apellidos = aApellidos;
		direccion = aDireccion;
		localidad = aLocalidad;
		fNacimiento = aFNacimiento;
	}
	String nombreCompleto () { return nombre + " " + apellidos; }
	String direccionCompleta () { return direccion + ", " + localidad;}
}
