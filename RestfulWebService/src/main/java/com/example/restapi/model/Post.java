package com.example.restapi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue
	Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	User user;

	@Size(min = 5)
	String description;

	Post() {
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post(Integer id, User user, String description) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", user=" + user + ", description=" + description + "]";
	}

}
