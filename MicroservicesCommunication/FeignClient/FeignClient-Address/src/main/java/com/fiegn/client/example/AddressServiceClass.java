package com.fiegn.client.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceClass {

	@Autowired
	AddressRepository repo;
	
	public String getAdrressById(Long id)
	{
		return repo.findById(id).get().getAddress();
	}
}
