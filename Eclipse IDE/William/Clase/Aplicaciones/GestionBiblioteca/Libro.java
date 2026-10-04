package Clase.Aplicaciones.GestionBiblioteca;

public class Libro {
	private String titulo, autor, editorial, fechaPublicacion, isbn;
	private double precio;
	
	public Libro(String titulo, String autor, String editorial, String fechaPublicacion, String isbn, double precio) {
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setEditorial(editorial);
		this.setFechaPublicacion(fechaPublicacion);
		this.setIsbn(isbn);
		this.setPrecio(precio);
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", fechaPublicacion="
				+ fechaPublicacion + ", isbn=" + isbn + ", precio=" + precio + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}