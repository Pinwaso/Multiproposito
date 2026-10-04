package GamePlanet;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import GamePlanet.Excepciones.DescuentonoValidoException;
import GamePlanet.Excepciones.FechanoValidaException;
import GamePlanet.Excepciones.IDnoValidoException;
import GamePlanet.Excepciones.PrecionoValidoException;
import GamePlanet.Excepciones.StocknoValidoException;

/**
 * Clase Videojuego donde se estructura un objeto videojuego
 * @version 1.0
 * @autor William Andrés
 */
public class Videojuego implements Vendible, Serializable{
	/**
	 * Identificación único de versión para la serialización de esta clase.
	 */
	private static final long serialVersionUID = 7062289066644016537L;
	/**
	 * id del Videojuego como int
	 */
	private int id;
	/**
	 * titulo del Videojuego como String
	 */
	private String titulo;
	/**
	 * Plataforma del videojuego como lista enumerada Plataforma
	 */
	private Plataforma plataforma;
	/**
	 * precio del Videojuego como double
	 */
	private double precio;
	/**
	 * stock del Videojuego como int
	 */
	private int stock;
	/**
	 * fechaDeLanzamiento del Videojuego como LocalDate
	 */
	private LocalDate fechaDeLanzamiento;
	/**
	 * constante del IVA como int
	 */
	private static final int IVA = 21;
	//No guardar DateTimeFormatter como atributo ya que este no implementa
	//Serializable y por ende, da error en guardar en archivos binarios
	
	/**
	 * Constructor de Videojuego
	 * @param id se le pasa el ID como int
	 * @param titulo se le pasa el titulo como String
	 * @param plataforma se le pasa la plataforma como String (internamente es un ENUM)
	 * @param precio se le pasa el precio como double
	 * @param stock se le pasa el stock como int
	 * @param fechaDeLanzamiento se le pasa la fecha de lanzamiento como Date
	 * @throws IllegalArgumentException lanza una excepción si el valor no coincide con ninguna plataforma
 	 * @throws PrecionoValidoException Excepcion si el precio no es valido 
	 * @throws StocknoValidoException Excepcion si el stock es inferior a 0
	 * @throws FechanoValidaException Excepcion si la fecha de lanzamiento es posterior a la fecha del sistema
	 * @throws DateTimeParseException Excepcion si hubo error en el formato escrito
	 */
	public Videojuego(int id, String titulo, String plataforma, double precio, int stock, String fechaDeLanzamiento) 
	throws IDnoValidoException, IllegalArgumentException, PrecionoValidoException, StocknoValidoException, DateTimeParseException, FechanoValidaException  {
		this.setId(id);
		this.setTitulo(titulo);
		this.setPlataformaString(plataforma);
		this.setPrecio(precio);
		this.setStock(stock);
		this.setFechaDeLanzamientoString(fechaDeLanzamiento);
	}
	
	/**
	 * Constructor de Videojuego sobrecargado
	 * @param id se le pasa el ID como int
	 * @throws IDnoValidoException 
	 * @throws PrecionoValidoException 
	 * @throws StocknoValidoException 
	 * @throws FechanoValidaException 
	 * @throws Exceptio Puede lanzar excepcion de ID invalido, plataforma no valida.
	 */
	public Videojuego(int id) throws IDnoValidoException, IllegalArgumentException, PrecionoValidoException, StocknoValidoException, FechanoValidaException {
		this.setId(id);
		this.setTitulo(null);
		this.setPlataformaString(null);
		this.setPrecio(0);
		this.setStock(0);
		this.setFechaDeLanzamiento(null);
	}
	
	/**
	 * Método para obtener el id
	 * @return devuelve el id como int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Método para esteblecer el id
	 * @param id se le pasa el id como int
	 */
	private void setId(int id) throws IDnoValidoException {
		if (id < 0) {
			throw new IDnoValidoException("El id no puede ser negativo");
		}
		this.id = id;
	}
	
	/**
	 * Método para obtener el titulo
	 * @return devuelve el titulo como String
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Método para establecer el titulo
	 * @param titulo se le pasa el titulo como String
	 */
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Método para obtener la plataforma
	 * @return devuelve la plataforma como String
	 */
	public String getPlataformaString() {
		return plataforma.name();
	}
	/**
	 * Método para obtener la plataforma
	 * @return devuelve la plataforma como lista enumerada Plataforma
	 */
	public Plataforma getPlataforma() {
		return plataforma;
	}
	/**
	 * Método para establecer la plataforma
	 * @param plataforma se le pasa la plataforma como String
	 * @throws IllegalArgumentException lanza una excepción si el valor no coincide con ninguna plataforma
	 */
	private void setPlataformaString(String plataforma) throws IllegalArgumentException {
		this.plataforma = Plataforma.valueOf(plataforma.toUpperCase());
	}
	/**
	 * Método para establecer la plataforma del Videojuego
	 * @param plataforma se le pasa la plataforma como un valor de la lista enumerada Plataforma
	 */
	private void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	/**
	 * Método para obtener el precio
	 * @return devuelve el precio como un double
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * Método para establecer el precio
	 * @param precio se le pasa el precio como double
	 * @throws PrecionoValidoException Excepcion si el precio es inferior a 0
	 */
	private void setPrecio(double precio) throws PrecionoValidoException {
		if (precio < 0) {
			throw new PrecionoValidoException("El precio no puede ser inferior a 0");
		}
		this.precio = precio;
	}
	
