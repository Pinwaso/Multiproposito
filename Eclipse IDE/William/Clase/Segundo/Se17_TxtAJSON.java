package Clase.Segundo;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Se17_TxtAJSON {
	
	public static void main(String[] args) {
		File Fichero = new File("alumnos.txt");
		ArrayList<Se16_Alumno> alumnos = new ArrayList<>();
		
		//lectura del fichero plano
		try (BufferedReader br = new BufferedReader(new FileReader(Fichero))){
			String linea;
			while ((linea = br.readLine()) != null) {
				//la linea se separa mediante , como delimitador y lo guarda en un array de Strings
				String[] datos = linea.split(",");
				//se recojen los datos
				int id = Integer.parseInt(datos[0].trim());
				String nombre = datos[1].trim();
				double nota = Double.parseDouble(datos[2].trim());
				//se agregan los alumnos a la lista
				alumnos.add(new Se16_Alumno(id, nombre, nota));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//escritura en JSON mediante ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT); //Formato "pretty print"
		
		try {
			File salida = new File("alumnos.json");
			mapper.writeValue(salida, alumnos);
			System.out.println("Fichero JSON generado con éxito");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}