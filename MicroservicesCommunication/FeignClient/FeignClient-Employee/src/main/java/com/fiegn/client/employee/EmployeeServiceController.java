package com.fiegn.client.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeServiceController {

	@Autowired
	EmployeeServiceClass service;
	
	@Autowired
	AddressFiegnClientProxy proxy;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeDetails(@PathVariable Long id)
	{
		//get address of employee using id
		String address = proxy.getAddressById(id);
		
		EmployeeEntity emp = service.findEmpById(id);
		emp.setAddress(address);
		
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	
}
