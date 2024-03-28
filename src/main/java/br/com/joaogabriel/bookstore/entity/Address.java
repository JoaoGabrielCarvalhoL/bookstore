package br.com.joaogabriel.bookstore.entity;

import br.com.joaogabriel.bookstore.enumerations.AddressType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Address {
	
	@Enumerated(EnumType.STRING)
	private AddressType type;
	
	@Column(nullable = false)
	private String zipCode;
	
	@Column(nullable = false)
	private String publicPlace;
	
	@Column(nullable = false)
	private String complement;
	
	@Column(nullable = false)
	private String neighborhood;
	
	@Column(nullable = false)
	private String locality;
	
	@Column(nullable = false)
	private String federativeUnit;
	
	@Column(nullable = false)
	private String houseNumber;

	public Address() { }

	public Address(AddressType type, String zipCode, String publicPlace, String complement, String neighborhood,
			String locality, String federativeUnit, String houseNumber) {
		super();
		this.type = type;
		this.zipCode = zipCode;
		this.publicPlace = publicPlace;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.locality = locality;
		this.federativeUnit = federativeUnit;
		this.houseNumber = houseNumber;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getFederativeUnit() {
		return federativeUnit;
	}

	public void setFederativeUnit(String federativeUnit) {
		this.federativeUnit = federativeUnit;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	

}
