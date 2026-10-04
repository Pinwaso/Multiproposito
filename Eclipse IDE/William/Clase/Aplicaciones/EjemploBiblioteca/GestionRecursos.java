package Clase.Aplicaciones.EjemploBiblioteca;

import java.util.ArrayList;

//===============================
//INTERFAZ
//===============================
public interface GestionRecursos {
	
 boolean añadirRecurso(Recurso recurso);
 boolean eliminarRecurso(Recurso recurso);
 boolean modificarRecurso(Recurso recurso);
 boolean eliminarRecurso(int id);
 ArrayList<Recurso> listarRecursos();
}
