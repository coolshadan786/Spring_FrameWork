package com.springFrame.beanLifeCycle.annoatation;

import java.sql.SQLException;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
//		StudentDAO dao = new StudentDAO();
//		dao.selectAllRows();
//		dao.deleteStudentRecord(2);
		
		//In Web App it is not our responsibility to start & close the Application context
		
		ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
		StudentDAO studentDao=context.getBean("studentDAO", StudentDAO.class);
		System.out.println(studentDao);
		studentDao.selectAllRows();
//		studentDao.deleteStudentRecord(3);
		
		//close() is not in ApplicationContext class due to it can't close So,we need to down Casting ClassPathXmlApplicationContext int this class close mtdh we found and we close the container
			//if we call close here then the destroy or close mtdh(closeConnection()) were call from the StudentDAO class.
		((ClassPathXmlApplicationContext)context).close();
	
	}

}
