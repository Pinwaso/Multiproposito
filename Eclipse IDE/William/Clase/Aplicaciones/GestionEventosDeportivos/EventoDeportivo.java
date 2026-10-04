package Clase.Aplicaciones.GestionEventosDeportivos;

import java.util.ArrayList;

public abstract class EventoDeportivo implements Ganador{
	
	private String nombre, fecha, lugar;
	private ArrayList<Participante> participantes = new ArrayList<>();
	
	public EventoDeportivo(String nombre, String fecha, String lugar) {
		this.setNombre(nombre);
		this.setFecha(fecha);
		this.setLugar(lugar);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
}