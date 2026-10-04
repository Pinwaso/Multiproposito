package Clase.Aplicaciones.GestionBiblioteca;

public class LibroNoEncontradoException extends Exception {

	public LibroNoEncontradoException() {
		super();
	}

	public LibroNoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LibroNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public LibroNoEncontradoException(String message) {
		super(message);
	}

	public LibroNoEncontradoException(Throwable cause) {
		super(cause);
	}
}