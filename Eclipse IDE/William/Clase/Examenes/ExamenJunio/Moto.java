package Clase.Examenes.ExamenJunio;

import java.time.LocalDate;

public class Moto extends Vehiculo implements Verificable{

	private int cilindrada;
	private String numeroRegistro;
	
	public Moto(String marca, String modelo, int anioFabricacion, LocalDate fechaIngreso, int cilindrada,
			String numeroRegistro) throws DocumentoInvalidoException {
		super(marca, modelo, anioFabricacion, fechaIngreso);
		if (verificarDocumento(numeroRegistro) == false) {
			throw new DocumentoInvalidoException("Documento no valido");
		}
		this.setCilindrada(cilindrada);
		this.setNumeroRegistro(numeroRegistro);
	}

	@Override
	public String mostrarInformacion() {
		return super.getMarca() + " " + super.getModelo() + " " + super.getAnioFabricacion() +
		" " + super.getFechaIngreso() + " " + cilindrada + " " + numeroRegistro;
	}

	@Override
	public double calcularCostoMantenimiento() {
		return 500 + (this.cilindrada / 10);
	}
	
	@Override
	public boolean verificarDocumento(String numeroDocumento) {
		return numeroDocumento.matches("MOT-[0-9]{6}");
	}
	
	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	private void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
}