package GamePlanet.Excepciones;

public class IDnoValidoException extends Exception {

	public IDnoValidoException() {
		super();
	}

	public IDnoValidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IDnoValidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public IDnoValidoException(String message) {
		super(message);
	}

	public IDnoValidoException(Throwable cause) {
		super(cause);
	}
}