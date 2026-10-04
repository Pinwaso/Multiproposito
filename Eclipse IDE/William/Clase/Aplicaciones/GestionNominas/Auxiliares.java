package Clase.Aplicaciones.GestionNominas;

public class Auxiliares extends Gestion {

	public Auxiliares(String dni, String nombre, double salarioBase, int antiguedad) {
		super(dni, nombre, salarioBase, antiguedad);
		this.setSalarioFinal(salarioBase + 100);
	}

	@Override
	public String toString() {
		return super.toString() + "Auxiliares []";
	}
}
