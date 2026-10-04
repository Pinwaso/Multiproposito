package GamePlanet.Excepciones;

public class StocknoValidoException extends Exception {

	public StocknoValidoException() {
		super();
	}

	public StocknoValidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StocknoValidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public StocknoValidoException(String message) {
		super(message);
	}

	public StocknoValidoException(Throwable cause) {
		super(cause);
	}
}