package com.address.service.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	AddressRepository repo;

	public AddressEntity getAddressById(Long id) {

		Optional<AddressEntity> address = repo.findById(id);
		return address.get();
	}
}
