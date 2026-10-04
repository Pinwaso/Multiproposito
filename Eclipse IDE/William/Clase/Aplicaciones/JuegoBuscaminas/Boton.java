package Clase.Aplicaciones.JuegoBuscaminas;

import java.util.Objects;

import javax.swing.JButton;

public class Boton extends JButton{
	private boolean encontrado = false;
	private String tipo = "";
	
	public Boton() {
		super("?");
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEncontrado() {
		return encontrado;
	}

	public void setEncontrado(boolean encontrado) {
		this.encontrado = encontrado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boton other = (Boton) obj;
		return Objects.equals(tipo, other.tipo);
	}
}