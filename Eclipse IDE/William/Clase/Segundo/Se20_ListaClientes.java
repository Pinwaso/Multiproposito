package Clase.Segundo;

import java.util.*;

public class Se20_ListaClientes {
	private List<Cliente> lista = new ArrayList<Cliente>();
	
	public Se20_ListaClientes() {
	}
	
	public void add(Cliente cliente) {
		lista.add(cliente);
	}
	
	public List<Cliente> getListaClientes() {
		return lista;
	}
}