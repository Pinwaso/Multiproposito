package Clase.Examenes.ExamenJunio;

import java.time.LocalDate;

public class Auto extends Vehiculo implements Verificable{

	private String tipoCombustible, numeroRegistro;
	
	public Auto(String marca, String modelo, int anioFabricacion, LocalDate fechaIngreso, String tipoCombustible,
			String numeroRegistro) throws DocumentoInvalidoException {
		super(marca, modelo, anioFabricacion, fechaIngreso);
		if (verificarDocumento(numeroRegistro) == false) {
			throw new DocumentoInvalidoException("Documento no valido");
		}
		this.setTipoCombustible(tipoCombustible);
		this.setNumeroRegistro(numeroRegistro);
	}
	
	@Override
	public boolean verificarDocumento(String numeroDocumento) {
		return numeroDocumento.matches("AUT-[A-Z]{3}-[0-9]{2}");
	}
	
	@Override
	public String mostrarInformacion() {
		return super.getMarca() + " " + super.getModelo() + " " + super.getAnioFabricacion() +
		" " + super.getFechaIngreso() + " " + tipoCombustible + " " + numeroRegistro;
	}

	public String mostrarInformacion(boolean mostrarCosto) {
		String salida = super.getMarca() + " " + super.getModelo() + " " + super.getAnioFabricacion() +
				" " + super.getFechaIngreso() + " " + tipoCombustible + " " + numeroRegistro;
		if (mostrarCosto == true) {
			salida+=" " + mostrarInformacion(mostrarCosto);
		}
		return salida;
	}
	
	@Override
	public double calcularCostoMantenimiento() {
		double costo = 0d;
		switch (tipoCombustible) {
		case "Gasolina":
			costo = 1000;
			break;
		case "Electrico": 
			costo = 800;
			break;
		}
		return costo;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	private void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	private void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
}