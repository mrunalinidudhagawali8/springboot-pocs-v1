package com.example.restapi.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "user_details")
public class User {

	@Id
	@GeneratedValue
	Integer id;

	@Size(min = 2, message = "Name should be atleast 2 letters long")
	@JsonProperty("user_name")
	String name;

	@Past(message = "Birthdate should be a date in past")
	LocalDate birthdate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Post> posts; 

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", posts=" + posts + "]";
	}

	public User(@Size(min = 2, message = "Name should be atleast 2 letters long") String name,
			@Past(message = "Birthdate should be a date in past") LocalDate birthdate, List<Post> posts) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.posts = posts;
	}

	public User(Integer id, @Size(min = 2, message = "Name should be atleast 2 letters long") String name,
			@Past(message = "Birthdate should be a date in past") LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}


}
