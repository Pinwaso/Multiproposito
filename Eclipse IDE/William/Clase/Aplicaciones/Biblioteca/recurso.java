package Clase.Aplicaciones.Biblioteca;

public abstract class recurso {
	static private int identificacion = 0;
	private int id;
	private String titulo;
	
	public recurso(String titulo) {
		this.setId(identificacion++);
		this.setTitulo(titulo);
	}
	
	public recurso(int id, String titulo) {
		this.setId(id);
		this.setTitulo(titulo);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTipoRecurso() {
		String nombre = this.getClass().getName();
		int punto = nombre.lastIndexOf(".");
		if (punto > -1) {
			nombre = nombre.substring(punto+1);
		}
		return nombre;
		
		/*if (this instanceof recursoLibro) {
			return this.getClass().getName();
		} else if (this instanceof recursoDigital) {
			return this.getClass().getName();
		} else {
			return "Tipo no definido";
		}*/
	}
	public abstract void imprimirInformacion();
}