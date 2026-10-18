package Clase.Segundo;

import java.security.Timestamp;
import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Ejercicio1_Convertir {

	public static void main(String[] args) {
		File fichero = new File("logs.txt");
		//lista de objetos logs con anotaciones
		ArrayList<Ejercicio1_RegistroLogs> lista = new ArrayList<>(); 
		String linea = null;
		
		try {
			//se lee el archivo de logs, se guardan sus datos y se crean objetos logs en la lista
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			while ((linea = br.readLine()) != null) {
				String[] palabras = linea.split("|");
				String tiempo = palabras[0].trim();
				String nivel = palabras[1].trim();
				String mensaje = palabras[2].trim();
				lista.add(new Ejercicio1_RegistroLogs(tiempo, nivel, mensaje));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			//se guardan los logs de la lista en JSON
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			File salida = new File("logs.json");
			mapper.writeValue(salida, lista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}