package GamePlanet.Excepciones;

public class JuegoExistenteException extends Exception {

	public JuegoExistenteException() {
		super();
	}

	public JuegoExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JuegoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public JuegoExistenteException(String message) {
		super(message);
	}

	public JuegoExistenteException(Throwable cause) {
		super(cause);
	}
}