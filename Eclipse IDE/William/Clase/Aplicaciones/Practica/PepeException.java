package Clase.Aplicaciones.Practica;

public class PepeException extends Exception {

	public PepeException() {
		super();
	}

	public PepeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PepeException(String message, Throwable cause) {
		super(message, cause);
	}

	public PepeException(String message) {
		super(message);
	}

	public PepeException(Throwable cause) {
		super(cause);	
	}
}