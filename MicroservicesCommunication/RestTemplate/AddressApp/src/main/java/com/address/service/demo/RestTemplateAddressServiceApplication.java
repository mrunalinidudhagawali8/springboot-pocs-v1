package com.address.service.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestTemplateAddressServiceApplication implements CommandLineRunner {

	@Autowired
	AddressRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(RestTemplateAddressServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Initialize data here
		AddressEntity addr1 = new AddressEntity(1L, "address1");
		repo.save(addr1);
		
		AddressEntity addr2 = new AddressEntity(2L, "address2");
		repo.save(addr2);
	}
}
