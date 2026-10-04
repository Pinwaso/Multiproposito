package Clase.Aplicaciones.Biblioteca;

public class recursoLibro extends recurso{
	
	private String ISBN;
	private int paginas;
	private String tipo;
	
	public recursoLibro (String titulo, String ISBN, int paginas, String tipo) {
		super(titulo);
		this.ISBN = ISBN;
		this.paginas = paginas;
		this.tipo = tipo;
	}
	
	public recursoLibro (int id, String titulo, String ISBN, int paginas, String tipo) {
		super(id, titulo);
		this.ISBN = ISBN;
		this.paginas = paginas;
		this.tipo = tipo;
	}
	
	public void imprimirInformacion() {
		System.out.println("===LIBRO===");
		System.out.println("ID: " + this.getId());
		System.out.println("Titulo: " + this.getTitulo());
		System.out.println("ISBN: " + this.getISBN());
		System.out.println("Paginas: " + this.getPaginas());
		System.out.println("Tipo: " + this.getTipo());
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	};
}
