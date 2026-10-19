package Clase.Segundo;

import java.io.*;

import com.thoughtworks.xstream.XStream;

public class Se21_EscribirClientes {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File fichero = new File("FichCliente.dat");
		//flujo de entrada
		FileInputStream filein = new FileInputStream(fichero);
		//conecta el fujo de bytes al flujo de datos
		ObjectInputStream dataIS = new ObjectInputStream(filein);
		System.out.println("Comienza el proceso de creación del fichero XML");
		//creamos un objeto Lista de Clientes
		Se20_ListaClientes listacli = new Se20_ListaClientes();
		
		try {
			while (true) { //lectura del fichero
				//leer una persona
				Cliente cliente = (Cliente) dataIS.readObject();
				//se añade cliente a la lista
				listacli.add(cliente);
			}
		} catch (EOFException eo) {
			//cerrar el stream de entrada
			dataIS.close();
		}
		
		try {
			XStream xstream = new XStream();
			//cambiar de nombre a las etiquetas XML
			xstream.alias("ListaClientesMunicipio", Se20_ListaClientes.class);
			xstream.alias("DatosCliente", Cliente.class);
			
			//xstream.aliasField("Nombre cliente", "Cliente.class", "nombre");
			//xstream.aliasField("Edad cliente", "Cliente.class", "edad");
			
			//quitar etiqueta lista (atributo de la clase Se20_ListaClientes)
			xstream.toXML(listacli, new FileOutputStream("Clientes.xml"));
			System.out.println("Creado fichero XML");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}