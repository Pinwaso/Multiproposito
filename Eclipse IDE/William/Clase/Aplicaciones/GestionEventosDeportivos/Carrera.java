package Clase.Aplicaciones.GestionEventosDeportivos;

public class Carrera extends EventoDeportivo {

	private double distancia;
	
	public Carrera(String nombre, String fecha, String lugar, double distancia) {
		super(nombre, fecha, lugar);
		this.setDistancia(distancia);
	}

	@Override
	public Participante obtenerGanador() {
		return null;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
}
