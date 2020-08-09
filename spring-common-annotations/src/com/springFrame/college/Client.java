package com.springFrame.college;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		//1st mtdh through using beans.xml file we fetch the (@Configuration) component of class with entire passed (basePackages)pkg search for it. 
		
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//		System.out.println("beans.xml file loaded");
//		College college=context.getBean("collegeBean",College.class);
//		System.out.println("The College object created by spring is : " + college);
		
		System.out.println("--------------------");
		
		//2nd mtdh through using Configuration class we fetch the (@Configuration) component of class(@ComponentScan) with entire passed (basePackages)pkg search for it. 
		
		ApplicationContext context=new AnnotationConfigApplicationContext(CollegeConfig.class);

		//College college=context.getBean("collegeBean",College.class);
		
		//College college=context.getBean("colBean",College.class);	//Bean 2 mtdh of CollegeConfig Class
		
		//here by default @Component using here as with the Class name of College in lowercase college variable
		College college=context.getBean("college",College.class);
		
		System.out.println("The College object created by spring is : " + college);
		college.test();
		
		((AnnotationConfigApplicationContext)context).close();		//for Context close
	}

}
