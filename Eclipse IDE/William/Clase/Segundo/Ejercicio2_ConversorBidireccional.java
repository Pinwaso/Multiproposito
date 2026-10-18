package Clase.Segundo;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Ejercicio2_ConversorBidireccional {

	public static void main(String[] args) throws IOException {
		System.out.println("Ingrese la ruta del archivo de origen");
		Scanner entrada1 = new Scanner(System.in);
		String origen = entrada1.next();
		entrada1.close();
		System.out.println("Ingrese la ruta del archivo de destino");
		Scanner entrada2 = new Scanner(System.in);
		String destino = entrada2.next();
		entrada2.close();
		
		if (origen.contains(".xml") && destino.contains(".json")) {
			File xml = new File(origen);
			File json = new File(destino);
			
			XmlMapper xmlmapper = new XmlMapper();
			JsonNode tree = xmlmapper.readTree(json);
			
			ObjectMapper jsonmapper = new ObjectMapper();
			jsonmapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
			jsonmapper.writeValue(json, tree);
		}
		
		if (origen.contains(".json") && destino.contains(".xml")) {
			File json = new File(origen);
			File xml = new File(destino);
			
			ObjectMapper jsonmapper = new ObjectMapper();
			JsonNode tree = jsonmapper.readTree(origen);
			
			XmlMapper xmlmapper = new XmlMapper();
			xmlmapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
			xmlmapper.writeValue(json, tree);
		}
	}
}