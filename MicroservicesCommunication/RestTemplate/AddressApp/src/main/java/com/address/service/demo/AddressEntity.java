package com.address.service.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AddressEntity {

	@Id
	private Long addressId;
	
	private String address;

	public Long getAddressId() {
		return addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AddressEntity(Long addressId, String address) {
		super();
		this.addressId = addressId;
		this.address = address;
	}

	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
