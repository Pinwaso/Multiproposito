package Clase.Aplicaciones.Juego7yMedia;

public enum TiposCartas {
	As(1),
	Dos(2),
	Tres(3),
	Cuatro(4),
	Cinco(5),
	Seis(6),
	Siete(7),
	Caballo(0.5),
	Sota(0.5),
	Rey(0.5);
	private final double valor;
	private TiposCartas(double d) {
		this.valor = d;
	}
	public double getValor() {
		return valor;
	}
}