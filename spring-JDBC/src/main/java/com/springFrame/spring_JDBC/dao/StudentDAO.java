package com.springFrame.spring_JDBC.dao;

import java.util.List;

import com.springFrame.spring_JDBC.entities.Student;

public interface StudentDAO {
	
	public int insert(Student student);
	
	public int change(Student student);
	
	public int delete(int studentID);
	
	public Student getStudent(int studentID);
	
	public List<Student> getAllStudent();
	
}
