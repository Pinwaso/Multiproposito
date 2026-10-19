package Clase.Segundo;

import java.util.*;

public class ClienteLista {
	private List<Cliente> lista = new ArrayList<>();
	
	public ClienteLista() {
		
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void add(Cliente cliente) {
		lista.add(cliente);
	}
}