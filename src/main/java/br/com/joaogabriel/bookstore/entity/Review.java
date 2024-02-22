package br.com.joaogabriel.bookstore.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	private Integer rating;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Column(nullable = false)
	private String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime occurredIn;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Book book;
	
	public Review() { }
	
	public Review(Integer rating, String title, String comment) {
		this.rating = rating; 
		this.title = title; 
		this.comment = comment;
		this.occurredIn = LocalDateTime.now();
	}
	
	public Review(Integer rating, String title, String comment, Customer customer, Book book) {
		this(rating, title, comment); 
		this.customer = customer; 
		this.book = book;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getOccurredIn() {
		return occurredIn;
	}

	public void setOccurredIn(LocalDateTime occurredIn) {
		this.occurredIn = occurredIn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	

}
