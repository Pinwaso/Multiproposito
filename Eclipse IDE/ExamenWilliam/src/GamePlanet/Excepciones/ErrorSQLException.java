package GamePlanet.Excepciones;

public class ErrorSQLException extends Exception {

	public ErrorSQLException() {
		super();
	}

	public ErrorSQLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ErrorSQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public ErrorSQLException(String message) {
		super(message);
	}

	public ErrorSQLException(Throwable cause) {
		super(cause);
	}
}