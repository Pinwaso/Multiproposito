package Clase.Examenes.ExamenJunio;

import java.time.LocalDate;

public class Camion extends Vehiculo implements Verificable{

	private double capacidadCarga;
	private String numeroRegistro;
	
	public Camion(String marca, String modelo, int anioFabricacion, LocalDate fechaIngreso, double capacidadCarga,
			String numeroRegistro) throws DocumentoInvalidoException {
		super(marca, modelo, anioFabricacion, fechaIngreso);
		if (verificarDocumento(numeroRegistro) == false) {
			throw new DocumentoInvalidoException("Documento no valido");
		}
		this.setCapacidadCarga(capacidadCarga);
		this.setNumeroRegistro(numeroRegistro);
	}

	@Override
	public String mostrarInformacion() {
		return super.getMarca() + " " + super.getModelo() + " " + super.getAnioFabricacion() +
		" " + super.getFechaIngreso() + " " + capacidadCarga + " " + numeroRegistro;
	}

	@Override
	public double calcularCostoMantenimiento() {
		return 1000 + (100 * this.capacidadCarga);
	}
	
	@Override
	public boolean verificarDocumento(String numeroDocumento) {
		return numeroDocumento.matches("CAM-[0-9]{4}");
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}

	private void setCapacidadCarga(double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	private void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
}