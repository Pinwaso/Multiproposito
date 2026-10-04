package GamePlanet;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Clase para comparar Videojuegos por precio, titulo e id
 * @version 1.0
 * @author William Andrés
 */
public class Comparador implements Comparator<Videojuego>, Serializable{
	/**
	 * Identificación único de versión para la serialización de esta clase.
	 */
	private static final long serialVersionUID = -3632118362157805828L;
	/**
	 * Método para compara 2 Videojuegos por precio, titulo e id
	 */
	@Override
	public int compare(Videojuego o1, Videojuego o2) {
		int comparacion = Double.compare(o1.getPrecio(), o2.getPrecio());
		if (comparacion == 0) {
			comparacion = o1.getTitulo().compareTo(o2.getTitulo());
			if (comparacion == 0) {
				comparacion = Integer.compare(o1.getId(), o2.getId());
			}
		}
		return comparacion;
	}
}