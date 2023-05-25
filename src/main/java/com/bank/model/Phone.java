package com.bank.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "phone")
public class Phone {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long phoneId;
	@Column(name = "userId", nullable = false)
	private Long userId;

	@Column(name = "number", nullable = false)
	private String number;

	@Column(name = "cityCode", nullable = false)
	private String cityCode;

	@Column(name = "countryCode", nullable = false)
	private String countryCode;

	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
