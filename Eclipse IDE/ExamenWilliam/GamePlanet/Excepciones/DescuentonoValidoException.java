package GamePlanet.Excepciones;

public class DescuentonoValidoException extends Exception {

	public DescuentonoValidoException() {
		super();
	}

	public DescuentonoValidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DescuentonoValidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DescuentonoValidoException(String message) {
		super(message);
	}

	public DescuentonoValidoException(Throwable cause) {
		super(cause);
	}
}