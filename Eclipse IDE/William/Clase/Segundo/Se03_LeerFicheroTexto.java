package Clase.Segundo;

import java.io.*;

public class Se03_LeerFicheroTexto {

	public static void main(String[] args) {
		//declarar fichero
		File fichero = new File("fichero1.txt");
		//declarar la variable fileReader
		FileReader fr = null;
		try {
			//abriur el fichero indicado en la variable fichero
			fr = new FileReader(fichero);
			//se recorre el fichero hasta encontrar el caracer -1
			//que marca el final del fichero
			int i;
			char b[] = new char[10];
			while ((i = fr.read(b)) != 1) {
				System.out.println(b);
			}
		} catch (FileNotFoundException e) {
			//operaciones en caso de no encontrar el fichero
			System.out.println("Error: fichero no encontrado");
			//mostrar el error producido por la excepcion
			System.out.println(e.getMessage());
		} catch (IOException e) {
			//operaciones en caso de error general
			System.out.println("Error de lectura del archivo");
			System.out.println(e.getMessage());
		} finally {
			//operaciones que se haran en cualquier caso. Si hay error o no.
			try {
				//cerrar el fichero si se ha abierto
				if (fr !=null)
					fr.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar le fichero");
				System.out.println(e.getMessage());
			}
		} 	
	}
}