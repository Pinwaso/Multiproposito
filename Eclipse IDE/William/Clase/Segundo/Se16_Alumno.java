package Clase.Segundo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "alumno") //Elemento raiz del XML
@JsonPropertyOrder({"id", "nombre", "notaMedia"}) //Orden explícito (útil para CSV)

public class Se16_Alumno {
	@JsonProperty("id_alumno") //Cambia el nombre de la clave/etiqueta
	@JacksonXmlProperty(isAttribute = true) //En XML 
	private int id;
	
	@JsonProperty("nombre_completo")
	private String nombre;
	
	private double notaMedia;
	
	//constructor vacío, obligatorio para frameworks de serialización
	public Se16_Alumno() {
	}
	
	public Se16_Alumno(int id, String nombre, double notaMedia) {
		this.id = id;
		this.nombre = nombre;
		this.notaMedia = notaMedia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
