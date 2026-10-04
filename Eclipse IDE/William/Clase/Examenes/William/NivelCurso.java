package Clase.Examenes.William;

public enum NivelCurso {
	BASICO("Nivel inicial", 1.0),
	INTERMEDIO("Nivel medio", 1.15),
	AVANZADO("Nivel avanzado", 1.30),
	MASTER("Especializacion", 1.50);
	
	private final String descripcion;
	private final double factorPrecio;
	
	private NivelCurso(String descripcion, double factorPrecio) {
		this.descripcion = descripcion;
		this.factorPrecio = factorPrecio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getFactorPrecio() {
		return factorPrecio;
	}
	
	public double aplicarIncremento (double precioBase) {
		return precioBase*this.factorPrecio;
	}
}
