package Clase.Examenes.William;

public class ClaseNoExistenteException extends Exception {

	public ClaseNoExistenteException() {
		super();
	}

	public ClaseNoExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClaseNoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClaseNoExistenteException(String message) {
		super(message);
	}

	public ClaseNoExistenteException(Throwable cause) {
		super(cause);
	}
}