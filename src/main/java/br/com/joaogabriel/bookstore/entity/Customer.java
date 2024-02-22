package br.com.joaogabriel.bookstore.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime register;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true)
	private User user;
	
	@OneToMany(mappedBy = "customer", orphanRemoval = true)
	private Collection<Order> orders;
	
	@OneToMany(mappedBy = "customer", orphanRemoval = true)
	private Collection<Review> reviews;
	
	public Customer() {}
	
	public Customer(LocalDateTime register, User user) {
		this.register = register;
		this.user = user;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getRegister() {
		return register;
	}

	public void setRegister(LocalDateTime register) {
		this.register = register;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Collection<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Collection<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
