package com.springFrame.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springFrame.orm.entities.Student;

public class StudentDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional					//When ever we need to any kind of write operation(insert,delete) want in MySql db then we should always write @Transactional anno over the mtdh for opera. 
	public int insert(Student student) {		//C
		
		//insert
		Integer i = (Integer) this.hibernateTemplate.save(student);		
		return i;
		
	}

	//get the single data
	public Student  getStudent(int studentId) {		//R
		
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	
	//get all students(all rows)
	public List<Student> getAllStudents(){			//R
		
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
	
	//updating data
	@Transactional
	public void updateStudent(Student student) {		//U
		this.hibernateTemplate.update(student);
	}
	
	//Deleting the data
	@Transactional
	public void deleteStudent(int studentId) {			//D
		
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
		
	}
	
}
