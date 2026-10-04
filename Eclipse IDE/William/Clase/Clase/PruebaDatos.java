package Clase.Clase;

import java.util.ArrayList;
import java.util.Arrays;

public class PruebaDatos {

	private static ArrayList<String> palabras;
	
	public static void main(String[] args) {
		//Para ejecutarlo desde consola, se tiene que ir
		//al mismo directorio donde se encuentra este archivo
		//luego se ejecuta java PruebaDatos.java [parametro] [parametro]
		//si son string es sin "" y separados con , en caso de tener espacios
		//si incluye los "".
		palabras = new ArrayList<>();
		for (String var : args) {
			palabras.add(var);
		}
		System.out.println(palabras.toString());
	}
}