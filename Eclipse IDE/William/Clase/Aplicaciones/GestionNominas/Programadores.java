package Clase.Aplicaciones.GestionNominas;

public class Programadores extends Informaticos {

	public Programadores(String dni, String nombre, double salarioBase, String titulacion) {
		super(dni, nombre, salarioBase, titulacion);
		this.setSalarioFinal(salarioBase + (salarioBase*0.15));
	}
	
	@Override
	public String toString() {
		return super.toString() + "Programadores []";
	}
}