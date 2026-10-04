package Persistencia;

import java.io.*;
import GamePlanet.Catalogo;
import GamePlanet.Videojuego;
import GamePlanet.Excepciones.FicheroException;
import GamePlanet.Excepciones.FicheronoExistenteException;
/**
 * Clase donde se estructuran metodos de guardado y salvado en ficheros binarios
 * @version 1.0
 * @author William Andrés
 */
public class Ficheros {
	/**
	 * Archivo donde se guarda y carga los datos videojuego.dat
	 */
	private File fichero = new File("videojuego.dat");
	
	/**
	 * Método para guardar el objeto Catalogo en un archivo binario
	 * @param catalogo se le pasa el catalogo como objeto de tipo Catalogo
	 * @throws FicheroException Excepcion si hubo un error en la escritura de archivo
	 */
	public void guardarDatos(Catalogo catalogo) throws FicheroException {
		try {
			ObjectOutputStream ou = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)));
			ou.writeObject(catalogo);
			ou.flush();
			ou.close();
		} catch (IOException ex) {
			throw new FicheroException("Hubo algun error en la escritura de archivo");
		}
	}
	
	/**
	 * Método para cargar el objeto Catalogo desde un archivo binario
	 * @return Devuelve el objeto Catalogo
	 * @throws FicheronoExistenteException Excepcion si el fichero binario no existe
	 * @throws FicheroException Excepcion si hubo un error en la lectura de archivo
	 */
	public Catalogo cargarDatos() throws FicheronoExistenteException, FicheroException {
		if (!fichero.exists()) {
			throw new FicheronoExistenteException("El fichero no existe");
		}
		Catalogo salida = null;
		try {
			ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)));
			salida = (Catalogo)oi.readObject();
			oi.close();
		} catch (IOException ex) {
			throw new FicheroException("Hubo algun error en la escritura de archivo");
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
		return salida;
	}
	
	/**
	 * Método para mostrar por pantalla todos los juegos recuperados del archivo binario
	 * @throws FicheronoExistenteException Excepcion si el fichero binario no existe
	 * @throws FicheroException Excepcion si hubo un error en la lectura de archivos
	 */
	public void mostrarContenidoRecuperado() throws FicheronoExistenteException, FicheroException {
		Catalogo salida = cargarDatos();
		for (Videojuego juego : salida.getListado()) {
			System.out.println(juego.toString());
		}
	}
}