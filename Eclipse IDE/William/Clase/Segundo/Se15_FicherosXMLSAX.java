package Clase.Segundo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Se15_FicherosXMLSAX {

	public static void main(String[] args) {
		try {
			//se crea un XMLreader
			SAXParserFactory fabrica = SAXParserFactory.newInstance();
			SAXParser parser = fabrica.newSAXParser();
			XMLReader lector = parser.getXMLReader();
			
			GestionContenido gestor = new GestionContenido();
			lector.setContentHandler(gestor);
			InputSource file = new InputSource("Empleados.xml");
			lector.parse(file);
					
		} catch (ParserConfigurationException ex) {
			System.out.println("Problema al crear el XMLreader");
			Logger.getLogger(Se15_FicherosXMLSAX.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			System.out.println("Problema al llamar a los métodos");
			Logger.getLogger(Se15_FicherosXMLSAX.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			System.out.println("Problema de E/S");
			Logger.getLogger(Se15_FicherosXMLSAX.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
	}
	static class GestionContenido extends DefaultHandler {
		public GestionContenido() {
			super();
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			//se crea un String con la cadena de caracteres pasada
			String caracter = new String(ch, start, length);
			//quitamos saltos de linea
			caracter = caracter.replaceAll("[\t\n]", "");
			System.out.println("Caracteres: " + caracter);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("Fin del elemento: " + qName);
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			System.out.println("Comienzo del elemento: " + qName);
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("Fin del documento");
		}

		@Override
		public void startDocument() throws SAXException {
			System.out.println("Comienzo del documento XML");
		}
	}
}