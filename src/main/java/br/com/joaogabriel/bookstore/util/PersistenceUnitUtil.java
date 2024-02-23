package br.com.joaogabriel.bookstore.util;

import br.com.joaogabriel.bookstore.config.PersistenceUnitConfig;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class PersistenceUnitUtil implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		new PersistenceUnitConfig().getEntityManager();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		EntityManager entityManager = new PersistenceUnitConfig().getEntityManager();
		entityManager.close();
	}

}
