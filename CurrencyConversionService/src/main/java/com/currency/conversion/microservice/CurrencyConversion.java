package com.currency.conversion.microservice;

import java.math.BigDecimal;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;

//@Entity
public class CurrencyConversion {

//	@Id
	private Long Id;
	
//	@Column(name="currencyconversion_from")
	private String from;
	
//	@Column(name="currencyconversion_to")
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmt;
	private String environment;

	public CurrencyConversion() {
	}

	public Long getId() {
		return Id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public BigDecimal getTotalCalculatedAmt() {
		return totalCalculatedAmt;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setTotalCalculatedAmt(BigDecimal totalCalculatedAmt) {
		this.totalCalculatedAmt = totalCalculatedAmt;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmt, String environment) {
		super();
		Id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmt = totalCalculatedAmt;
		this.environment = environment;
	}

}
