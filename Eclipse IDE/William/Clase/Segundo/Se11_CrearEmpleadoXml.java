package Clase.Segundo;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Se11_CrearEmpleadoXml {
	public static void main(String args[]) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		
		//situarse al principio del fichero
		int id, dep, posicion = 0;
		Double salario;
		char apellido[] = new char[10], aux;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");
			
			for (;;) {
				file.seek(posicion); //posicionarse en el fichero
				id = file.readInt(); //obtener el del empleado 
				for (int i = 0; i < apellido.length; i++) {
					aux = file.readChar();
					apellido[i] = aux;
				}
				String apellidos = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();
				
				//id validos a partir del 1
				if (id > 0) {
					//nodo empleado
					Element raiz = document.createElement("empleado");
					document.getDocumentElement().appendChild(raiz);
					//añadir ID
					CrearElemento("id", Integer.toString(id), raiz, document);
					//apellido
					CrearElemento("apellido", apellidos.trim(), raiz, document);
					//añadir DEP
					CrearElemento("dep", Integer.toString(dep), raiz, document);
					//añadir salario
					CrearElemento("salario", Double.toString(salario), raiz, document);
				}
				posicion = posicion + 36; //me posicion para el sig empleado
				if (file.getFilePointer() == file.length())
					break;
			} //fin del for que recorre el fichero
			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("Empleados.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		file.close(); //cerrar el fichero
	} //fin del main
	
	//metodo que realiza la insercion de los datos del empelado
	static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor); //dar valor
		raiz.appendChild(elem); //pegar el documento hijo a la raiz
		elem.appendChild(text); //pegar el valor
	}
} //fin de la clase