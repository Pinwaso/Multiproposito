package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Nombre del ejercicio Es el ejercicio ??? de Acepta el reto
 * 
 * @author William Andrés
 * @version dd.mm.aaaa
 */
public class y_el_ganador_es_186 {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	private static boolean casoDePrueba() {
		int equipos = entrada.nextInt();
		int globos = entrada.nextInt();
		if (equipos == 0 && globos == 0) {
			return false;
		} else {
			int array[] = new int[equipos];
			int maximo = Integer.MIN_VALUE, team = 0;
			boolean empate = false;
			for (int a = 0; a < globos; a++) {
				int equipo = entrada.nextInt();
				String globo = entrada.nextLine();
				array[equipo-1]++;
			}
			for (int b = 0; b < array.length; b++) {
				if (array[b] > maximo) {
					maximo = array[b];
					team = b+1;
					empate = false;
				} else if (array[b] == maximo) {
					empate = true;
				} 
			}
			if (empate) {
				System.out.println("EMPATE");
			} else {
				System.out.println(team);
			}
			return true;
		}
	}
}