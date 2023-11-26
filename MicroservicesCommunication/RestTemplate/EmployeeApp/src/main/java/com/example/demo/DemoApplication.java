package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	
	@Autowired
	EmployeeRepository empRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Initialize data here
		EmployeeEntity emp1 = new EmployeeEntity();
		emp1.setUsername("Anshu");
		emp1.setEmail("Anshu@gmail.com");
		empRepo.save(emp1);
		
		EmployeeEntity emp2 = new EmployeeEntity();
		emp2.setUsername("Mru");
		emp2.setEmail("mru@gmail.com");
		empRepo.save(emp2);
	}

}
