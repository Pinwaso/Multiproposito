package Clase.Aplicaciones.EjemploBiblioteca;

import java.util.ArrayList;

//===============================
//APP RECURSO (CRUD)
//===============================
class APPRecurso implements GestionRecursos {

private ArrayList<Recurso> recursos;

public APPRecurso() {
   recursos = new ArrayList<>();
}

@Override
public boolean añadirRecurso(Recurso recurso) {
   return recursos.add(recurso);
}

@Override
public boolean eliminarRecurso(Recurso recurso) {
   return recursos.remove(recurso);
}

public boolean eliminarRecurso(int id) {
	 for (int i = 0; i < recursos.size(); i++) {
	       if (recursos.get(i).getId()==(id)) {    	   
	    	   recursos.remove(i);
	           return true;
	       }
	   }
	   return false;
	}


@Override
public boolean modificarRecurso(Recurso recursoActualizado) {
   for (int i = 0; i < recursos.size(); i++) {
	   
	   
       if (recursos.get(i).getId()==(recursoActualizado.getId())) {    	   
    	   recursos.set(i, recursoActualizado);
           return true;
       }
   }
   return false;
}

@Override
public ArrayList<Recurso> listarRecursos() {
   return recursos;
}

public Recurso buscarPorId(int id) {
   for (Recurso r : recursos) {
       if (r.getId()==id) return r;
   }
   return null;
}

public void imprimirTodos() {
   for (Recurso r : recursos) {
       r.imprimirInformacion();
       System.out.println("------------------");
   }
}
}
