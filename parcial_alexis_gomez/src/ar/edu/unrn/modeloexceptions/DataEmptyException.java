package ar.edu.unrn.modeloexceptions;

public class DataEmptyException extends Exception {
	public DataEmptyException() {
	}

	public DataEmptyException(String message) {
		super("El campo '" + message + "' no puede ser vacio");
	}
}
