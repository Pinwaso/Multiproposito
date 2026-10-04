package Clase.Aplicaciones.EjemploBiblioteca;

public class ExceptionTamano extends Exception {
 

	private static final long serialVersionUID = 3099372231640182984L;
	static int tamanoMaximo=50;
	public ExceptionTamano() {
		// TODO Auto-generated constructor stub
	}

	public ExceptionTamano(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionTamano(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionTamano(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionTamano(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage()+" tamaño maximo "+tamanoMaximo+" MB";
	}

	
	
}
