package Clase.Segundo;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class Se19_MapeoCsv {

	public static void exportaraCsv(ArrayList<Se16_Alumno> alumnos, File destino) throws IOException {
		//se inicia el motor
		CsvMapper mapper = new CsvMapper();
		
		//se crea el esquema a partir de las anotaciones de la clase
		CsvSchema schema = mapper.schemaFor(Se16_Alumno.class) //incluye la fila de cabecera
				.withHeader() //escribir los nombres de las columnas en la primera fila
				.withColumnSeparator(';'); //delimitador habitual
		
		//se activa el escritor pasandole el plano y se vuelca la lista en el archivo fisico
		mapper.writer(schema).writeValue(destino, alumnos);
	}
	
	public static List<Se16_Alumno> importarDesdeCsv(File origen) throws IOException{
		//se inicia el motor
		CsvMapper mapper = new CsvMapper();
		
		//se crea el esquema a partir de las anotaciones de la clase
		CsvSchema schema = mapper.schemaFor(Se16_Alumno.class)//incluye la fila de cabecera
				.withHeader()
				.withColumnSeparator(';');
		
		//se le indica al lector que tipo de objeto debe fabricar por cada fila,
		return mapper.readerFor(Se16_Alumno.class)
				.with(schema) //aplicamos el esquema
				.<Se16_Alumno>readValues(origen) //leemos todas las lineas y se devuelve en una lista
				.readAll();
	}

}
