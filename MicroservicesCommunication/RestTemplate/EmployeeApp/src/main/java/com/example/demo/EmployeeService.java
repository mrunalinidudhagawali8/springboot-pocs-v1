package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	public EmployeeEntity getEmployeeById(Long id)
	{	
		Optional<EmployeeEntity> employee = repo.findById(id);
		
		String addressResp = restTemplate.getForObject("http://localhost:8081/address/{id}", String.class, id);
		employee.get().setAddress(addressResp);
		repo.save(employee.get());
		return employee.get();
	}
}
