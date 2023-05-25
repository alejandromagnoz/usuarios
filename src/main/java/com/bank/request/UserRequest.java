package com.bank.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@ApiModel(description = "Entity which represents the user and his attributes.")
@Validated
public class UserRequest {

	@NotEmpty
	@JsonProperty("name")
	private String name = null;

	@NotEmpty
	@Email
	@JsonProperty("email")
	private String email = null;

	@NotEmpty
	@JsonProperty("password")
	private String password = null;

	@JsonProperty("phones")
	@Valid
	private List<PhoneRequest> phones;

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

	public List<PhoneRequest> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneRequest> phones) {
		this.phones = phones;
	}

}
