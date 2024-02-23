package br.com.joaogabriel.bookstore.config;

import jakarta.persistence.EntityManager;

public class PersistenceUnitMain {
	
	public static void main(String[] args) {
		PersistenceUnitConfig unitConfig = new PersistenceUnitConfig();
		EntityManager entityManager = unitConfig.getEntityManager();
		if( entityManager.isOpen()) {
			System.out.println("Its works!");
		}
	}

}
