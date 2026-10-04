package Clase.Examenes.William;

public class ClaseExistenteException extends Exception {

	public ClaseExistenteException() {
		super();
	}

	public ClaseExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClaseExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClaseExistenteException(String message) {
		super(message);
	}

	public ClaseExistenteException(Throwable cause) {
		super(cause);
	}
}