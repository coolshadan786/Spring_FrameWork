package com.springFrame.spring_JDBC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springFrame.spring_JDBC.entities.Student;

public class RowMapperImple  implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Student student=  new Student();
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setCity(rs.getString(3));
		student.setState(rs.getString(4));
		
		return student;
	}

}
