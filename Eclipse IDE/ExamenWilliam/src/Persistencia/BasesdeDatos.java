package Persistencia;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import GamePlanet.Catalogo;
import GamePlanet.Videojuego;
import GamePlanet.Excepciones.ErrorSQLException;
import GamePlanet.Excepciones.FechanoValidaException;
import GamePlanet.Excepciones.IDnoValidoException;
import GamePlanet.Excepciones.PrecionoValidoException;
import GamePlanet.Excepciones.StocknoValidoException;
import GamePlanet.Excepciones.VideojuegoInsercionException;
/**
 * Clase donde se estructuran metodos de guardado y salvado en bases de datos
 * @version 1.0
 * @author William Andrés
 */
public class BasesdeDatos {
	/**
	 * usuario de la base de datos
	 */
	private String user = "root";
	/**
	 * contraseña de la base de datos
	 */
	private String pwd = "";
	/**
	 * URL para conectarse a la base de datos (raíz)
	 */
	private String url = "jdbc:mariadb://localhost/";
	/**
	 * URL para conectarse a la base de datos gameplanet
	 */
	private String gameplanet = "jdbc:mariadb://localhost/gameplanet";
	
	/**
	 * Método para crear la base de datos gameplanet junto con su tabla para guardar Videojuegos
	 * @throws ErrorSQLException Excepcion si hubo error en la conexion o consulta
	 */
	public void crearBD() throws ErrorSQLException {
		try (Connection conex = DriverManager.getConnection(url, user, pwd);
			Statement state = conex.createStatement();)
		{
			String query = "CREATE OR REPLACE DATABASE gameplanet";
			state.executeUpdate(query);
			query = "USE gameplanet";
			state.executeUpdate(query);
			query = """
					CREATE TABLE videojuegos (
						id INT PRIMARY KEY,
						titulo VARCHAR(100) NOT NULL,
						plataforma VARCHAR(50),
						precio DECIMAL(10,2),
						stock INT,
						fecha_lanzamiento DATE
					)
					""";
			state.executeUpdate(query);
		} catch (SQLException e) {
			throw new ErrorSQLException("Error en la consulta");
		}
	}
	
	/**
	 * Método para insertar un videojuego en la base de datos
	 * @param juego se le pasa un videojuego como objeto de tipo Videojuego
	 * @throws ErrorSQLException Excepcion si hubo error de conexion o consulta
	 */
	public void insertarVideojuego(Videojuego juego) throws ErrorSQLException {
		String query = """
				INSERT INTO videojuegos(id, titulo, plataforma, precio, stock, fecha_lanzamiento)
				VALUES(?, ?, ?, ?, ?, ?)
				""";
		try (Connection conex = DriverManager.getConnection(gameplanet, user, pwd);
			PreparedStatement state = conex.prepareStatement(query);)
		{
			state.setInt(1, juego.getId());
			state.setString(2, juego.getTitulo());
			state.setString(3, juego.getPlataformaString());
			state.setDouble(4, juego.getPrecio());
			state.setInt(5, juego.getStock());
			state.setObject(6, juego.getFechaDeLanzamiento());
			state.executeUpdate();
		} catch (SQLException e) {
			throw new ErrorSQLException("Error en la consulta");
		}
	}
	
