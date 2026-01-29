package competitivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * De nuevo en el bar de Javier 108 de Acepta el reto
 * 
 * @author William Andrés
 * @version 19.11.2025
 */
public class de_nuevo_en_el_bar_de_javier_108 {
	static float[] comidas = new float[5];
	static Scanner entrada = new Scanner(System.in);

	public static void main(String args[]) {
		while (casoDePrueba()) {
		}
	}

	public static boolean casoDePrueba() {
		if (!entrada.hasNext()) return false;
		String letra = entrada.next();
		float cantidad = entrada.nextFloat();
		if (letra.charAt(0) == 'N' && cantidad == 0) {
			System.out.println(masVendido() + "#" + menosVendido() + "#" + superaMedia());
			comidas = new float[5];
			return true;
		} else {
			switch (letra) {
			case "D": comidas[0] = comidas[0] + cantidad; break;
			case "A": comidas[1] = comidas[1] + cantidad; break;
			case "M": comidas[2] = comidas[2] + cantidad; break;
			case "I": comidas[3] = comidas[3] + cantidad; break;
			case "C": comidas[4] = comidas[4] + cantidad; break;
			}
		}
		return true;
	}

	private static String superaMedia() {
		String mensaje = "SI";
		float media = 0f;
		int diferencia = 0;
		for (int i = 0; i < comidas.length; i++) {
			if (comidas[i] != 0) {
				media += comidas[i];
				diferencia++;
			} 	
		}
		media/=diferencia;
		if (comidas[1] < media) {
			mensaje = "NO";
		}
		return mensaje;
	}

	private static String masVendido() {
		String mensaje = "";
		float maxvendido = Integer.MIN_VALUE;
		for (int i = 0; i < comidas.length; i++) {
			if (maxvendido < comidas[i]) {
				maxvendido = comidas[i];
				switch (i) {
				case 0: mensaje = "DESAYUNOS"; break;
				case 1: mensaje = "COMIDAS"; break;
				case 2: mensaje = "MERIENDAS"; break;
				case 3: mensaje = "CENAS"; break;
				case 4: mensaje = "COPAS"; break;
				}
			} else if (maxvendido == comidas[i]) {
				mensaje = "EMPATE";
			}
		}
		return mensaje;
	}

	private static String menosVendido() {
		String mensaje = "";
		float minvendido = Integer.MAX_VALUE;
		for (int i = 0; i < comidas.length; i++) {
			if (minvendido > comidas[i]) {
				minvendido = comidas[i];
				switch (i) {
				case 0: mensaje = "DESAYUNOS"; break;
				case 1: mensaje = "COMIDAS"; break;
				case 2: mensaje = "MERIENDAS"; break;
				case 3: mensaje = "CENAS"; break;
				case 4: mensaje = "COPAS"; break;
				}
			} else if (minvendido == comidas[i]) {
				mensaje = "EMPATE";
			}
		}
		return mensaje;
	}
}