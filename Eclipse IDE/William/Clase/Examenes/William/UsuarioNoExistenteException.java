package Clase.Examenes.William;

public class UsuarioNoExistenteException extends Exception {

	public UsuarioNoExistenteException() {
		super();
	}

	public UsuarioNoExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsuarioNoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioNoExistenteException(String message) {
		super(message);
	}

	public UsuarioNoExistenteException(Throwable cause) {
		super(cause);
	}
}