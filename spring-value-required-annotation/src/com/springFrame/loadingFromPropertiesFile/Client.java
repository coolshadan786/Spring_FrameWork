package com.springFrame.loadingFromPropertiesFile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springFrame.JDBC_Connection.JDBCConnection;
import java.sql.*;

public class Client {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("beans.xml file loaded");
//		Student student=context.getBean("student",Student.class);
//		System.out.println(student);
//		student.displayStudentInfo();
		System.out.println("--------------------");
		JDBCConnection mySql = context.getBean("mySql",JDBCConnection.class);
		System.out.println(mySql);
		mySql.display();
		mySql.getJDBCConnection();
		
	}

}
