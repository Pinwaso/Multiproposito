package GamePlanet.Excepciones;

public class VideojuegoEliminacionException extends Exception {

	public VideojuegoEliminacionException() {
		super();
	}

	public VideojuegoEliminacionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VideojuegoEliminacionException(String message, Throwable cause) {
		super(message, cause);
	}

	public VideojuegoEliminacionException(String message) {
		super(message);
	}

	public VideojuegoEliminacionException(Throwable cause) {
		super(cause);
	}
}