package Clase.Examenes.William;

public class NotaInvalidaException extends Exception {

	public NotaInvalidaException() {
		super();
	}

	public NotaInvalidaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotaInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotaInvalidaException(String message) {
		super(message);
	}

	public NotaInvalidaException(Throwable cause) {
		super(cause);
	}
}