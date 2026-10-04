package Clase.Examenes.William;

public class EdadInvalidaException extends Exception {

	public EdadInvalidaException() {
		super();
	}

	public EdadInvalidaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EdadInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public EdadInvalidaException(String message) {
		super(message);
	}

	public EdadInvalidaException(Throwable cause) {
		super(cause);
	}
}