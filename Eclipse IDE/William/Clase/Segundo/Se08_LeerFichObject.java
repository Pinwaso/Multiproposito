package Clase.Segundo;

import java.io.*;

public class Se08_LeerFichObject {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//definir la variable cliente
		Se06_Cliente cliente;
		//declara el fichero
		File fichero = new File("fichcliente.dat");
		//crea el flujo de entrada
		FileInputStream filein = new FileInputStream(fichero);
		//conecta el flujo de bytes al flujo de datos
		ObjectInputStream dataIS = new ObjectInputStream(filein);
		int i = 1;
		try {
			while (true) { //lectura de fichero
				cliente = (Se06_Cliente)dataIS.readObject(); //leer un cliente
				System.out.println("Nombre: " + cliente.getNombre() + ", edad: " + cliente.getEdad());
				System.out.println(i);
				i++;
			}
		} catch (EOFException eo) {
			
		} catch (StreamCorruptedException x) {
			
		}
		dataIS.close();
	}
}