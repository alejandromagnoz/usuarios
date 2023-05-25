package com.bank.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;

@ApiModel(description = "Entity which represents the phone created and his attributes.")
@Validated
public class PhoneResponse {

	@JsonProperty("number")
	private String number;

	@JsonProperty("cityCode")
	private String cityCode;

	@JsonProperty("countryCode")
	private String countryCode ;

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
