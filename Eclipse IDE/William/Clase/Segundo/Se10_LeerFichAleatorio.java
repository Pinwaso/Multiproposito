package Clase.Segundo;

import java.io.*;

public class Se10_LeerFichAleatorio {

	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		int id, dep, posicion;
		Double salario;
		char apellido[] = new char[10], aux;
		posicion = 0; // Situarse en el principio
		for (;;) { // recorrer el fichero
			file.seek(posicion); // posicionarse en la posicion
			id = file.readInt(); // obtener el id del empleado
			for (int i = 0; i < apellido.length; i++) {
				aux = file.readChar(); // recorre uno a uno los caracteres del apellido
				apellido[i] = aux; // guardar en el array
			}
			String apellidos = new String(apellido); // convertir a String el array
			dep = file.readInt(); // obtener departamento
			salario = file.readDouble(); // obtener salario
			System.out.println(
					"ID: " + id + ", Apellido: " + apellidos + ", Departamento: " + dep + ", Salario " + salario);
			posicion = posicion + 36;
			// posicionarse para el siguiene empleado
			// cada empelado ocupa 36 bytes (4 + 20 + 4 + 80)
			// si se han recorrido todos los bytes salir del for
			if (file.getFilePointer() == file.length())
				break;
		} // fin bucle for
		file.close(); // cerrar el fichero
	}
}