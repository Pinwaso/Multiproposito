package Clase.Clase;

public class empleados {
	private String nombreCompleto;
	private int permanencia;
	private float salario;

	public empleados() {
		this.nombreCompleto = "";
		this.permanencia = 0;
		this.salario = 12000;
	}
	public empleados(String nombreCompleto, int permanencia, float salario) {
		setNombreCompleto(nombreCompleto);
		setPermanencia(permanencia);
		setSalario(salario);
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public int getPermanencia() {
		return permanencia;
	}
	public void setPermanencia(int permanencia) {
		if (permanencia > 0) {
			this.permanencia = permanencia;
		} else {
			this.permanencia = 0;
		}
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		if (salario > 0) {
		this.salario = salario;
		} else {
			this.salario=0;
		}
	}
	public String getClasificacion() {
		if (this.getPermanencia() <= 3) {
			return "Principiante";
		} else if (this.getPermanencia() > 3 && this.getPermanencia() < 18) {
			return "Intermedio";
		} else if (this.getPermanencia() >= 18) {
			return "Senior";
		}
		return "";
	}
	public void getInformacionEmpleado() {
		System.out.println("Nombre completo: " + this.getNombreCompleto());
		System.out.println("Permanencia: " + this.getPermanencia());
		System.out.println("Salario: " + this.getSalario());
		System.out.println("Clasificacion: " + this.getClasificacion());
	}
	public void setAumentarSalario(int porcentaje) {
		if (porcentaje > 0) {
			this.setSalario(this.getSalario() + (this.getSalario()*porcentaje/100));
		} 
	}
	public void setDisminuirSalario(int porcentaje) {
		if (porcentaje > 0) {
			this.setSalario(this.getSalario() - (this.getSalario()*porcentaje/100));
		} 
	}
	@Override
	public String toString() {
		return "empleados [nombreCompleto=" + nombreCompleto + ", permanencia=" + permanencia + ", salario=" + salario
				+ "]";
	}
}