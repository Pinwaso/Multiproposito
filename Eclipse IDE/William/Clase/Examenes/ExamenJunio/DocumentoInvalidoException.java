package Clase.Examenes.ExamenJunio;

public class DocumentoInvalidoException extends Exception {

	public DocumentoInvalidoException() {
		super();
	}

	public DocumentoInvalidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DocumentoInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DocumentoInvalidoException(String message) {
		super(message);
	}

	public DocumentoInvalidoException(Throwable cause) {
		super(cause);
	}
}