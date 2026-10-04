package Clase.Aplicaciones.GestionNominas;

public abstract class Informaticos extends Trabajador {

	private String titulacion;
	
	public Informaticos(String dni, String nombre, double salarioBase, String titulacion) {
		super(dni, nombre, salarioBase);
		this.setTitulacion(titulacion);
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	@Override
	public String toString() {
		return super.toString() + "Informaticos [titulacion=" + titulacion + "]";
	}	
}
