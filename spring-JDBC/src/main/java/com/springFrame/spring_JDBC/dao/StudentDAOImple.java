package com.springFrame.spring_JDBC.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springFrame.spring_JDBC.entities.Student;

public class StudentDAOImple implements StudentDAO{
	
	private JdbcTemplate jdbcTemplate;

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		
		//Insert query
		String query="insert into student(id,name,city,state) values(?,?,?,?)";
		int r= this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity(),student.getState());
		return r;
	}

	public int change(Student student) {
		
		//Updating data 
		String query="update student set name=? , city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}

	public int delete(int studentID) {
		
		//Delete Operation
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentID);
		return r;
	}
	
	

}
