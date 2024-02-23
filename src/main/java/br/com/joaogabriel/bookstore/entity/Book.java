package br.com.joaogabriel.bookstore.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false, unique = true)
	private String title;
	
	@Lob
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String isbn;
	
	@Column(nullable = false)
	private byte[] image;
	
	@Column(nullable = false, scale = 2, precision = 10)
	private BigDecimal price;
	
	@Temporal(TemporalType.DATE)
	private LocalDate publishedIn;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updatedIn;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime savedIn;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH  }, 
			fetch = FetchType.EAGER)
	private Category category;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH  }, 
			fetch = FetchType.EAGER)
	private Author author;
	
	@OneToMany(mappedBy = "book", orphanRemoval = true)
	private Collection<Review> reviews;
	
	@OneToMany(mappedBy = "book")
	private Collection<OrderDetail> orderDetails;
	
	public Book() {}
	
	public Book(String title, String description, String isbn, byte[] image, 
			BigDecimal price, LocalDate publishedIn) {
		this.title = title; 
		this.description = description; 
		this.isbn = isbn; 
		this.image = image; 
		this.price = price; 
		this.publishedIn = publishedIn;
	}
	
	public Book(String title, String description, String isbn, byte[] image, 
			BigDecimal price, LocalDate publishedIn, Category category, Author author) {
		this(title, description, isbn, image, price, publishedIn);
		this.category = category; 
		this.author = author;
	}

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getPublishedIn() {
		return publishedIn;
	}

	public void setPublishedIn(LocalDate publishedIn) {
		this.publishedIn = publishedIn;
	}

	public LocalDateTime getUpdatedIn() {
		return updatedIn;
	}

	public void setUpdatedIn(LocalDateTime updatedIn) {
		this.updatedIn = updatedIn;
	}

	public LocalDateTime getSavedIn() {
		return savedIn;
	}

	public void setSavedIn(LocalDateTime savedIn) {
		this.savedIn = savedIn;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Collection<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}
	
	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	
	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
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
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
	
	@PreUpdate
	public void setupUpdatedIn() {
		this.setUpdatedIn(LocalDateTime.now());
	}
	
	@PrePersist
	public void setupSavedIn() {
		this.setSavedIn(LocalDateTime.now());
	}
	
	
}
