package GamePlanet.Excepciones;

public class SaldonoValidoException extends Exception {

	public SaldonoValidoException() {
		super();
	}

	public SaldonoValidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SaldonoValidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public SaldonoValidoException(String message) {
		super(message);
	}

	public SaldonoValidoException(Throwable cause) {
		super(cause);
	}
}