	/**
	 * Método para obtener el stock
	 * @return devuelve el stock como int
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * Método para establecer el stock
	 * @param stock se le pasa el stock como int
	 * @throws StocknoValidoException Excepcion si el stock es inferior a 0
	 */
	private void setStock(int stock) throws StocknoValidoException {
		if (stock < 0) {
			throw new StocknoValidoException("El stock no puede ser negativo");
		}
		this.stock = stock;
	}
	
	/**
	 * Método para obtener la fecha de lanzamiento
	 * @return devuelve la fecha de lanzamiento como LocalDate
	 */
	public LocalDate getFechaDeLanzamiento() {
		return fechaDeLanzamiento;
	}
	
	/**
	 * Método para devolver la fecha de lanzamiento con formato
	 * @return Devuelve la fecha de lanzamiento en formato en String
	 */
	public String getFechaDeLanzamientoString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.getFechaDeLanzamiento().format(formato);
	}
	
	/**
	 * Método para establecer la fecha de lanzamiento
	 * @param fechaDeLanzamiento se le pasa la fecha de lanzamiento como LocalDate
	 * @throws FechanoValidaException Excepcion si la fecha de lanzamiento es posterior a la fecha del sistema
	 */
	private void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) throws FechanoValidaException {
		if (fechaDeLanzamiento.isAfter(LocalDate.now())) {
			throw new FechanoValidaException("La fecha debe ser anterior a la actual");
		}
		this.fechaDeLanzamiento = fechaDeLanzamiento;
	}
	
	/**
	 * Método para establecer la fecha de lanzamiento
	 * @param fechaDeLanzamiento se le pasa la fecha de lanzamiento como String en formato
	 * @throws DateTimeParseException Excepcion si hubo error en el formato escrito
	 * @throws FechanoValidaException Excepcion si la fecha de lanzamiento es posterior a la fecha del sistema
	 */
	private void setFechaDeLanzamientoString(String fechaDeLanzamiento) throws DateTimeParseException, FechanoValidaException {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.setFechaDeLanzamiento(LocalDate.parse(fechaDeLanzamiento, formato));
	}
	
	/**
	 * Método para obtener el IVA
	 * @return devuelve el IVA como int
	 */
	public static int getIva() {
		return IVA;
	}
	
	/**
	 * Método para devolver todo los atributos de Videojuego en una String 
	 */
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Videojuego [id=" + id + ", titulo=" + titulo + ", plataforma=" + plataforma + ", precio=" + precio
				+ ", stock=" + stock + ", fechaDeLanzamiento=" + fechaDeLanzamiento.format(formato) + "]";
	}
	
	/**
	 * Método para aplicar descuento
	 * @param descuento se le pasa el descuento a aplicar como int, debe ser entre 1 y 10
	 * @return devuelve un double del precio con el descuento aplicado
	 * @throws DescuentonoValidoException Excepcion si el descuento esta fuera de rango
	 * @throws PrecionoValidoException Excepcion si el precio es inferior a 0
	 */
	private double aplicarDescuento(int descuento) throws DescuentonoValidoException, PrecionoValidoException {
		if (descuento < 1 | descuento > 10) {
			throw new DescuentonoValidoException("El descuento debe ser a lo sumo 10%");
		}
		double salida = this.precio - (this.precio * descuento / 100);
		this.setPrecio(salida);
		return this.getPrecio();
	}
	
	/**
	 * Método para aplicar descuento del 10%
	 * @return devuelve un double del precio con el descuento aplicado
	 * @throws PrecionoValidoException Excepcion si el precio es inferior a 0
	 * @throws DescuentonoValidoException 
	 */
	private double aplicarDescuento() throws PrecionoValidoException, DescuentonoValidoException {
		//double salida = this.precio - (this.precio * 10 / 100);
		//this.setPrecio(salida);
		//return this.getPrecio();
		return aplicarDescuento(10);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaDeLanzamiento, id, plataforma, precio, stock, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(fechaDeLanzamiento, other.fechaDeLanzamiento)
				&& id == other.id && plataforma == other.plataforma
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock
				&& Objects.equals(titulo, other.titulo);
	}

	/**
	 * Método para calcular el precio final de un Videojuego
	 * @return devuelve el precio final luego de aplicar descuento del 10% e IVA
	 * @throws DescuentonoValidoException Excepcion si el descuento no es valido
	 * @throws PrecionoValidoException Excepcion si el precio no es valido
	 */
	@Override
	public double calcularPrecioFinal() throws DescuentonoValidoException, PrecionoValidoException{
		return this.calcularPrecioFinal(10);
	}
	
	/**
	 * Método para calcular el precio final de un Videojuego
	 * @param descuento se le pasa el descuento para aplicar
	 * @return devuelve el precio final luego de aplicar descuento e IVA
	 * @throws DescuentonoValidoException Excepcion si el descuento no es valido
	 * @throws PrecionoValidoException Excepcion si el precio no es valido
	 */
	public double calcularPrecioFinal(int descuento) throws DescuentonoValidoException, PrecionoValidoException {
		double salida = this.aplicarDescuento(descuento);
		this.setPrecio(salida + (salida * this.getIva() / 100));
		return this.getPrecio();
	}
}