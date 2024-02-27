package br.com.joaogabriel.bookstore.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.joaogabriel.bookstore.dao.Ordering;
import br.com.joaogabriel.bookstore.entity.Author;
import br.com.joaogabriel.bookstore.entity.builder.AuthorBuilder;
 
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthorRepositoryTest {
	
	private AuthorRepository authorRepository;
	private Author author;
	
	@BeforeAll
	public void setup() {
		this.authorRepository = new AuthorRepository(Author.class);
		
		this.author = new AuthorBuilder().builder()
				.name("João Gabriel Carvalho")
				.books(Collections.emptyList())
				.build();
	}
	
	@Test
	@DisplayName("Given author object, when save author (success), "
			+ "then return author persisted from database.")
	public void givenAuthorObject_whenSaveAuthor_thenReturnAuthorPersistedFromDatabase() {
		Author saved = this.authorRepository.save(this.author);
		Assertions.assertThat(saved).isNotNull();
		Assertions.assertThat(saved.getId()).isNotNull();
		Assertions.assertThat(saved.getName()).isEqualTo(this.author.getName());
	}
	
	@Test
	@DisplayName("Given a valid id, when retrieve author by id, then return author object from database.")
	public void givenValidUniqueIdentifier_whenRetriveAuthorById_thenReturnAuthorObject() {
		Author saved = this.authorRepository.save(this.author);
		UUID id = saved.getId();
		
		Author result = this.authorRepository.findById(id);
		Assertions.assertThat(result).isEqualTo(saved);
		Assertions.assertThat(result.getId()).isEqualTo(id);
	}
	
	@Test
	@DisplayName("Given invalid unique identifier_whenRetriveAuthorById_thenReturnAuthorObject")
	public void givenInvalidUniqueIdentifier_whenRetrieveAuthorById_thenReturnAuthorObject() {
		UUID id = UUID.randomUUID();
		Author author = this.authorRepository.findById(id);
		boolean result = Objects.isNull(author);
		Assertions.assertThat(author).isNull();
		System.out.println(result);	
	}
	
	@Test
	@DisplayName("Given author collection when retrieve all authors, then return populate list")
	public void givenAuthorCollection_whenRetrieveAllAuthors_thenReturnPopulateList() {
		Author firstObject = new AuthorBuilder().builder()
				.name("First Object")
				.books(Collections.emptyList())
				.build();
		
		Author secondObject = new AuthorBuilder().builder()
				.name("Second Object")
				.books(Collections.emptyList())
				.build();
		
		this.authorRepository.save(firstObject);
		this.authorRepository.save(secondObject);
		
		Collection<Author> list = this.authorRepository.findAll();
		Assertions.assertThat(list).isNotEmpty().hasSize(2);
	}
	
	@Test
	@DisplayName("Given author collection, when retrieve all authors without records, then return empty list")
	public void givenAuthorCollection_whenRetrieveAllAuthorWithoutRecords_thenReturnEmptyList() {
		Collection<Author> list = this.authorRepository.findAll();
		Assertions.assertThat(list).isEmpty();
	}
	
	@Test
	@DisplayName("Given author list, when retrieve all authors with pagination, then return populate list")
	public void givenAuthorList_whenRetriveAllAuthorWithPagination_thenReturnPopulateList() {
		Author firstObject = new AuthorBuilder().builder()
				.name("Cruz")
				.books(Collections.emptyList())
				.build();
		
		Author secondObject = new AuthorBuilder().builder()
				.name("Laís")
				.books(Collections.emptyList())
				.build();
		
		this.authorRepository.save(firstObject);
		this.authorRepository.save(secondObject);
		
		List<Author> list = this.authorRepository.findAllPageable(0, 1, Ordering.DESC, "name");
		Assertions.assertThat(list).isNotEmpty().hasSize(1);
	
		
	}

}
