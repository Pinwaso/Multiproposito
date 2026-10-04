package Clase.Experimentos;

import java.util.ArrayList;

public class ArrayListNumero extends ArrayList<Integer> {
	
	public ArrayListNumero() {
		super();
	}

	@Override
	public boolean add(Integer e) {
		boolean correcto = false;
		int indice = 0;
		for (int i = 0; i < super.size(); i++) {
			if (e < super.get(i)) {
				super.add(indice-1, e);
				correcto = true;
				break;
			} else {
				indice ++;
			}
		}
		return correcto;
	}
}