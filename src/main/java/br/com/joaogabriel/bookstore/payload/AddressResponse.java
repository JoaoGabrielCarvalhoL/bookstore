package br.com.joaogabriel.bookstore.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressResponse {
	
	@JsonProperty("cep")
	private String zipCode;
	@JsonProperty("logradouro")
	private String publicPlace;
	@JsonProperty("complemento")
	private String complement;
	@JsonProperty("bairro")
	private String neighborhood;
	@JsonProperty("localidade")
	private String locality;
	@JsonProperty("uf")
	private String federativeUnit;
	@JsonProperty("ibge")
	private String brazilianInstituteGeographyStatistics;
	@JsonProperty("gia")
	private String gia;
	@JsonProperty("ddd")
	private String directRemoteDialing;
	@JsonProperty("siafi")
	private String integratedFinancialManagementSystemFederalGovernment;

	public AddressResponse() {
	}

	@JsonCreator
	public AddressResponse(String zipCode, String publicPlace, String complement, String neighborhood, String locality,
			String federativeUnit, String brazilianInstituteGeographyStatistics, String gia, String directRemoteDialing,
			String integratedFinancialManagementSystemFederalGovernment) {
		this.zipCode = zipCode;
		this.publicPlace = publicPlace;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.locality = locality;
		this.federativeUnit = federativeUnit;
		this.brazilianInstituteGeographyStatistics = brazilianInstituteGeographyStatistics;
		this.gia = gia;
		this.directRemoteDialing = directRemoteDialing;
		this.integratedFinancialManagementSystemFederalGovernment = integratedFinancialManagementSystemFederalGovernment;
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

	public String getBrazilianInstituteGeographyStatistics() {
		return brazilianInstituteGeographyStatistics;
	}

	public void setBrazilianInstituteGeographyStatistics(String brazilianInstituteGeographyStatistics) {
		this.brazilianInstituteGeographyStatistics = brazilianInstituteGeographyStatistics;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getDirectRemoteDialing() {
		return directRemoteDialing;
	}

	public void setDirectRemoteDialing(String directRemoteDialing) {
		this.directRemoteDialing = directRemoteDialing;
	}

	public String getIntegratedFinancialManagementSystemFederalGovernment() {
		return integratedFinancialManagementSystemFederalGovernment;
	}

	public void setIntegratedFinancialManagementSystemFederalGovernment(
			String integratedFinancialManagementSystemFederalGovernment) {
		this.integratedFinancialManagementSystemFederalGovernment = integratedFinancialManagementSystemFederalGovernment;
	}

}
