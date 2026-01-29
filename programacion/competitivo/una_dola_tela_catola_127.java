package competitivo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Una, dola, tela, catola Es el ejercicio de Acepta el reto 127
 * 
 * @author William Andrés
 * @version 09.12.2025
 */
public class una_dola_tela_catola_127 {
	static ArrayList<String> lista;
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		
		int numCasosDePrueba = entrada.nextInt();
		entrada.nextLine();
		for (int i = 1; i <= numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}

	private static void casoDePrueba() {
		lista = new ArrayList<>();
		boolean correcto = false;
		do {
			String nombre = entrada.nextLine();
			if (nombre.equals("F")) {
				correcto = true;
			} else {
				lista.add(nombre);
			}
		} while (!correcto);
		int camas = entrada.nextInt();
		int palabras = entrada.nextInt();
		entrada.nextLine();
		
		if (camas == 0) {
			System.out.println("NADIE TIENE CAMA");
		} else if (camas >= lista.size()){
			System.out.println("TODOS TIENEN CAMA");
		} else {
			
			
			
			/*int elegido = 0;
			while (lista.size() > camas) {				
				elegido = (elegido + palabras -1) % lista.size();
				lista.remove(elegido);
			}*/
		}
	}
}
