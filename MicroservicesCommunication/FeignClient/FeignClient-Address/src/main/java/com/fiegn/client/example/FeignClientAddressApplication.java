package com.fiegn.client.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeignClientAddressApplication implements CommandLineRunner {

	@Autowired
	AddressRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(FeignClientAddressApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AddressEntity addr1 = new AddressEntity(1L, "new road1");
		AddressEntity addr2 = new AddressEntity(2L, "new road2");
		repo.save(addr1);
		repo.save(addr2);
		
	}
	
	

}
