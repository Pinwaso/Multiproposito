package GamePlanet.Excepciones;

public class FicheronoExistenteException extends Exception {

	public FicheronoExistenteException() {
		super();
	}

	public FicheronoExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FicheronoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public FicheronoExistenteException(String message) {
		super(message);
	}

	public FicheronoExistenteException(Throwable cause) {
		super(cause);
	}
}