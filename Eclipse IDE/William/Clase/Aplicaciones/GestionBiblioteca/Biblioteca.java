package Clase.Aplicaciones.GestionBiblioteca;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Libro> libros = new ArrayList<>();

	public Biblioteca() {
	}
	
	public void agregarLibro(String titulo, String autor, String editorial, String fechaPublicacion, String isbn, double precio) {
		libros.add(new Libro(titulo, autor, editorial, fechaPublicacion, isbn, precio));
		System.out.println("Libro agregado con exito");
	}
	
	public void eliminarLibro(String isbn) throws LibroNoEncontradoException{
		boolean encontrado = false;
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getIsbn().equals(isbn)) {
				libros.remove(i);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			throw new LibroNoEncontradoException("Libro no encontrado");
		} else {
			System.out.println("Libro eliminado");
		}
	}
}
