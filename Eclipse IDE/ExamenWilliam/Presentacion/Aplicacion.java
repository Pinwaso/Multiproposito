package Presentacion;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import GamePlanet.Catalogo;
import GamePlanet.Videojuego;
import GamePlanet.Excepciones.DescuentonoValidoException;
import GamePlanet.Excepciones.ErrorSQLException;
import GamePlanet.Excepciones.FechanoValidaException;
import GamePlanet.Excepciones.FicheroException;
import GamePlanet.Excepciones.FicheronoExistenteException;
import GamePlanet.Excepciones.IDnoValidoException;
import GamePlanet.Excepciones.JuegonoEncontradoException;
import GamePlanet.Excepciones.PrecionoValidoException;
import GamePlanet.Excepciones.StocknoValidoException;
import GamePlanet.Excepciones.VideojuegoEliminacionException;
import GamePlanet.Excepciones.VideojuegoInsercionException;
import Persistencia.BasesdeDatos;
import Persistencia.Ficheros;

/**
 * Aplicación para ejecutar el programa
 * @version 1.0
 * @author William Andrés
 */
public class Aplicacion {
	/**
	 * Escaner estático de la aplicación
	 */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Método para pedir un valor int
	 * @param mensaje Se le pasa un String como mensaje
	 * @param error Se le pasa un String como mensaje de error
	 * @return devuelve un valor int
	 */
	private int pedirInt(String mensaje, String error) {
		boolean correcto = false;
		int salida = 0;
		do {
			try {
				System.out.println(mensaje);
				salida = sc.nextInt();
				sc.nextLine();
				correcto = true;
			} catch (Exception ex) {
				System.out.println(error);
				sc.nextLine();
			}
		} while (!correcto);
		return salida;
	}
	
	private boolean pedirBoolean(String mensaje, String error) {
		boolean correcto = false;
		boolean salida = true;
		do {
			try {
				System.out.println(mensaje);
				salida = sc.nextBoolean();
				sc.nextLine();
				correcto = true;
			} catch (Exception ex) {
				System.out.println(error);
				sc.nextLine();
			}
		} while (!correcto);
		return salida;
	}
	
	/**
	 * Método para pedir un valor double
	 * @param mensaje Se le pasa un String como mensaje
	 * @param error Se le pasa un String como mensaje de error
	 * @return devuelve un valor Double
	 */
	private double pedirDouble(String mensaje, String error) {
		boolean correcto = false;
		double salida = 0;
		do {
			try {
				System.out.println(mensaje);
				salida = sc.nextDouble();
				sc.nextLine();
				correcto = true;
			} catch (Exception ex) {
				System.out.println(error);
				sc.nextLine();
			}
		} while (!correcto);
		return salida;
	}
	
	/**
	 * Método para pedir un String
	 * @param mensaje se le pasa un mensaje como String
	 * @return devuelve un valor String
	 */
	private String pedirString(String mensaje) {
		System.out.println(mensaje);
		String salida = sc.next();
		sc.nextLine();
		return salida;
	}
	
	/**
	 * Método estructurar el menú
	 * @return devuelve la estructura del menú en String
	 */
	private String menu() {
		return """
				1. Añadir Videojuego
				2. Eliminar Videojuego
				3. Buscar Videojuego por titulo
				4. Buscar Videojuego por id
				5. Filtrar Videojuego por precio
				6. Obtener precio total Videojuego
				7. Mostrar Videojuego mas caro
				8. Calcular precio medio
				9. Mostrar Videojuegos
				10. Guardar datos en fichero
				11. Cargar datos en fichero
				12. Guardar datos en base de datos
				13. Cargar datos en base de datos
				14. Salir del menú
				""";
	}
	
