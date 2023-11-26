package com.fiegn.client.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AddressEntity {

	@Id
	Long id;
	
	String address;

	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", addressId=" + address + "]";
	}

	public AddressEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAddressId(String addressId) {
		this.address = addressId;
	}

	public AddressEntity(Long id, String addressId) {
		super();
		this.id = id;
		this.address = addressId;
	}
	
	
}
