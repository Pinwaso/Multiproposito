package GamePlanet.Excepciones;

public class CorreonoValidoException extends Exception {

	public CorreonoValidoException() {
		super();
	}

	public CorreonoValidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CorreonoValidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CorreonoValidoException(String message) {
		super(message);
	}

	public CorreonoValidoException(Throwable cause) {
		super(cause);
	}
}