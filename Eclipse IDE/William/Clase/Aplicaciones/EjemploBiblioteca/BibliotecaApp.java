package Clase.Aplicaciones.EjemploBiblioteca;

import java.util.Scanner;


//===============================
//MAIN (MENÚ CRUD COMPLETO)
//===============================
public class BibliotecaApp {

 static APPRecurso app = new APPRecurso();
 static Scanner sc = new Scanner(System.in);

 public static void main(String[] args) {
     int opcion=-1;
     do {
         System.out.println("\n====== MENÚ BIBLIOTECA ======");
         System.out.println("1. Añadir recurso");
         System.out.println("2. Modificar recurso");
         System.out.println("3. Eliminar recurso");
         System.out.println("4. Listar recursos");
         System.out.println("5. Buscar recurso por ID");
         System.out.println("0. Salir");
         System.out.print("Elige opción: ");
         try {
        	 opcion = Integer.parseInt(sc.nextLine());
         }catch (Exception e) {        	 
        	 opcion=-1;        	 
         }

         switch (opcion) {
             case 1: añadir();break;
             case 2: modificar(); break;
             case 3: eliminar(); break;
             case 4 : app.imprimirTodos(); break;
             case 5 : buscar(); break;
             case 0 : System.out.println("Saliendo..."); break;
             default : System.out.println("Opción no válida"); break;
         }
     } while (opcion != 0);
 }

 // --------------------------
 // CRUD
 // --------------------------

 static void añadir() {
     System.out.println("Tipo de recurso: 1=Libro, 2=Digital");
     int tipo=2;
     do {
    	 try {
    		 tipo = Integer.parseInt(sc.nextLine());
    	 }catch (Exception e) {}
     }while (tipo==1||tipo==2);
     System.out.print("ID: ");
     int id=0;
     do {
    	 try {
	    	 id = sc.nextInt();
	     }catch (Exception ex) {
	    	 sc=new Scanner (System.in);
	     }
     }while (id!=0);
     System.out.print("Título: ");
     String titulo = sc.nextLine();

     if (tipo == 1) {
         System.out.print("ISBN: ");
         String isbn = sc.nextLine();
         System.out.print("Páginas: ");
         int pags=0;
         do {         
        	 try {
        		 pags = Integer.parseInt(sc.nextLine());
        	 }catch( Exception ex) {}         
         }while (pags>0);
         
         int tl;
         boolean correcto = false;
         do {
        	   System.out.println("Tipo libro:");
               int indice = 1;
               for (TipoLibro libro : TipoLibro.values()) {
              	 System.out.println("" + indice++ + "-" + libro.name());
               }
               tl = Integer.parseInt(sc.nextLine());
               if (tl > 0 && tl <= TipoLibro.values().length) {
            	   correcto = true;
            	   TipoLibro tipoLibro = TipoLibro.values()[tl - 1];
                   Libro libro = new Libro(id, titulo, isbn, pags, tipoLibro);
                   app.añadirRecurso(libro);
               } else {
            	   System.out.println("Valor incorrecto");
               }
         } while (!correcto);
         
     } else {
         RecursoDigital digital = new RecursoDigital(id, titulo);

         String seguir;
         do {
             System.out.print("Nombre del contenido: ");
             String nombre = sc.nextLine();
             System.out.print("Tipo (Imagen/PDF/Video): ");
             String t = sc.nextLine();
             System.out.print("Tamaño (ej: 1GB): ");
             String tam = sc.nextLine();

             digital.añadirContenido(new Contenido(nombre, t, tam));

             System.out.print("¿Añadir otro contenido? (s/n): ");
             seguir = sc.nextLine();
         } while (seguir.equalsIgnoreCase("s"));

         app.añadirRecurso(digital);
     }

     System.out.println("Recurso añadido.");
 }

 static void modificar() {
     System.out.print("ID del recurso a modificar: ");
     String id = sc.nextLine();

     Recurso r = app.buscarPorId(id);
     if (r == null) {
         System.out.println("No encontrado.");
         return;
     }

     System.out.print("Nuevo título: ");
     r.setTitulo(sc.nextLine());

     app.modificarRecurso(r);
     System.out.println("Modificado.");
 }

 static void eliminar() {
     System.out.print("ID del recurso a eliminar: ");
     String id = sc.nextLine();

     Recurso r = app.buscarPorId(id);
     if (r == null) {
         System.out.println("No encontrado.");
         return;
     }

     app.eliminarRecurso(r);
     System.out.println("Eliminado.");
 }

 static void buscar() {
     System.out.print("ID del recurso: ");
     String id = sc.nextLine();

     Recurso r = app.buscarPorId(id);
     if (r == null) {
         System.out.println("No encontrado.");
         return;
     }

     r.imprimirInformacion();
 }
}