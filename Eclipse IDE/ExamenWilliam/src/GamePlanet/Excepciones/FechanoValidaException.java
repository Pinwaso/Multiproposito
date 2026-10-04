package GamePlanet.Excepciones;

public class FechanoValidaException extends Exception {

	public FechanoValidaException() {
		super();
	}

	public FechanoValidaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FechanoValidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public FechanoValidaException(String message) {
		super(message);
	}

	public FechanoValidaException(Throwable cause) {
		super(cause);
	}
}