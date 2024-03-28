package br.com.joaogabriel.bookstore.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import br.com.joaogabriel.bookstore.enumerations.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_user")
@NamedQueries( @NamedQuery(name = "User.findAll", query = "Select u from User u ORDER BY u.name"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 50, unique = true)
	private String email;

	@Column(nullable = false, length = 50, unique = true)
	private String username;

	@Column(nullable = false)
	private String hashPassword;
	
	private Boolean isActive;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdAt;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true)
	private UserInformations userInformations;
	
	@Embedded
	private Address adresses;
	
	@Column(nullable = false)
	private String cellphone;

	public User() {}

	public User(String name, String email, String username, String hashPassword, String cellphone, Role role) {
		this.name = name;
		this.email = email;
		this.username = username;
		this.hashPassword = hashPassword;
		this.cellphone = cellphone;
		this.isActive = true;
		this.role = role;
	}

	public User(String name, String email, String username, String hashPassword, String cellphone, Role role, UserInformations userInfo, Address adresses) {
		this(name, email, username, hashPassword, cellphone, role);
		this.userInformations = userInfo;
		this.adresses = adresses;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public UserInformations getUserInfo() {
		return userInformations;
	}

	public void setUserInformations(UserInformations userInfo) {
		this.userInformations = userInfo;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Address getAdresses() {
		return this.adresses;
	}
	
	public void setAdresses(Address adresses) {
		this.adresses = adresses;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
