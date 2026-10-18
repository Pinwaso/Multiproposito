package Clase.Segundo;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Se14_LecturaEmpleadoXml2 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document= builder.parse(new File("Empleados2.xml"));
			document.getDocumentElement().normalize();
			
			System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
			//crea una lista con todos los nodos empleado
			NodeList empleados = document.getElementsByTagName("empleado");
			System.out.printf("Nodos empleado a recorrer: %d %n", empleados.getLength());
			//recorre la lista
			for (int i = 0; i < empleados.getLength(); i++) {
				/*<empleados>
				 * 	<empleado apellido = " ">
				 * 		<datos departamento = " " salario = " "/>
				 * 			<id> </id>
				 *	</empleado>
				 *</empleados>
				 * */
				//obtener un nodo empleado
				Node emple = empleados.item(i);
				if (emple.getNodeType() == Node.ELEMENT_NODE) { //tipo de nodo
					//castear el nodo a element
					Element elemento = (Element) emple;
					//obtener el apellido
					String apellido = elemento.getAttribute("apellido");
					//obtener departamento y salario
					//primero se obtiene el nodo datos
					Element nododatos = (Element)elemento.getElementsByTagName("datos").item(0);
					//luego se obtienen los atributos
					String departamento = nododatos.getAttribute("departamento");
					String salario = nododatos.getAttribute("salario");
					//se obtiene el id
					Element nodoid = (Element)nododatos.getElementsByTagName("id").item(0);
					String id = nodoid.getTextContent();
					//se muestran los datos por pantalla
					System.out.printf("ID = %s %n", id);
					System.out.printf(" * Apellido = %s %n", apellido);
					System.out.printf(" * Departamento = %s %n", departamento);
					System.out.printf(" * Salario = %s %n", salario);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} //fin del main
}