package Clase.Aplicaciones.GestionEventosDeportivos;

public class Aplicacion {

	public static void main(String[] args) {
		Carrera maraton = new Carrera("maraton", "10-02-2009", "Logroño", 4.5);
		Equipo equipo = new Equipo("Santa Vaka");
		try {
			equipo.añadirJugador("pepe", "ceballos", 15);
		} catch (ParticipanteNoValidoException p) {
			System.out.println(p.getMessage());
		}
	}
}