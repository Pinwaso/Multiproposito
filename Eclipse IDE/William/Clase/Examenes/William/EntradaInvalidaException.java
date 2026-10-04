package Clase.Examenes.William;

public class EntradaInvalidaException extends Exception {

	public EntradaInvalidaException() {
		super();
	}

	public EntradaInvalidaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntradaInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntradaInvalidaException(String message) {
		super(message);
	}

	public EntradaInvalidaException(Throwable cause) {
		super(cause);
	}
}