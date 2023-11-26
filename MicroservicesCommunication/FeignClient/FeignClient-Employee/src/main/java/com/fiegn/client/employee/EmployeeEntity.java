package com.fiegn.client.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeEntity {

	@Id
	private Long empId;

	private String name;

	private String address;

	private Integer age;

	public Long getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Integer getAge() {
		return age;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public EmployeeEntity(Long empId, String name, String address, Integer age) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public EmployeeEntity() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeEntity [empId=" + empId + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	}

}
