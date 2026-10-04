package GamePlanet;

import java.io.Serializable;

import GamePlanet.Excepciones.CorreonoValidoException;
import GamePlanet.Excepciones.JuegoExistenteException;
import GamePlanet.Excepciones.JuegonoEncontradoException;
import GamePlanet.Excepciones.SaldoInsuficienteException;
import GamePlanet.Excepciones.SaldonoValidoException;
import GamePlanet.Excepciones.VideojuegoInsercionException;

/**
 * Clase cliente que hereda de Persona
 * @version 1.0
 * @author William Andrés
 */
public class Cliente extends Persona implements Serializable{
	/**
	 * Identificación único de versión para la serialización de esta clase.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * dni del cliente como String
	 */
	private String dni;
	/**
	 * correo del cliente como String
	 */
	private String correo;
	/**
	 * saldo del cliente como double
	 */
	private double saldo;
	/**
	 * catalogo del cliente como objeto de tipo Catalogo
	 */
	private Catalogo catalogo;
	
	/**
	 * Constructor de la clase Cliente a su clase padre Persona
	 * @param nombre se le pasa el nombre como String
	 * @param edad se le pasa la edad como int
	 * @param dni se le pasa el dni como String
	 * @param correo se le pasa el correo como String
	 * @param saldo se le pasa el saldo como double
	 * @param catalogo se le pasa el catalogo como objeto de tipo Catalogo
	 * @throws CorreonoValidoException Excepcion si el correo no es valido
	 */
	public Cliente(String nombre, int edad, String dni, String correo, double saldo, Catalogo catalogo) throws CorreonoValidoException {
		super(nombre, edad);
		this.setDni(dni);
		this.setCorreo(correo);
		this.setSaldo(saldo);
		this.setCatalogo(catalogo);
	}
	
	/**
	 * Método para obtener el dni
	 * @return devuelve el dni como String
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Método para establecer el dni
	 * @param dni se le pasa el dni como String
	 */
	private void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Método para obtener el correo
	 * @return devuelve el correo como String
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Método para establecer el correo
	 * @param correo se le pasa el correo como String
	 * @throws CorreonoValidoException Excepcion si el correo no es valido
	 */
	private void setCorreo(String correo) throws CorreonoValidoException {
		if (!correo.matches("^[A-Za-z0-9]+@[A-Za-z]+\\.com$")) {
			throw new CorreonoValidoException("Correo no valido");
		}
		this.correo = correo;
	}

	/**
	 * Método para obtener el saldo
	 * @return devuelve el saldo como double
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Método para establecer el saldo
	 * @param saldo se le pasa el saldo como double
	 */
	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * Método para  obtener el catalogo
	 * @return Devuelve el objeto Catalogo
	 */
	public Catalogo getCatalogo() {
		return catalogo;
	}

	/**
	 * Método para establecer el catalogo
	 * @param catalogo se le pasa el catalogo como objeto de tipo Catalogo
	 */
	private void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	/**
	 * Método para mostrar todos los datos de cliente, devuelve un String con todos sus atributos
	 */
	@Override
	public String mostrarDatos() {
		return "Cliente Nombre: " + this.getNombre() + " edad: " + this.getEdad() + " dni: " + this.getDni()
		+ " correo: " + this.getCorreo() + " saldo: " + this.getSaldo();
	}

	/**
	 * Método para recargar el saldo del cliente
	 * @param cantidad se le pasa la cantidad que se recargará como double
	 * @throws SaldonoValidoException Excepción por si la cantidad es negativa
	 */
	public void recargarSaldo(double cantidad) throws SaldonoValidoException {
		if (cantidad < 0) {
			throw new SaldonoValidoException("El saldo debe ser mayor a 0");
		}
		this.setSaldo(this.getSaldo() + cantidad);
	}
	
	/**
	 * Método para añadir un Videojuego, debe tener saldo suficiente y que no este repetido en el listado
	 * @param juego Se le pasa el Videojuego como objeto Videojuego
	 * @throws SaldoInsuficienteException Excepcion si el saldo es insuficiente para comprar el Videojuego
	 * @throws JuegoExistenteException Excepcion si el Videojuego ya existe en el listado
	 * @throws VideojuegoInsercionException Excepcion si hubo algun error en insertar el Videojuego en el listado
	 * @throws JuegonoEncontradoException 
	 */
	public void comprarJuego(Videojuego juego) throws SaldoInsuficienteException, JuegoExistenteException, VideojuegoInsercionException, JuegonoEncontradoException {
		if (this.getSaldo() < juego.getPrecio()) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		if (catalogo.buscarElemento(juego.getId()) != null) {
			throw new JuegoExistenteException("El juego ya existe");
		}
		this.setSaldo(this.getSaldo() - juego.getPrecio());
		catalogo.aniadirElemento(juego);
	}
}