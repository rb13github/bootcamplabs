package com.ibm.bootcamp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currencyconvertor")
public class CurrencyConvertor {
	
	@Id
	//@GeneratedValue
	private String countryCode;
	
	private Float conversionFactor;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Float getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Float conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
	

	
}
