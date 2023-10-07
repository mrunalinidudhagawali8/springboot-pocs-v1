package com.poc.learningjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poc.learningjpaandhibernate.model.Course3;

@SpringBootApplication
public class LearningJpaAndHibernateApplication implements CommandLineRunner {

	/**
	 * To start with H2-Database setup
	 * 
	 * 1. You need to add h2-db dependency
	 * 2. Enable the H2 console by adding in app.prop - spring.h2.console.enabled=true
	 * 3. Set - spring.datasource.url=jdbc:h2:mem:testdb - otherwise in each session this url will keep changing
	 * 4. you can define your schema in src/main/res/schema.sql
	 */
	
	@Autowired
	private CourseJdbcRepository coursejdbcRepo;
	
	@Autowired
	private CourseJpaRepository courseJpaRepo;
	
	@Autowired
	private CourseSpringDataJpaRepository courseSpringDataJpaRepo;

	public static void main(String[] args) {
		SpringApplication.run(LearningJpaAndHibernateApplication.class, args);
	}

	//uncomment for Spring JDBC testing
//	@Override
//	public void run(String... args) throws Exception {
//		Course course = new Course(1, "jdbccourse", "mrunalini");
//		Course course1 = new Course(2, "jdbccourse1", "abhi");
//		Course course2 = new Course(3, "jdbcourse2", "niyu");
//		
//		coursejdbcRepo.insertACourse(course);
//		coursejdbcRepo.insertACourse(course1);
//		coursejdbcRepo.insertACourse(course2);
//		
//		coursejdbcRepo.deleteACourse(3);
//		
//		System.out.println(coursejdbcRepo.retrieveACourse(1));
//	}
	
	//uncomment for JPA testing
//	@Override
//	public void run(String... args) throws Exception {	
//		Course2 course = new Course2(1, "jpacourse", "mrunalini");
//		Course2 course1 = new Course2(2, "jpacourse1", "abhi");
//		Course2 course2 = new Course2(3, "jpacourse2", "niyu");
//		
//		courseJpaRepo.insertCourse(course);
//		courseJpaRepo.insertCourse(course1);
//		courseJpaRepo.insertCourse(course2);
//		
//		courseJpaRepo.deleteCourse(3);
//		
//		System.out.println(courseJpaRepo.findCourse(1));
//	}

	//uncomment for SpringDataJpa testing
	@Override
	public void run(String... args) throws Exception {
		Course3 course1 = new Course3(1, "SpringData course1", "mru");
		Course3 course2 = new Course3(2, "SpringData course2", "anshu");
		Course3 course3 = new Course3(3, "SpringData course3", "deu");
		
		courseSpringDataJpaRepo.save(course1);
		courseSpringDataJpaRepo.save(course2);
		courseSpringDataJpaRepo.save(course3);
		
		courseSpringDataJpaRepo.deleteById(1);
		
		System.out.println(courseSpringDataJpaRepo.findById(2));
		
		System.out.println(courseSpringDataJpaRepo.findByAuthor("anshu"));
	}
}
