package br.com.joaogabriel.bookstore.repository;

import java.util.UUID;

import br.com.joaogabriel.bookstore.dao.impl.SimpleGenericDao;
import br.com.joaogabriel.bookstore.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UserRepository extends SimpleGenericDao<User, UUID> {

	public UserRepository(Class<User> classe) {
		super(classe);
	}

	private EntityManager entityManager = getEntityManager();

	public User findByEmail(String email) {
		String search = "Select u From User u WHERE u.email = ?1";
		Query query = this.entityManager.createQuery(search).setParameter(1,email);
		return (User) query.getSingleResult();
	}

}
