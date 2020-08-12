package com.springFrame.spring_JDBC.dao;

import com.springFrame.spring_JDBC.entities.Student;

public interface StudentDAO {
	
	public int insert(Student student);
	
	public int change(Student student);
	
	public int delete(int studentID);
	
}
