package Clase.Segundo;

import java.io.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Se18_ConversorJsonXml {

	//converir de JSON a XML
	public static void jsonAXml(File JsonFile, File XmlFile) throws IOException {
		ObjectMapper jsonmapper = new ObjectMapper();
		JsonNode tree = jsonmapper.readTree(JsonFile); //carga el Json en memoria como arbol
		
		XmlMapper xmlmapper = new XmlMapper();
		xmlmapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
		xmlmapper.writeValue(XmlFile, tree);
	}
	
	//convertir de XML a JSON
	public static void xmlAJson(File xmlFile, File jsonFile) throws IOException {
		XmlMapper xmlmapper = new XmlMapper();
		JsonNode tree = xmlmapper.readTree(xmlFile);
		
		ObjectMapper jsonmapper = new ObjectMapper();
		jsonmapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
		jsonmapper.writeValue(jsonFile, tree);
	}
	
	public static void main(String[] args) {
		try {
			jsonAXml(new File("alumnos.son"), new File("alumnos.xml"));
			System.out.println("Convertido JSON -> XML");
			
			xmlAJson(new File("alumnos.xml"), new File("alumnos_desde_xml.json"));
			System.out.println("Convertido XML -> JSON");
		} catch (IOException e) {
			e.printStackTrace();		}
	}

}
