package Clase.Aplicaciones.GestionEventosDeportivos;

import java.util.ArrayList;

public class Equipo {
	
	private String nombre;
	private int puntos;
	private ArrayList<Participante> participantes;
	
	public Equipo(String nombre) {
		this.setNombre(nombre);
		this.setPuntos(0);
		this.setParticipantes(new ArrayList<>());
	}

	public void añadirJugador(String nombre, String apellido, int edad) throws ParticipanteNoValidoException {
		participantes.add(new Participante(nombre, apellido, edad));
		System.out.println("Participante agregado exitosamente");
	}
	
	public void eliminarJugador(String nombre, String apellido) throws JugadorNoEncontradoException {
		boolean encontrado = false;
		for (int i = 0; i < participantes.size(); i++) {
			if (participantes.get(i).getNombre().equals(nombre) && participantes.get(i).getApellido().equals(apellido)) {
				participantes.remove(i);
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			System.out.println("Participante eliminado exitosamente");
		} else {
			throw new JugadorNoEncontradoException("Jugador no encontrado");
		}
	}
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", puntos=" + puntos + ", participantes=" + participantes + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
}
