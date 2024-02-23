package br.com.joaogabriel.bookstore.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.joaogabriel.bookstore.exception.PersistenceUnitException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUnitConfig {
	
	private final Logger logger = Logger.getLogger(PersistenceUnitConfig.class.getName());
	
	private EntityManagerFactory entityManagerFactory = null;
	
	public PersistenceUnitConfig() {
		createEntityManagerFactory();
	}
	
	private EntityManagerFactory createEntityManagerFactory() {
		try {
			this.entityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
			return this.entityManagerFactory;
		} catch (Exception exception) {
			logger.log(Level.SEVERE, "Unable to create entity manager factory.");
			exception.printStackTrace();
			throw new PersistenceUnitException(exception.getMessage(), exception);
		}
	}
	
	public EntityManager getEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}

}
