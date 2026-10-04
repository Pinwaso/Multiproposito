package Clase.Aplicaciones.Biblioteca;

import java.util.ArrayList;

public class recursoDigital extends recurso{
	
	ArrayList<soporte> contenido = new ArrayList<>();
	
	public recursoDigital (String titulo) {
		super(titulo);
	}
	
	public recursoDigital(int id, String titulo) {
		super(id, titulo);
	}
	
	private class soporte {
		private String nombre;
		private String tipo;
		private double tamano;
		private String unidad;
		
		public soporte(String nombre, String tipo, double tamano) {
			this.nombre = nombre;
			this.tipo = tipo;
			this.tamano = tamano;
		}
		
		public String getNombre() {
			return nombre;
		}
		public String getTipo() {
			return tipo;
		}
		public double getTamano() {
			return tamano;
		}
		@Override
		public String toString() {
			return "soporte [nombre=" + nombre + ", tipo=" + tipo + ", tamano=" + tamano + "]";
		}
	}
	
	public void imprimirInformacion() {
		System.out.println("===RECURSO DIGITAL===");
		System.out.println("ID: " + this.getId());
		System.out.println("Titulo: " + this.getTitulo());
		System.out.println("Contenidos:");
		for (soporte c : contenido) {
			System.out.println(c);
		}
		System.out.println("Tamano total: " + this.getTamanoTotal());
	}
	
	public void setSoporte (String nombre, String tipo, double tamano) {
		soporte Soporte = new soporte(nombre, tipo, tamano);
		contenido.add(Soporte);
	}
	
	public ArrayList<soporte> getSoporte() {
		return contenido;
	}
	
	public double getTamanoTotal() {
		if (contenido.isEmpty()) return 0d;
		double total = 0;
		for (int i = 0; i < contenido.size(); i++) {
			total += contenido.get(i).getTamano();
		}
		return total;
	}
}
