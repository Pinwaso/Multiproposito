package Clase.Aplicaciones.GestionEventosDeportivos;

public class Participante {
	
	private String nombre, apellido;
	private int edad;
	
	public Participante(String nombre, String apellido, int edad) throws ParticipanteNoValidoException{ 
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEdad(edad);
	}
	
	@Override
	public String toString() {
		return "Participante [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) throws ParticipanteNoValidoException {
		if (nombre != null) {
			this.nombre = nombre;
		} else {
			throw new ParticipanteNoValidoException("El nombre no puede ser nulo");
		}
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) throws ParticipanteNoValidoException {
		if (apellido != null) {
			this.apellido = apellido;
		} else {
			throw new ParticipanteNoValidoException("El apellido no puede ser nulo");
		}
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) throws ParticipanteNoValidoException {
		if (edad == 0) {
			throw new ParticipanteNoValidoException("La edad no puede ser nula");
		} else if (edad < 14) {
			throw new ParticipanteNoValidoException("El participante debe tener mas de 13 años");
		} else {
			this.edad = edad;
		}
	}
}