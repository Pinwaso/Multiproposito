package GamePlanet.Excepciones;

public class FicheroException extends Exception {

	public FicheroException() {
		super();
	}

	public FicheroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FicheroException(String message, Throwable cause) {
		super(message, cause);
	}

	public FicheroException(String message) {
		super(message);
	}

	public FicheroException(Throwable cause) {
		super(cause);
	}
}