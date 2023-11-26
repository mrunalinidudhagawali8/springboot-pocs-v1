package com.fiegn.client.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@EnableFeignClients
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class FeignClientEmployeeServiceApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(FeignClientEmployeeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeEntity emp1 = new EmployeeEntity();
		emp1.setEmpId(1L);
		emp1.setAge(23);
		emp1.setName("Mrunalini");

		repo.save(emp1);

		EmployeeEntity emp2 = new EmployeeEntity();
		emp2.setEmpId(2L);
		emp2.setName("Anshu");
		emp2.setAge(24);

		repo.save(emp2);
	}

}
