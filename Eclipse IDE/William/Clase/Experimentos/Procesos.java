package Clase.Experimentos;

import java.io.IOException;

public class Procesos {

	public Procesos() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/*Se obtiene el contexto*/
		Runtime r = Runtime.getRuntime();
		/*Lo que se abrira*/
		String comando = "cmd /c start cmd /K ipconfig";
		/*String comando2 = "NOTEPAD";*/
		/*Se crea un proceso*/
		Process p;
		try {
			p = r.exec(comando);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}