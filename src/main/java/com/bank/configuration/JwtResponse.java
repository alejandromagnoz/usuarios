package com.bank.configuration;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -6540769945185634149L;

	private final String jwttoken;

	public JwtResponse(String jwttoken) {

		this.jwttoken = jwttoken;

	}

	public String getToken() {
		return this.jwttoken;
	}

}
