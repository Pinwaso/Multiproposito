package Clase.Clase;
import java.util.ArrayList;

public class graficolineas2d {
	private final ArrayList<punto> puntos;
	
	public graficolineas2d() {
		this.puntos = new ArrayList<>();
	}
	public void setAgregarPuntos(int x, int y) {
		if (puntos.isEmpty()) {
			puntos.add(new punto(x, y));
		} else {
			boolean correcto = true;
			for (int i = 0; i < puntos.size(); i++) {
				if (puntos.get(i).getX() <= x && puntos.get(i).getY() == y) {
					correcto = false;
				}
			}
			if (correcto) {
				puntos.add(new punto(x, y));
				System.out.println("Punto añadido correctamente");
			} else {
				System.out.println("Punto repetido");
			}
		}
	}
	public void setEliminarPuntos(int indice) {
		puntos.removeLast();
	}
}
