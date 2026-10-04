package Clase.Aplicaciones.ficheros;

public class FicheroNuloException extends Exception {

	public FicheroNuloException() {
	}

	public FicheroNuloException(String message) {
		super(message);
	}

	public FicheroNuloException(Throwable cause) {
		super(cause);
	}

	public FicheroNuloException(String message, Throwable cause) {
		super(message, cause);
	}

	public FicheroNuloException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}