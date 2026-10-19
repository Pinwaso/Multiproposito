package Clase.Segundo;

import java.io.*;

public class Se01_VerDirectorios {
	public static void main(String[] args) {
		System.out.println("Archivos en el directorio actual:");
		File f = new File(".");

		String[] archivos = f.list();
		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
		}
	}
}
