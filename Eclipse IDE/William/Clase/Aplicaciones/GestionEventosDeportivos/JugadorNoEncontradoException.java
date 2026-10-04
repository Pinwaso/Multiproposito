package Clase.Aplicaciones.GestionEventosDeportivos;

public class JugadorNoEncontradoException extends Exception {

	public JugadorNoEncontradoException() {
		super();
	}

	public JugadorNoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JugadorNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public JugadorNoEncontradoException(String message) {
		super(message);
	}

	public JugadorNoEncontradoException(Throwable cause) {
		super(cause);
	}
}