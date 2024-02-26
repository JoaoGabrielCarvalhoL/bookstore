package br.com.joaogabriel.bookstore.repository;

import java.util.UUID;

import br.com.joaogabriel.bookstore.dao.impl.SimpleGenericDao;
import br.com.joaogabriel.bookstore.entity.Author;

public class AuthorRepository extends SimpleGenericDao<Author, UUID> {

	public AuthorRepository(Class<Author> classe) {
		super(classe);
	}

}
