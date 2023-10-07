package com.poc.learningjpaandhibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.poc.learningjpaandhibernate.model.Course2;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public void insertCourse(Course2 course) {
		entityManager.merge(course);
	}

	public void deleteCourse(int id) {
		Course2 course = entityManager.find(Course2.class, id);
		entityManager.remove(course);
	}

	public Course2 findCourse(int id) {
		return entityManager.find(Course2.class, id);
	}

}
