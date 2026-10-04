package Clase.Aplicaciones.EjemploBiblioteca;

import java.util.ArrayList;

//===============================
//RECURSO DIGITAL
//===============================
public class RecursoDigital extends Recurso {

private ArrayList<Contenido> contenidos;

public RecursoDigital(String titulo) {
   super(titulo);
   this.contenidos = new ArrayList<>();
}

public void añadirContenido(Contenido c) {
   contenidos.add(c);
}

public ArrayList<Contenido> getContenidos() {
   return contenidos;
}

public int getTamañoTotal() {
   if (contenidos.isEmpty()) return 0;
   int tamano=0;
   for (Contenido c : contenidos) {
       tamano+=c.getTamaño();
   }
   return tamano;
}


@Override
public void imprimirInformacion() {
   System.out.println("=== RECURSO DIGITAL ===");
   System.out.println("ID: " +getId());
   System.out.println("Título: " + getTitulo());
   System.out.println("Contenidos:");
   for (Contenido c : contenidos) {
       System.out.println(" - " + c.toString());
   }
   System.out.println("Tamaño total: " + getTamañoTotal());
}
}
