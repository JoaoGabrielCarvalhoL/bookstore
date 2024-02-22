package br.com.joaogabriel.bookstore.entity;

import br.com.joaogabriel.bookstore.enumerations.AddressType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Address {
	
	@Enumerated(EnumType.STRING)
	private AddressType type;

	
	public Address() { }
	

}
