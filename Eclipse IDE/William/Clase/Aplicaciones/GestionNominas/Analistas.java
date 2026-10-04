package Clase.Aplicaciones.GestionNominas;

public class Analistas extends Informaticos {

	public Analistas(String dni, String nombre, double salarioBase, String titulacion) {
		super(dni, nombre, salarioBase, titulacion);
		this.setSalarioFinal(salarioBase + (salarioBase*0.30));
	}

	@Override
	public String toString() {
		return super.toString() + "Analistas []";
	}
}