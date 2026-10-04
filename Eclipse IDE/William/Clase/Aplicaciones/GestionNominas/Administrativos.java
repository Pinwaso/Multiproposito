package Clase.Aplicaciones.GestionNominas;

public class Administrativos extends Gestion {

	public Administrativos(String dni, String nombre, double salarioBase, int antiguedad) {
		super(dni, nombre, salarioBase, antiguedad);
		this.setSalarioFinal(salarioBase + (20*antiguedad));
	}

	@Override
	public String toString() {
		return super.toString() + "Administrativos []";
	}
}
