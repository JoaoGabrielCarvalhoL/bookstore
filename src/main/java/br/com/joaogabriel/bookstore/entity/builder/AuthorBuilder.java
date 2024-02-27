package br.com.joaogabriel.bookstore.entity.builder;

import java.util.Collection;
import java.util.UUID;

import br.com.joaogabriel.bookstore.entity.Author;
import br.com.joaogabriel.bookstore.entity.Book;

public class AuthorBuilder {

	private Author author = new Author();
	
	public AuthorBuilder builder() {
		return new AuthorBuilder();
	}
	
	public AuthorBuilder id(UUID id) {
		this.author.setId(id);
		return this;
	}
	
	public AuthorBuilder name(String name) {
		this.author.setName(name);
		return this;
	}
	
	public AuthorBuilder books(Collection<Book> books) {
		this.author.setBooks(books);
		return this;
	}
	
	public Author build() {
		return this.author;
	}
	
}
