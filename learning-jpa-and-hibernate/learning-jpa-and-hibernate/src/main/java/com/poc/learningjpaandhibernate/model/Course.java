package com.poc.learningjpaandhibernate.model;

/*
 * Course Bean designed for JDBC repository
 */
public class Course {

	Integer id;
	String name;
	String author;

	public Course() {
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

	public Course(Integer id, String name, String author) {
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
