package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	EmployeeService service;

	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeDetails(@PathVariable Long id) {
		EmployeeEntity empresp = service.getEmployeeById(id);

		return ResponseEntity.status(HttpStatus.OK).body(empresp);
	}
}
