package Clase.Aplicaciones.EjemploBiblioteca;


//===============================
//CLASE BASE ABSTRACTA
//===============================
public abstract class Recurso {
 private int id;
 private String titulo;
 private static int semilla=0;
 
  
 public Recurso(String titulo) {
     this.setId(semilla++);
     this.setTitulo(titulo);
 }
 
 public Recurso(int id, String titulo) {
	 this.setId(id);
	 this.setTitulo(titulo);
 }
 
 private void setId(int id) { this.id=id;}
 public int getId(){return id;}
 public String getTitulo() { return titulo; }
 public void setTitulo(String titulo) { this.titulo = titulo; }

 public String getTipoRecurso() {	 
	 String valor=this.getClass().getName();
	 int punto=valor.lastIndexOf(".");
	 if (punto>-1) {
		 valor=valor.substring(punto+1);
	 }
	 return  valor;
	 
	 /*if (this instanceof Libro) {
		 return this.getClass().getName();
	 }else if (this instanceof Libro) {
		 return "RecursoDigital";
	 }else {
		 return this.getClass().getName();
	 }*/
	 
	 
 }
 public abstract void imprimirInformacion();
}
