package br.com.joaogabriel.bookstore.exception;

public class GenericPersistenceException extends RuntimeException {
	private static final long serialVersionUID = 0L;
	
	public GenericPersistenceException(String message, Exception ex) {
		super(message, ex);
	}

}
