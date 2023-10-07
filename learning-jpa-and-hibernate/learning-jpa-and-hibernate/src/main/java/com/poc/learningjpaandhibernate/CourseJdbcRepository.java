package com.poc.learningjpaandhibernate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.poc.learningjpaandhibernate.model.Course;

@Repository
public class CourseJdbcRepository {

	private JdbcTemplate springJdbctemplate;
	
	
	//incase you dont want to autowire
	//you can use constructor injection like this
	public CourseJdbcRepository(JdbcTemplate springJdbctemplate) {
		super();
		this.springJdbctemplate = springJdbctemplate;
	}

	String insertCourseRecordSql = "Insert into course(id, name, author) values (?,?,?);";
	String deleteACoursebyIdSql = "delete from course where id=?";
	String selectACourseById = "select * from course where id=?";
	
	public void insertACourse(Course course)
	{
		springJdbctemplate.update(insertCourseRecordSql, course.getId(), course.getName(), course.getAuthor() );
	}
	
	public void deleteACourse(int id)
	{
		springJdbctemplate.update(deleteACoursebyIdSql, id);
	}
	
	public Course retrieveACourse(int id)
	{
		return springJdbctemplate.queryForObject(selectACourseById, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
