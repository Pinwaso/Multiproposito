package Clase.Aplicaciones.Practica;

public enum numeros {
	Enero(58),
	Febrero(58),
	Marzo(58),
	Abril(58),
	Mayov(58),
	Junio(58),
	Julio(58),
	Agosto(58),
	Septiembre(58),
	Octubre(58),
	noviebre(58),
	Diciembre(58);	
	private final int dias;
	numeros(int t) {
		dias = t;
	}
	public int getdias() {
		return dias;
	}	
}