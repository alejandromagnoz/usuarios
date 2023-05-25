package com.bank.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@ApiModel(description = "Entity which represents the phone and his attributes.")
@Validated
public class PhoneRequest {

	@JsonProperty("number")
	private String number = null;

	@JsonProperty("cityCode")
	private String cityCode = null;

	@JsonProperty("countryCode")
	private String countryCode = null;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
