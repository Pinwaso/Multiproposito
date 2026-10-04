package GamePlanet.Excepciones;

public class JuegonoEncontradoException extends Exception {

	public JuegonoEncontradoException() {
		super();
	}

	public JuegonoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JuegonoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public JuegonoEncontradoException(String message) {
		super(message);
	}

	public JuegonoEncontradoException(Throwable cause) {
		super(cause);
	}
}