package br.com.joaogabriel.bookstore.exception;

public class PersistenceUnitException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PersistenceUnitException(String message, Exception ex) {
		super(message, ex);
	}

}
