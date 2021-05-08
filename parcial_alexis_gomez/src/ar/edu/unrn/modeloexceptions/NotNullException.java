package ar.edu.unrn.modeloexceptions;

public class NotNullException extends Exception {
	public NotNullException() {
	}

	public NotNullException(String message) {
		super("El campo '" + message + "' no puede ser nulo");
	}
}
