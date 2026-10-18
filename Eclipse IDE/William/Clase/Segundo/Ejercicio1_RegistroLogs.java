package Clase.Segundo;

import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Logs")
@JsonPropertyOrder({"tiempo", "nivel", "mensaje"})

public class Ejercicio1_RegistroLogs {

	private String tiempo;
	
	private String nivel;
	
	private String mensaje;
	
	public Ejercicio1_RegistroLogs(String tiempo, String nivel, String mensaje) {
		this.tiempo = tiempo;
		this.nivel = nivel;
		this.mensaje = mensaje;
	}
	
	public Ejercicio1_RegistroLogs() {
		
	}
	
	public String getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}