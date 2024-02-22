package br.com.joaogabriel.bookstore.entity;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_informations")
public class UserInformations {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String userAgent;

	@Column(nullable = false)
	private String internetProtocol;

	@Column(nullable = false)
	private String locale;

	@OneToOne(mappedBy = "userInformations")
	private User user;

	public UserInformations() { }

	public UserInformations(String userAgent, String internetProtocol, String locale) {
    	this.userAgent = userAgent;
    	this.internetProtocol = internetProtocol;
    	this.locale = locale;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getInternetProtocol() {
		return internetProtocol;
	}

	public void setInternetProtocol(String internetProtocol) {
		this.internetProtocol = internetProtocol;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		UserInformations other = (UserInformations) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