	/**
	 * Método para cargar todos los videojuegos de la base de datos
	 * @return devuelve un catalogo como objeto de tipo Catalogo con todos los videojuegos
	 * @throws ErrorSQLException Excepcion si hubo error de conexion o consulta
	 * @throws DateTimeParseException Excepcion si hubo error al formato de fecha
	 * @throws IllegalArgumentException lanza una excepción si el valor no coincide con ninguna plataforma
	 * @throws IDnoValidoException Excepcion si el id es inferior a 0
	 * @throws PrecionoValidoException Excepcion si el precio es inferior a 0
	 * @throws StocknoValidoException Excepcion si el stock es inferior a 0
	 * @throws FechanoValidaException Excepcion si la fecha de lanzamiento es posterior a la fecha del sistema
	 * @throws VideojuegoInsercionException Excepcion por si hubo error al añadir el Videojuego
	 */
	public Catalogo listarVideojuegos() throws ErrorSQLException, DateTimeParseException, 
	IllegalArgumentException, IDnoValidoException, PrecionoValidoException, StocknoValidoException, 
	FechanoValidaException, VideojuegoInsercionException {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Catalogo salida = null;
		String query = """
				SELECT id, titulo, plataforma, precio, stock, fecha_lanzamiento
				FROM videojuegos
				""";
		try (Connection conex = DriverManager.getConnection(gameplanet, user, pwd);
			Statement state = conex.createStatement();
			ResultSet resultado = state.executeQuery(query);)
		{
			while (resultado.next()) {
				int id = resultado.getInt(1);
				String titulo = resultado.getString(2);
				String plataforma = resultado.getString(3);
				double precio = resultado.getDouble(4);
				int stock = resultado.getInt(5);
				LocalDate fechaLanzamiento = resultado.getObject(6, LocalDate.class);
				Videojuego ejemplo = new Videojuego(id, titulo, plataforma, precio, stock, fechaLanzamiento.format(formato));
				salida.aniadirElemento(ejemplo);
			}
		} catch (SQLException e) {
			throw new ErrorSQLException("Error en la consulta");
		}
		return salida;
	}
	
	/**
	 * Método para actualizar el stock del videojuego en la base de datos
	 * @param juego se le pasa el videojuego como objeto de tipo Videojuego
	 * @throws ErrorSQLException Excepcion si hubo error de conexion, consulta o juego inexistente
	 */
	public void actualizarStock(Videojuego juego) throws ErrorSQLException {
		String query = """
				UPDATE videojuegos
				SET stock = ?
				WHERE id = ?
				""";
		try (Connection conex = DriverManager.getConnection(gameplanet, user, pwd);
			PreparedStatement state = conex.prepareStatement(query);
			)
		{
			state.setInt(1, juego.getStock());
			state.setInt(2, juego.getId());
			int filasAfectadas = state.executeUpdate();
			if (filasAfectadas == 0) {
				throw new ErrorSQLException("El juego no existe");
			}	
		} catch (SQLException e) {
			throw new ErrorSQLException("Error en la consulta");
		}
	}
	
	/**
	 * Método para eliminar un videojuego en la base de datos
	 * @param juego se le pasa un juego como objeto de tipo Videojuego
	 * @throws ErrorSQLException Excepcion si hubo error de conexion, consulta o videojuego inexistente
	 */
	public void eliminarVideojuego(Videojuego juego) throws ErrorSQLException {
		String query = "DELETE FROM videojuegos WHERE id = ?";
		try (Connection conex = DriverManager.getConnection(gameplanet, user, pwd);
			PreparedStatement state = conex.prepareStatement(query);)
		{
			state.setInt(1, juego.getId());
			int filasAfectadas = state.executeUpdate();
			if (filasAfectadas == 0) {
				throw new ErrorSQLException("El juego no existe");
			}
		} catch (SQLException e) {
			throw new ErrorSQLException("Error en la conexion");
		}
	}
	
	/**
	 * Método para insertar videojuegos por lotes en la base de datos
	 * @param catalogo se le pasa el catalogo como objeto de tipo Catalogo
	 * @throws ErrorSQLException Excepcion si hubo error en la conexion o consulta
	 */
	public void insertarLoteVideojuegos(Catalogo catalogo) throws ErrorSQLException {
		String query = """
				INSERT INTO videojuegos(id, titulo, plataforma, precio, stock, fecha_lanzamiento)
				VALUES(?, ?, ?, ?, ?, ?)
				""";
		try {
			Connection conex = DriverManager.getConnection(gameplanet, user, pwd);
			try (PreparedStatement state = conex.prepareStatement(query);) {
				conex.setAutoCommit(false);
				for (Videojuego juego : catalogo.getListado()) {
					state.setInt(1, juego.getId());
					state.setString(2, juego.getTitulo());
					state.setString(3, juego.getPlataformaString());
					state.setDouble(4, juego.getPrecio());
					state.setInt(5, juego.getStock());
					state.setObject(6, juego.getFechaDeLanzamiento());
					state.addBatch();
					conex.commit();
				}
				state.executeBatch();
			} catch (SQLException e) {
				conex.rollback();
				throw new ErrorSQLException("Error en la consulta");
			}
		} catch (SQLException e) {
			throw new ErrorSQLException("Error en la conexion");
		}
	}
}