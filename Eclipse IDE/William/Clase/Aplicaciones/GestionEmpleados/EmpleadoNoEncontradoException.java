package Clase.Aplicaciones.GestionEmpleados;

public class EmpleadoNoEncontradoException extends Exception {

	public EmpleadoNoEncontradoException() {
		super();
	}

	public EmpleadoNoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmpleadoNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmpleadoNoEncontradoException(String message) {
		super(message);
	}

	public EmpleadoNoEncontradoException(Throwable cause) {
		super(cause);
	}
}