package Clase.Segundo;
import java.io.*;
public class Se07_EscribirFichObject {

	public static void main(String[] args) throws IOException{
		//definir variable cliente
		Se06_Cliente cliente; 
		//declara el fichero
		File fichero = new File("fichcliente.dat");
		//crea el flujo de salida
		FileOutputStream fileout = new FileOutputStream(fichero, true);
		//conecta el flujo de bytes al flujo de datos
		ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
		
		String nombres[] = {"Antonio", "Laura", "Miguel", "Alberto", "Rebeca", "Sara"};
		
		int edades[] = {18, 20, 21 ,33, 25, 42};
		
		//recorrer los arrays
		for (int i = 0; i < edades.length; i++) {
			//crea el cliente
			cliente = new Se06_Cliente(nombres[i], edades[i]);
			//escribe el cliente en el fichero
			dataOS.writeObject(cliente);
		}
		//cerrar stream de salida
		dataOS.close();
	}
}