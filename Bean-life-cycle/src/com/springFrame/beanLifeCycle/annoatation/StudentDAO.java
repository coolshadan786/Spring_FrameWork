package com.springFrame.beanLifeCycle.annoatation;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.naming.spi.DirStateFactory.Result;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentDAO {

	private String url;
	private String userName;
	private String password;
	private String driver;
	
	//My Connection Obj
	
	Connection con;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		System.out.println("Setting url");
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("Setting userName");
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("Setting password");
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		System.out.println("Setting Driver");
		this.driver = driver;
	}
	
	@PostConstruct
	public void init() throws ClassNotFoundException, SQLException {		//for standard writing to init then we create separate mtdh for createBDConnection for destroy & here we call createBDConnection().
		
		System.out.println("inside the custom init mtdh");
		createBDConnection();
	}
	
	//Spring frame has called this mtdh for you for eavery mtdh need this CreationDB 
		//here the createBDConnection() is the init mtdh for us.anno a mtdh with @PostConstruct to use it as a init mtdh
		//we don't need to call init mdth,Our framework will call it for us.
		//We can give our init mtdh name as anything.We may say it init or we may say it createBDConnection() or xyz() mtdh
	
	
//	@PostConstruct					
	public void createBDConnection() throws ClassNotFoundException, SQLException {
		
		System.out.println("Creating connection for studentDB");
		
		//Load Driver	
		Class.forName(driver);
		
		//get a connection
		con= DriverManager.getConnection(url,userName,password);
		
	}
	
	public void selectAllRows() throws ClassNotFoundException, SQLException {
		
		System.out.println("Retriving all student data from datrabase MySql");

//		createBDConnection();
		//execute query
		Statement stmt=con.createStatement();
		
		String query="select * from stud;";
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next()) {
			int id= rs.getInt(1);
			String name = rs.getString(2);
			float hostelFees = rs.getFloat(3);
			String foodType = rs.getString(4);
			
			System.out.println(id + " " + name + " " + hostelFees + " " + foodType );
		}		
	}
	
	public void display() {
		System.out.println(userName + " " + url + " " + password + " " + driver );
	}
	
	public void deleteStudentRecord(int id) throws ClassNotFoundException, SQLException {
		
//		createBDConnection();
		
		//execute query
		Statement stmt=con.createStatement();
		
		String query2=("delete from stud where id="+id);
		
		stmt.executeUpdate(query2);
		
		System.out.println("Record deleted with the id = "+id);
	}
	
	
	//Before spring remove studentDao bean(object) from the container from TestClass class, it will call this mtdh
		//IMP = Remember that the DESTROY mtdh will only be called once your container Object got Destroy/Closed
	
	//For STANDALONE APP
	//creating continer object manually
			//ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
	//destroy conatiner object manually
			//context.close();
	
	//For WEB APP
	//you don't need to create & destroy the container object.This will be automatically done.
	
	
	//@PreDestroy over the mtdh as Destroy mtdh will be called before the bean is removed/destroy from the container	
//	@PreDestroy
	public void closeConnection() throws SQLException {			//Cleaning up unused references eg: con variable
		
		//Clean up job
		//Closing the connection
//		System.out.println("Inside Destroy mtdh");
		con.close();
	}
	
	@PreDestroy
	public void destroy() throws SQLException {		//for standard writing to destroy then we create separate mtdh for closeconnection for destroy & here we call closeConnection().
		//Clean up job
		//Closing the connection
		System.out.println("Inside Destroy mtdh");
		closeConnection();
	}
}
