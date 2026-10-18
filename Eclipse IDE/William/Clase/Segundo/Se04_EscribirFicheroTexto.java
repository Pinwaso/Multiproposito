package Clase.Segundo;
import java.io.*;
public class Se04_EscribirFicheroTexto {
	
	public static void main(String[] args) {
		//declarar el fichero
		File fichero = new File("fichero1.txt");
		//declarar una variable FileWriter
		FileWriter fw = null;	
		String texto = "Probando FileWriter";
		//convertir el texto en array de caracteres para extraerlos 1 a 1
		char[] cadena = texto.toCharArray();
		try {
			fw = new FileWriter(fichero);
			//recorre la cadena caracter a caracter
			for (int i = 0; i < cadena.length; i++) {
				//escribe un caracter
				fw.write(cadena[i]);
			}
			//añadir al final un *
			fw.append('*');
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			//operaciones que se haran en cualquier caso. Si hay error o no
			try {
				//cerrar el fichero si se ha abierto
				if (fw != null)
					fw.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar el fichero");
				System.out.println(e.getMessage());
			}
		}
	}
}