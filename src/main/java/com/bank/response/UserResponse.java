package com.bank.response;


import com.bank.model.Phone;
import com.bank.request.PhoneRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@ApiModel(description = "Entity which represents the user create and his attributes.")
@Validated
public class UserResponse {

	@NotEmpty
	@JsonProperty("id")
	private String id;

	@NotEmpty
	@JsonProperty("name")
	private String name;

	@NotEmpty
	@Email
	@JsonProperty("email")
	private String email;
	@NotEmpty
	@JsonProperty("password")
	private String password;

	@JsonProperty("phones")
	@Valid
	private List<PhoneResponse> phones;
	@NotEmpty
	@JsonProperty("created")
	private String created;
	@NotEmpty
	@JsonProperty("lastLogin")
	private String lastLogin;
	@NotEmpty
	@JsonProperty("token")
	private String token;
	@NotEmpty
	@JsonProperty("isActive")
	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneResponse> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneResponse> phones) {
		this.phones = phones;
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
