package GamePlanet.Excepciones;

public class PrecionoValidoException extends Exception {

	public PrecionoValidoException() {
		super();
	}

	public PrecionoValidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PrecionoValidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrecionoValidoException(String message) {
		super(message);
	}

	public PrecionoValidoException(Throwable cause) {
		super(cause);
	}
}