package com.poc.learningjpaandhibernate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.learningjpaandhibernate.model.Course3;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course3, Integer>{

	/**
	 * Spring Data jpa provides a way to write a user define method
	 */
	public List<Course3> findByAuthor(String author);
}
