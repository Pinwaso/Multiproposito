package Clase.Aplicaciones.GestionNominas;

public abstract class Gestion extends Trabajador {
	private int antiguedad;

	public Gestion(String dni, String nombre, double salarioBase, int antiguedad) {
		super(dni, nombre, salarioBase);
		this.setAntiguedad(antiguedad);
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return super.toString() + "Gestion [antiguedad=" + antiguedad + "]";
	}
	
}
