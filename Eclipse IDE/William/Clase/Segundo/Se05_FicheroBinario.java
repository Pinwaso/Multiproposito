package Clase.Segundo;
import java.io.*;
public class Se05_FicheroBinario {

	public static void main(String[] args) {
		//declarar fichero
		File fichero = new File("ficherob.dat");
		FileOutputStream fileout = null;
		FileInputStream filein = null;
		try {
			//crear flujo salida hacia el fichero
			fileout = new FileOutputStream(fichero);
			
			//crear flujo entrada hacia el fichero
			filein = new FileInputStream(fichero);
			
			int i;
			
			//escribir fichero
			for (i = 1; i <= 100; i++) {
				fileout.write(i);
			}
			
			//leer fichero
			while ((i = filein.read()) != -1) {
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			//operaciones en caso de no encontrar el fichero
			System.out.println("Error: Fichero no encontrado");
			//mostrar el error producido por la excepcion
			System.out.println(e.getMessage());
		} catch (IOException e) {
			//operaciones en caso de error general
			System.out.println("Error");
			System.out.println(e.getMessage());
		} finally {
			//operaciones que se haran en cualquier caso. Si hay error o no
			try {
				if (fileout != null) 
					fileout.close();
				
				if (filein != null) {
					filein.close();
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar el fichero");
				System.out.println(e.getMessage());
			}
		}
	}

}
