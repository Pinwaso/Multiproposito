package Clase.Ficheros;

import java.io.FileWriter;
import java.io.IOException;

public class PrimeraLectura {

	public PrimeraLectura() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String texto = "Este es un ejemplo de uso de FileWriter en JAVA";
		String fichero = "fichero.txt";
		try {
			// creamos un objeto FileWriter
			FileWriter fileWriter = new FileWriter(fichero,true);
			// escribimos una String en el archivo
			fileWriter.write(texto);
			// cerramos el FileWriter
			fileWriter.close();
			System.out.println("Se ha escrito en el fichero correctamente");
		} catch (IOException e) {
		System.out.println("Ocurrió un error al escribir en el fichero");
		e.printStackTrace();
		}
	}

}
