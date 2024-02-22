package br.com.joaogabriel.bookstore.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@OneToMany(mappedBy = "category")
	private Collection<Book> books;
	
	@Column(nullable = false, unique = true)
	private String name;

	public Category() {} 
	
	public Category(String name) {
		this.name = name;
	}
	
	public Collection<Book> getBooks() {
		return Collections.unmodifiableCollection(this.books);
	}
	
	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
