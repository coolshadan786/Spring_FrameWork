package com.springFrame.JDBC_Connection;

import org.springframework.beans.factory.annotation.Value;
import java.sql.*;

public class JDBCConnection {
	
	@Value("${mySql.url}")
	private String url;
	
	@Value("${mySql.username}")
	private String userName;
	
	@Value("${mySql.password}")
	private String password;
	
	@Value("${mySql.driver}")
	private String driver;
	
	public void display() {
		System.out.println(userName + " " + url + " " + password + " " + driver );
	}
	
	public void getJDBCConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,userName,password);
		System.out.println("Connection sucessful : " + con);
	}
}
