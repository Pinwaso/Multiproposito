package Clase.Aplicaciones.EjemploBiblioteca;


//===============================
//CONTENIDO DIGITAL
//===============================
public class Contenido {
 private String nombre;
 private String tipo;
 private int tamaño;

 public Contenido(String nombre, String tipo, int tamaño) throws ExceptionTamano {
     setNombre(nombre);
     setTipo(tipo);
     setTamaño(tamaño);
 }

 public String getNombre() { return nombre; }
 public String getTipo() { return tipo; }
 public int getTamaño() { return tamaño; }

 @Override
 public String toString() {
     return nombre + " (" + tipo + ", " + tamaño + ")";
 }

 /**
 * @param nombre the nombre to set
 */
 protected void setNombre(String nombre) {
	this.nombre = nombre;
 }

 /**
 * @param tipo the tipo to set
 */
 protected void setTipo(String tipo) {
	this.tipo = tipo;
 }

 /**
 * @param tamaño the tamaño to set
 * @throws ExceptionTamano 
 */
 protected void setTamaño(int tamano) throws ExceptionTamano {
	
	 if (tamano>ExceptionTamano.tamanoMaximo) {
	      throw new ExceptionTamano("El tamaño es superior al permitido: ");
	 }else {
		 this.tamaño = tamano;	 
	 }
	 
 }
}

