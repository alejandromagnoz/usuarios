package com.bank.model;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long userId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "created", nullable = false)
	//@Temporal(TemporalType.DATE)
	//@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private String created;

	@Column(name = "last_login", nullable = false)
	//@Temporal(TemporalType.DATE)
	//@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private String lastLogin;

	@Column(name = "token", nullable = false)
	private String token;

	@Column(name = "isactive", nullable = false)
	private Boolean isActive;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}
}
