package br.com.joaogabriel.bookstore.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import br.com.joaogabriel.bookstore.enumerations.PaymentMethods;
import br.com.joaogabriel.bookstore.enumerations.SaleStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne
	private Customer customer; 
	
	@Enumerated(EnumType.STRING)
	private SaleStatus status;
	
	@Temporal(TemporalType.DATE)
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethods type;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal total;
	
	@OneToOne(mappedBy = "order")
	private OrderDetail details;
	
	public Order() { }
	
	public Order(SaleStatus status, LocalDate date, PaymentMethods type, BigDecimal total, Customer customer) {
		this.status = status;
		this.date = date; 
		this.type = type; 
		this.total = total; 
		this.customer = customer;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SaleStatus getStatus() {
		return status;
	}

	public void setStatus(SaleStatus status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public PaymentMethods getType() {
		return type;
	}

	public void setType(PaymentMethods type) {
		this.type = type;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
