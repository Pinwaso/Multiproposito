package Clase.Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class alabama {
	
	private void crearFichero() {
		File fichero = new File("D:/archivo.txt");
		
		if (fichero.exists()) {
			System.out.println("El fichero " + fichero.getName() + " ya existe en la ruta " + fichero.getParent());
		} else {
			try {
				fichero.createNewFile();
				System.out.println("Creado con exito");
				System.out.println(fichero.getAbsolutePath());
			} catch (Exception ex) {
				System.out.println("No se pudo");
			}
		}
	}
	
	private static void verDirectorios() {
		File directorio = new File("C:/");
		String[] archivos = directorio.list();
		if (archivos != null) {
			for (String archivo : archivos) {
				System.out.println(archivo);
			}
		} else {
			System.out.println("No hay directorios");
		}
	}

	private static void escritura() {
		String texto = "Este es un ejemplo de uso de FileWriter en JAVA";
		String fichero = "fichero.txt";
		try {
			// creamos un objeto FileWriter
			FileWriter fileWriter = new FileWriter(fichero);
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
	
	private static void lectura() {
		String fichero = "fichero.txt";
		try {
			// creamos un objeto FileReader
			FileReader fileReader = new FileReader(fichero);
			// leer y mostrar el contenido del archivo
			int caracter;
			System.out.println("Contenido del archivo " + fichero + ":");
			while ((caracter = fileReader.read()) != -1) {
				System.out.print((char) caracter);
			}
			// cerramos el FileReader
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Ocurrió un error al leer el archivo");
			e.printStackTrace();
		}
	}
	
	private static void printwriter() {
		String fichero = "ejemplo.txt";
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fichero));
			pw.print("Esto es un texto sin salto de línea");
			pw.println("NUEVO PALABRA");
			pw.println("Esto es un texto con salto de línea");
			pw.println(4.5455);

			Arrays.stream(new int[] { 1, 2, 3, 4, 10 })
				.filter(n -> n > 2)
				.map(n -> n * 2)
				.forEach(n -> pw.println(n));
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Problemas al escribir en el fichero");
		}
	}
	
	public static void contarPalabras(String nombreArchivo) {
		try {
			int palabras = 0;
			FileReader fr = new FileReader(nombreArchivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] palabrasLinea = linea.split("\\s+");
				palabras += palabrasLinea.length;
			}
			br.close();
			System.out.println(nombreArchivo + " contiene " + palabras + " palabras");
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}

	public static void crearLineas(String nombreFichero, int numLineas) {
		try {
			FileWriter fw = new FileWriter(nombreFichero);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 1; i <= numLineas; i++) {
				bw.write("Esta es la línea " + i);
				bw.newLine();
			}
			bw.close();
			System.out.println(nombreFichero + " creado con " + numLineas + " líneas");
		} catch (IOException e) {
			System.out.println("Error al crear o escribir en el archivo: " + e.getMessage());
		}
	}
	
	public static void ejemploSplit() {
		String linea = "manzana,uva.pera";
		String palabras[] = linea.split("[,.]");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
		
		linea = "uno,dos;tres cuatro";
		palabras = linea.split(",|;| ");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
		
		linea = "hola  mundo";
		palabras = linea.split("[ ]+");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
		
		linea = "esto,es;un buen;, dia, adios";
		palabras = linea.split("[]*[;,]+");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
	}

	public static void main(String[] args) {
		//crearLineas("t.txt", 10);
		//contarPalabras("t.txt");
		ejemploSplit();
	}
}