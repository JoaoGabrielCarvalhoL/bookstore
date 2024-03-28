package br.com.joaogabriel.bookstore.dao.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.joaogabriel.bookstore.config.PersistenceUnitConfig;
import br.com.joaogabriel.bookstore.dao.CrudDao;
import br.com.joaogabriel.bookstore.dao.Ordering;
import br.com.joaogabriel.bookstore.exception.GenericPersistenceException;
import br.com.joaogabriel.bookstore.exception.QueryFilterException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 * @param <T>  Type of entity.
 * @param <ID> ID of entity.
 */
public abstract class SimpleGenericDao<T, ID> implements CrudDao<T, ID> {

	private EntityManager entityManager = PersistenceUnitConfig.getInstance().getEntityManager();
	private Class<T> domainClass;
	private Logger logger;
	private char firstElement;
	private String entityName;

	/**
	 * @param Class<T> It is necessary to inform the class of the entity.
	 */
	public SimpleGenericDao(Class<T> classe) {
		this.domainClass = classe;
		this.logger = Logger.getLogger(domainClass.getName());
		firstElement = domainClass.getSimpleName().charAt(0);
		entityName = domainClass.getSimpleName();
		System.out.println(domainClass);
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public T save(T type) {
		logger.log(Level.INFO, "Saving entity into database.");

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(type);
			entityManager.getTransaction().commit();
			return type;
		} catch (Exception exception) {
			logger.log(Level.SEVERE, "Unable to save object to database.");
			throw new GenericPersistenceException(genericMessage(exception), exception);
		}
	}

	@Override
	public T update(T type) {
		try {
			this.entityManager.getTransaction().begin();
			boolean contains = this.entityManager.contains(type);
			if (contains) {
				this.entityManager.refresh(type);
				this.entityManager.getTransaction().commit();
			} else {
				save(type);
			}
			return type;
		} catch (Exception exception) {
			logger.log(Level.SEVERE, "Unable to update object to database.");
			throw new GenericPersistenceException(genericMessage(exception), exception);
		}

	}

	@Override
	public void delete(ID id) {
		try {
			this.entityManager.getTransaction().begin();
			T existing = this.entityManager.find(domainClass, id);
			if (existing == null) return;
			this.entityManager.remove(existing);
			this.entityManager.getTransaction().commit();
		} catch (Exception exception) {
			logger.log(Level.SEVERE, "Unable to update object to database.");
			throw new GenericPersistenceException(genericMessage(exception), exception);
		}
	}

	@Override
	public Collection<T> findAll() {
		String search = String.format("Select %s from %s %s", firstElement, entityName, firstElement);

		Query query = this.entityManager.createQuery(search, domainClass);

		@SuppressWarnings("unchecked")
		Collection<T> list = query.getResultList();

		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public List<T> findAllPageable(int init, int size, Ordering ordering, String orderByField) {
		if (orderByField.isBlank() || ordering == null) {
			throw new QueryFilterException(
					"Parameter for the search cannot be empty, null and must be an attribute of the entity.");
		}
		String search = String.format("Select %s from %s %s Order By %s.%s %s", firstElement, entityName, firstElement,
				firstElement, orderByField, ordering.name());
		return this.entityManager.createQuery(search, domainClass).setFirstResult(init).setMaxResults(size)
				.getResultList();

	}

	@Override
	public T findById(ID id) {
		try {
			return this.entityManager.find(domainClass, id);
		} catch (Exception exception) {
			logger.log(Level.SEVERE, "Unable to retrieve object from database.");
			throw new GenericPersistenceException(genericMessage(exception), exception);
		}
	}
	
	@Override
	public List<T> list() {
		String search = String.format("Select %s from %s %s", firstElement, entityName, firstElement);
		return this.entityManager.createQuery(search, domainClass).getResultList();
	}
	
	private String genericMessage(Exception exception) {
		return String.format("Cause: %s", exception.getMessage());
	}

}
