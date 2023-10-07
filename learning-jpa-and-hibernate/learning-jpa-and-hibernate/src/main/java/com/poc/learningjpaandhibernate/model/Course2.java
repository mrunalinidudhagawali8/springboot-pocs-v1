package com.poc.learningjpaandhibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Course Bean designed for JPA repository
 */

@Entity
public class Course2 {

	@Id
	Integer id;
	
	String name;
	
	String author;

	public Course2() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Course2(Integer id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
