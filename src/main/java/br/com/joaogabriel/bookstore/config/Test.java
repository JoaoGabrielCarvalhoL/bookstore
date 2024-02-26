package br.com.joaogabriel.bookstore.config;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import br.com.joaogabriel.bookstore.dao.Ordering;
import br.com.joaogabriel.bookstore.entity.Author;
import br.com.joaogabriel.bookstore.repository.AuthorRepository;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Author author = new Author("João Gabriel");
		
		AuthorRepository authorDao1 = new AuthorRepository(Author.class);
		Collection<Author> all = authorDao1.findAll();
		for (Author a : all) {
			System.out.println(a.getId());
		}
		authorDao1.save(author);
		authorDao1.save(author);
		Author author2 = new Author("Laís");
		authorDao1.save(author2);
		System.out.println(author.getId() + author.getName());
		
		UUID id = author.getId();
		
		Author byId = authorDao1.findById(id);
		System.out.println(byId.getName() + byId.getId());
		
		Collection<Author> all1 = authorDao1.findAll();
		for (Author a : all1) {
			System.out.println(a.getId());
		}
		
		System.out.println("##############");
		List<Author> allPageable = authorDao1.findAllPageable(0, 1, Ordering.DESC, "name");
		for (Author a : allPageable) {
			System.out.println(a.getId() + a.getName());
		}
	}

}
