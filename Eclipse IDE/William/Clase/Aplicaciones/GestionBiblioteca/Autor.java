package Clase.Aplicaciones.GestionBiblioteca;

public class Autor extends Persona {
	
	private String generoLiterario;
	
	public enum generoLiterario {
		Poético,
		Narativo,
		Dramatico,
		Didactico,
		Lirico;
	}
	
	public Autor(String nombre, String apellido, String fechaNacimiento, String generoLiterario){
		super(nombre, apellido, fechaNacimiento);
		this.setGeneroLiterario(generoLiterario);
	}

	public String getGeneroLiterario() {
		return generoLiterario;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Autor [generoLiterario=" + generoLiterario + "]";
	}

	public void setGeneroLiterario(String generoLiterario){
		try {
			this.generoLiterario = generoLiterario.valueOf(generoLiterario);
		} catch (Exception e) {
			
		}
	}
}