	/**
	 * Método para ejecutar el menú principal
	 */
	public void aplicacion() {
		Catalogo catalogo = new Catalogo();
		Ficheros fichero = new Ficheros();
		BasesdeDatos bases = new BasesdeDatos();
		try {
			bases.crearBD();
		} catch (ErrorSQLException e) {
			e.printStackTrace();
		}
		
		boolean correcto = false;
		do {
			System.out.println(menu());
			int opcion = pedirInt("Ingrese una opcion", "Valor no valido");
			try {
				switch(opcion) {
				case 1:
					int id = this.pedirInt("Ingrese el id", "Valor no valido");
					String titulo = this.pedirString("Ingrese el titulo");
					String plataforma = this.pedirString("Ingrese la plataforma");
					double precio = this.pedirDouble("Ingrese el precio", "Valor no valido");
					int stock = this.pedirInt("Ingrese el stock", "Valor no valido");
					String fechaLanzamiento = this.pedirString("Ingrese la fecha de lanzamiento en formato dd/MM/yyyy");
					
					Videojuego juego = new Videojuego(id, titulo, plataforma, precio, stock, fechaLanzamiento);
					catalogo.aniadirElemento(juego);
					break;
				case 2:
					int id1 = this.pedirInt("Ingrese el id", "Valor invalido");
					catalogo.eliminarElemento(id1);
					break;
				case 3:
					String titulo1 = this.pedirString("Ingrese el titulo");
					System.out.println(catalogo.buscarElemento(titulo1).toString());
					break;
				case 4:
					int id2 = this.pedirInt("Ingrese el id", "id no valido");
					System.out.println(catalogo.buscarElemento(id2).toString());
					break;
				case 5:
					double precio1 = this.pedirDouble("Ingrese el precio", "Valor invalido");
					for (Videojuego juego1 : catalogo.filtrarVideojuegosPorPrecio(precio1)) {
						System.out.println(juego1.toString());
					}
					break;
				case 6:
					int id3 = this.pedirInt("Ingrese el id", "Valor invalido");
					boolean descuento = this.pedirBoolean("Ingresar descuento? [true/false]", "Valor invalido");
					if (descuento) {
						int descuento1 = this.pedirInt("Ingrese el descuento", "Valor invalido");
						System.out.println("El precio es: " + catalogo.obtenerPrecioTotalCatalogo(id3, descuento1));
					} else {
						System.out.println("El precio es: " + catalogo.obtenerPrecioTotalCatalogo(id3));		
					}
					break;
				case 7:
					System.out.println(catalogo.mostrarMasCaro());
					break;
				case 8:
					System.out.println(catalogo.calcularPrecioMedio());
					break;
				case 9:
					catalogo.mostrarColeccion();
					break;
				case 10:
					fichero.guardarDatos(catalogo);
					break;
				case 11:
					catalogo = fichero.cargarDatos();
					break;
				case 12:
					bases.insertarLoteVideojuegos(catalogo);
					break;
				case 13:
					catalogo = bases.listarVideojuegos();
					break;
				case 14:
					correcto = true;
					break;
				}
			} catch (DateTimeParseException | IllegalArgumentException | IDnoValidoException
					| PrecionoValidoException | StocknoValidoException | FechanoValidaException 
					| VideojuegoInsercionException | VideojuegoEliminacionException | JuegonoEncontradoException 
					| DescuentonoValidoException | FicheroException | FicheronoExistenteException 
					| ErrorSQLException e) {
				e.printStackTrace();
			}
		} while (!correcto);
	}
	
	/**
	 * Método para probar donde se crea un catalogo donde:
	 * insertara 3 videojuegos
	 * buscar videojuego por titulo
	 * mostrar el videojuego mas caro
	 * calcular el precio medio
	 * Funcionamiento de colecciones
	 * lectura y escritura de ficheros
	 * bases de datos
	 * Excepcion
	 */
	public void prueba() {
		try {
			//Creacion de catalogo
			Catalogo catalogo = new Catalogo();
			Ficheros fichero = new Ficheros();
			BasesdeDatos bases = new BasesdeDatos();
			
			//Insertar 3 juegos
			Videojuego juego1 = new Videojuego(50, "Dark Souls 3", "PC", 70, 7, "25/08/2003");
			Videojuego juego2 = new Videojuego(60, "Mario Kart", "NINTENDO", 40, 4, "26/08/2005");
			Videojuego juego3 = new Videojuego(70, "Gears of War", "XBOX", 60, 6, "05/05/2005");
			catalogo.aniadirElemento(juego1);
			catalogo.aniadirElemento(juego2);
			catalogo.aniadirElemento(juego3);
			
			//Buscar videojuego por titulo
			System.out.println("Buscar juego por titulo (Mario Kart): " + catalogo.buscarElemento("Mario Kart").toString());
			
			//Buscar el videojuego mas caro
			System.out.println("Juego mas caro: " + catalogo.mostrarMasCaro());
			
			//Calcular el precio medio
			System.out.println("Precio medio: " + catalogo.calcularPrecioMedio());
			
			//Funcionamiento de colecciones
			System.out.println("Todos los videojuegos del catalogo:");
			catalogo.mostrarColeccion();
			
			//lectura y escritura de ficheros
			fichero.guardarDatos(catalogo);
			System.out.println("Contenido recuperado del archivo binario");
			fichero.mostrarContenidoRecuperado();
			
			//bases de datos
			bases.crearBD();
			bases.insertarLoteVideojuegos(catalogo);
			catalogo = bases.listarVideojuegos();
			System.out.println("Mostrar catalogo desde la base de datos");
			catalogo.mostrarColeccion();
			
			//Excepcion
			Videojuego juego4 = new Videojuego(50, "Dark Souls 3", "PC", -70, 7, "25/08/2003");
		} catch (DateTimeParseException | IllegalArgumentException | IDnoValidoException | PrecionoValidoException
				| StocknoValidoException | FechanoValidaException | VideojuegoInsercionException 
				| JuegonoEncontradoException | FicheroException | FicheronoExistenteException | ErrorSQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Aplicacion a = new Aplicacion();
		a.prueba();
		//a.aplicacion();
	}
}