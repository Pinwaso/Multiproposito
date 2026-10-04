package Clase.Experimentos;

import java.io.*;

public class Reader {
	
	public static void main(String[] args) {
		File fichero = new File("I:\\DAM\\DAM 2 año\\Acceso a datos\\quijote.txt");
		readbuffer2(fichero);
	}
	
	private static void read(File fichero) {
		int caracter;
		try {
			FileReader lectura = new FileReader(fichero);
			while ((caracter = lectura.read()) != -1) {
				System.out.print((char)caracter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void readbuffer(File fichero) {
		char[] buffer = new char[16];
		try {
			FileReader lectura = new FileReader(fichero);
			while (lectura.read(buffer) != -1) {
				for (int i = 0; i < buffer.length; i++) {
					System.out.print(buffer[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void readbuffer2(File fichero) {
		char[] buffer = new char[16];
		try {
			FileReader lectura = new FileReader(fichero);
			/*
			 * se escribe en el buffer desde en indice 2, donde se escriben 5 elementos hasta la siguiente lectura
			 */
			while (lectura.read(buffer, 2, 5) != -1) {
				for (int i = 0; i < buffer.length; i++) {
					System.out.print(buffer[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}