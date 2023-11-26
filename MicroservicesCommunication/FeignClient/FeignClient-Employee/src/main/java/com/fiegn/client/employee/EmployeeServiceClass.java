package com.fiegn.client.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceClass {

	@Autowired
	EmployeeRepository repo;
	
	public EmployeeEntity findEmpById(Long id)
	{
		EmployeeEntity emp = repo.findById(id).get();
		
		return emp;
	}
	
}
