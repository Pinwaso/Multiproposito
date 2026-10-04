package Clase.Examenes.ExamenJunio;

import java.time.LocalDate;

public abstract class Vehiculo {

	private String marca, modelo;
	private int anioFabricacion;
	private LocalDate fechaIngreso;
	
	public Vehiculo(String marca, String modelo, int anioFabricacion, LocalDate fechaIngreso) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setAnioFabricacion(anioFabricacion);
		this.setFechaIngreso(fechaIngreso);
	}
	
	public abstract String mostrarInformacion();
	
	public abstract double calcularCostoMantenimiento();
	
	public String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	private void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	private void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	private void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
}