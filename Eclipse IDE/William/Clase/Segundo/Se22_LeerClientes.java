package Clase.Segundo;

import java.io.*;
import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Se22_LeerClientes {

	public static void main(String[] args) throws IOException {
		XStream xstream = new XStream();
		
		xstream.alias("ListaClientes", Se20_ListaClientes.class);
		xstream.alias("DatosCliente", Cliente.class);
		xstream.addImplicitCollection(Se20_ListaClientes.class, "lista");
		
		//importante, por razones de seguridad si no se pone la siguiente linea
		//dará error de ForbiddenClassException
		xstream.addPermission(AnyTypePermission.ANY);
		
		Se20_ListaClientes listadoTodas = (Se20_ListaClientes) xstream.fromXML(new FileInputStream("Personas.xml"));
		System.out.println("Numero de personas: " + listadoTodas.getListaClientes().size());
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes = listadoTodas.getListaClientes();
		
		ListIterator<Cliente> iterator = listaClientes.listIterator();
		while (iterator.hasNext()) {
			Cliente cliente = (Cliente) iterator.next();
			System.out.println("Nombre: " + cliente.getNombre());
			System.out.println("Edad: " + cliente.getEdad());
		}
		System.out.println("Fin del listado");
	}
}