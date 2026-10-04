package Clase.Aplicaciones.EjemploBiblioteca;

//===============================
//LIBRO
//===============================
public class Libro extends Recurso {

 private String isbn;
 private int paginas;
 private TipoLibro tipoLibro;

 public Libro(String titulo, String isbn, int paginas, TipoLibro tipoLibro) {
     super(titulo);
     this.setIsbn(isbn);
     this.setPaginas(paginas);
     this.setTipoLibro(tipoLibro);
 }
 
 public Libro(int id, String titulo, String isbn, int paginas, TipoLibro tipoLibro) {
     super(id, titulo);
     this.setIsbn(isbn);
     this.setPaginas(paginas);
     this.setTipoLibro(tipoLibro);
 }
 

 @Override
 public void imprimirInformacion() {
     System.out.println("=== LIBRO ===");
     System.out.println("ID: " + this.getId());
     System.out.println("Título: " +this.getTitulo());
     System.out.println("ISBN: " + isbn);
     System.out.println("Páginas: " + paginas);
     System.out.println("Tipo: " + tipoLibro);
 }

 /**
 * @return the isbn
 */
 private String getIsbn() {
	return isbn;
 }

 /**
 * @return the paginas
 */
 private int getPaginas() {
	return paginas;
 }

 /**
 * @return the tipoLibro
 */
 private TipoLibro getTipoLibro() {
	return tipoLibro;
 }

 /**
 * @param isbn the isbn to set
 */
 private void setIsbn(String isbn) {
	this.isbn = isbn;
 }

 /**
 * @param paginas the paginas to set
 */
 private void setPaginas(int paginas) {
	this.paginas = paginas;
 }

 /**
 * @param tipoLibro the tipoLibro to set
 */
 private void setTipoLibro(TipoLibro tipoLibro) {
	this.tipoLibro = tipoLibro;
 }
}
