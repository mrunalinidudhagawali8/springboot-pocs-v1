package com.address.service.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

	@Autowired
	AddressService service;
	
	@GetMapping("/address/{id}")
	public ResponseEntity<AddressEntity> findAddressById(@PathVariable Long id)
	{
		AddressEntity addr = service.getAddressById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(addr);
	}
}
