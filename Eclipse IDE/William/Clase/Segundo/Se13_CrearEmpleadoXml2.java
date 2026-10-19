package Clase.Segundo;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Se13_CrearEmpleadoXml2 {
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
					/*<empleados>
					 * 	<empleado apellido = " ">
					 * 		<datos departamento = " " salario = " "/>
					 * 			<id> </id>
					 *	</empleado>
					 *</empleados>
					 * */
					//nodo empleado
					Element raiz = document.createElement("empleado");
					//añadir atributo apellido
					raiz.setAttribute("apellido", apellidos.trim());
					//se agrega el nodo empleado a la raiz del documento <empleados>
					document.getDocumentElement().appendChild(raiz);
					//se crea el nodo id
					Element nodoid = document.createElement("id");
					//se crea el texto id
					Text textoid = document.createTextNode(String.valueOf(id));
					//se añade el texto id a la etiqueta id
					nodoid.appendChild(textoid);
					//se crea el nodo datos
					Element nododatos = document.createElement("datos");
					//se añade la etiqueta id a la etiqueta datos
					nododatos.appendChild(nodoid);
					//se añaden los atributos a la etiqueta datos
					nododatos.setAttribute("departamento", String.valueOf(dep));
					nododatos.setAttribute("salario", String.valueOf(salario));
					//se añade la etiqueta datos a la etiqueta empleado
					raiz.appendChild(nododatos);
				}
				posicion = posicion + 36; //me posicion para el sig empleado
				if (file.getFilePointer() == file.length())
					break;
			} //fin del for que recorre el fichero
			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("Empleados2.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		file.close(); //cerrar el fichero
	} //fin del main
} //fin de clase