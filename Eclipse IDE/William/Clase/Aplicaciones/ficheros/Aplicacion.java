package Clase.Aplicaciones.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Aplicacion que recibe una ruta de archivo
 */
public class Aplicacion {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Método para llamar a la funcion principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		aplicacion();
	}

	/**
	 * Método principal para la aplicacion
	 */
	private static void aplicacion() {
		System.out.println("Ingrese la ruta del fichero");
		String ruta = sc.nextLine().trim();
		File archivo = new File(ruta);
		if (!archivo.exists()) {
			try {
				String nuevaruta = ruta.substring(0, ruta.lastIndexOf("/"));
				nuevaruta += "/holamundo.txt";
				File newarchivo = new File(nuevaruta);
				newarchivo.createNewFile();
				escribir(newarchivo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			/*try {
				String nuevaruta = "";
				for (int a = ruta.length() - 1; a > 0; a--) {

				}
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
	}

	private static void escribir(File archivo) {
		try {
			FileWriter es = new FileWriter(archivo);
			PrintWriter pt = new PrintWriter(es);
			pt.println("Hola Mundo");
			pt.flush();
			pt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}