package GamePlanet.Excepciones;

public class VideojuegoInsercionException extends Exception {

	public VideojuegoInsercionException() {
		super();
	}

	public VideojuegoInsercionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VideojuegoInsercionException(String message, Throwable cause) {
		super(message, cause);
	}

	public VideojuegoInsercionException(String message) {
		super(message);
	}

	public VideojuegoInsercionException(Throwable cause) {
		super(cause);
	}
}