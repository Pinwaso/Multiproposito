package Clase.Clase;
import java.util.ArrayList;

// un arraylist de 10 a 50 elementos
// cada elemento debe tener un valor de 0 a 1000
public class arraylists_1 {

	public static void main(String[] args) {
		ArrayList<Integer> listapadre = new ArrayList<>();
		for (int i = 0; i <= random(10, 50); i++) {
			listapadre.add(random(1000));
		}
		System.out.println(listapadre.toString());
		System.out.println("El tamaño de la lista es: " + listapadre.size());
	}
	static int random(int maximo) {
		return (int)(Math.random() * maximo + 1);
	}
	static int random(int minimo, int maximo) {
		return (int)(Math.random() * (maximo - minimo + 1) + minimo);
	}
}