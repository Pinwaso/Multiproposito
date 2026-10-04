package GamePlanet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

import GamePlanet.Excepciones.DescuentonoValidoException;
import GamePlanet.Excepciones.JuegonoEncontradoException;
import GamePlanet.Excepciones.PrecionoValidoException;
import GamePlanet.Excepciones.VideojuegoEliminacionException;
import GamePlanet.Excepciones.VideojuegoInsercionException;

public class Catalogo implements Serializable{
	/**
	 * Identificación único de versión para la serialización de esta clase.
	 */
	private static final long serialVersionUID = -1278341824364750065L;
	/**
	 * Colección TreeSet de Videojuegos
	 */
	private TreeSet<Videojuego> listado;
	
	/**
	 * Contructor de catalogo donde se inicializa el TreeSet con el comparador por defecto
	 */
	public Catalogo() {
		listado = new TreeSet<>(new ComparadorDefecto());
	}

	/**
	 * Método para obtener el listado de Videojuegos
	 * @return devuelve una colección TreeSet con Videojuego
	 */
	public TreeSet<Videojuego> getListado() {
		return listado;
	}

	/**
	 * Método para establecer el listado de videojuegos
	 * @param listado se le pasa una colección TreeSet de Videojuegos
	 */
	private void setListado(TreeSet<Videojuego> listado) {
		this.listado = listado;
	}
	
	/**
	 * Método para añadir un Videojuego al listado
	 * @param juego Se le pasa un videojuego como objeto de tipo Videojuego
	 * @throws VideojuegoInsercionException Excepcion por si hubo error al añadir el Videojuego
	 */
	public void aniadirElemento(Videojuego juego) throws VideojuegoInsercionException {
		if(!listado.add(juego)) {
			throw new VideojuegoInsercionException("Error al añadir el Videojuego");
		}
	}
	
	/**
	 * Método para eliminar un videojuego del listado
	 * @param juego se le pasa un videojuego como objeto de tipo Videojuego
	 * @throws VideojuegoEliminacionException Excepcion por si hubo error al eliminar el Videojuego
	 * @throws JuegonoEncontradoException Excepcion si no encuentra el videojuego
	 */
	public void eliminarElemento(int id) throws VideojuegoEliminacionException, JuegonoEncontradoException {
		Videojuego juego = this.buscarElemento(id);
		if(!listado.remove(juego)) {
			throw new VideojuegoEliminacionException("Error al eliminar el Videojuego");
		}
	}
	
	/**
	 * Método para buscar un Videojuego por id
	 * @param id se le pasa el id del Videojuego como int
	 * @return devuelve un objeto Videojuego
	 * @throws JuegonoEncontradoException Exception si no encuentra el Videojuego
	 */
	public Videojuego buscarElemento(int id) throws JuegonoEncontradoException {
		Videojuego salida = null;
		for (Videojuego juego : listado) {
			if (id == juego.getId()) {
				salida = juego;
				break;
			}
		}
		if (salida == null) {
			throw new JuegonoEncontradoException("Juego no encontrado");
		}
		return salida;
	}
	
	/**
	 * Método para buscar un Videojuego por titulo
	 * @param titulo se le pasa el titulo del videojuego como String
	 * @return devuelve un objeto Videojuego
	 * @throws JuegonoEncontradoException Exception si no encuentra el Videojuego
	 */
	public Videojuego buscarElemento(String titulo) throws JuegonoEncontradoException {
		Videojuego salida = null;
		for (Videojuego juego : listado) {
			if (titulo.equals(juego.getTitulo())) {
				salida = juego;
				break;
			}
		}
		if (salida == null) {
			throw new JuegonoEncontradoException("Juego no encontrado");
		}
		return salida;
	}
	
	/**
	 * Método para mostrar por pantalla todos los datos de todos los Videojuegos del listado
	 */
	public void mostrarColeccion() {
		for (Videojuego juego : listado) {
			System.out.println(juego.toString());
		}
	}
	
	/**
	 * Método para calcular el precio medio del listado de Videojuegos
	 * @return devuelve el precio medio como un double
	 */
	public double calcularPrecioMedio() {
		double salida = 0D;
		int contador = 0;
		for (Videojuego juego : listado) {
			salida+= juego.getPrecio();
			contador++;
		}
		return salida / contador;
	}
	
	/**
	 * Método para obtener el Videojuego mas caro del listado
	 * @return Devuelve un String con el Videojuego mas caro del listado
	 */
	public String mostrarMasCaro() {
		double precioMaximo = Integer.MIN_VALUE;
		ArrayList<Videojuego> coleccion = new ArrayList<Videojuego>();
		for (Videojuego juego : listado) {
			if (juego.getPrecio() == precioMaximo) {
				coleccion.add(juego);
			}
			if (juego.getPrecio() > precioMaximo) {
				coleccion = new ArrayList<Videojuego>();
				coleccion.add(juego);
				precioMaximo = juego.getPrecio();	
			}
		}
		String salida = "";
		for (Videojuego juego : coleccion) {
			salida+= juego.toString() + "\n";
		}
		return salida;
	}
	
	/**
	 * Método para obtener el precio final de un Videojuego
	 * @param id se le pasa el id del Videojuego como int
	 * @param descuento se le pasa el descuento a aplicar como int
	 * @return devuelve el precio final del videojuego como double luego de aplicar el descuento e IVA
	 * @throws JuegonoEncontradoException Exception si no se encontro el videojuego
	 * @throws DescuentonoValidoException Exception si el descuento no es valido
	 * @throws PrecionoValidoException Exception si el precio no es valido
	 */
	public double obtenerPrecioTotalCatalogo(int id, int descuento) throws JuegonoEncontradoException, DescuentonoValidoException, PrecionoValidoException {
		Videojuego salida = this.buscarElemento(id);
		return salida.calcularPrecioFinal(descuento);
	}
	
	/**
	 * Método para obtener el precio final de un videojuego
	 * @param id se le pasa el id del videojuego como int
	 * @return devuelve el precio final del videojuego como double luego de aplicar el 10% de descuento e IVA
	 * @throws JuegonoEncontradoException Exception si no se encontro el videojuego
	 * @throws DescuentonoValidoException Exception si el descuento no es valido
	 * @throws PrecionoValidoException Exception si el precio no es valido
	 */
	public double obtenerPrecioTotalCatalogo(int id) throws JuegonoEncontradoException, DescuentonoValidoException, PrecionoValidoException {
		Videojuego salida = this.buscarElemento(id);
		return salida.calcularPrecioFinal();
	}
	
	/**
	 * Método para filtrar Videojuegos por precio
	 * @param precio se le pasa el precio para filtrar como double
	 * @return Devuelve un ArrayList de Videojuegos
	 * @throws PrecionoValidoException Excepcion si el precio es inferior a 0
	 */
	public ArrayList<Videojuego> filtrarVideojuegosPorPrecio(double precio) throws PrecionoValidoException {
		if (precio < 0) {
			throw new PrecionoValidoException("El precio no debe ser inferior a 0");
		}
		ArrayList<Videojuego> salida = new ArrayList<>();
		for(Videojuego juego : listado) {
			if (precio < juego.getPrecio()) {
				salida.add(juego);
			}
		}
		return salida;
	}
}