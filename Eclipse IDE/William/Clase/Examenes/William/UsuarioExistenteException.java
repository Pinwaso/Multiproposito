package Clase.Examenes.William;

public class UsuarioExistenteException extends Exception {

	public UsuarioExistenteException() {
		super();
	}

	public UsuarioExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsuarioExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioExistenteException(String message) {
		super(message);
	}

	public UsuarioExistenteException(Throwable cause) {
		super(cause);
	}
}