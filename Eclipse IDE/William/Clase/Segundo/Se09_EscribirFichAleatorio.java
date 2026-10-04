package Clase.Segundo;

import java.io.*;

public class Se09_EscribirFichAleatorio {

	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		// declara el fichero de acceso aleatorio
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		// arrays con los datos
		String apellido[] = { "DIEZ", "MEDRANO", "GARCIA", "ARANZUBIA", "MARTINEZ", "JIMENEZ", "NALDA" }; // apellidos
		int dep[] = { 10, 20, 30, 40, 10, 20, 30 }; // departamentos
		Double salario[] = { 1700.45, 600.60, 2000.0, 750.65, 1200.10, 1435.67, 900.0 }; // salarios
		StringBuffer buffer = null; // buffer para almacenar apellido
		int n = apellido.length; // numero de elementos del array
		for (int i = 0; i < n; i++) { // recorro los arrays
			file.writeInt(i + 1); // uso i+l para identificar empleado
			buffer = new StringBuffer(apellido[i]);
			buffer.setLength(10); // 10 caracteres para el apellido
			file.writeChars(buffer.toString()); // insertar apellido
			file.writeInt(dep[i]); // insertar departamento
			file.writeDouble(salario[i]); // insertar salario
		}
		file.close(); // cerrar fichero
	}
}