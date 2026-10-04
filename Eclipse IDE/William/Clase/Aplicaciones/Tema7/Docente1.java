package Clase.Aplicaciones.Tema7;

public class Docente1 implements PersonaCentroEducativo {
    String nombre;
	
    public Docente1(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public String toString() {
		return "Alumno1 [nombre=" + nombre + "]";
	}

}
