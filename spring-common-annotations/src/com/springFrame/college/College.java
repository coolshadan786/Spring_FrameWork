 package com.springFrame.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Ways to create object of class if we use spring framework
//		1. using beans tag in xml file
//		2. using @Component anno with xml file
			//<context:component-scan base-package="com.springFrame.college"/>
//		3. using @Component anno with @ComponentScan anno 
			//(basePackages ="com.springFrame.college")
//		4. using @Bean anno used before (public College collegeBean()) mtdh of Config Class as for bean id - "collegeBean"	


//@Component("collegeBean")
@Component			//if we using @Component without any bean id here/(defalut) blank is goes through as the class name but starts with a lower case
public class College {
	
	@Value("${college.name}")		//pass value from college-Info.properties File as Key & Value pair from it.
//	@Value("Integral University")	//here if we pass any parameter in @Value then it is the value for field like String collegeName = "Integral University";
	private String collegeName;
	
	@Autowired
	private Principal principal; 		//here Principal is a Class
	
	@Autowired
	@Qualifier("scienceTeacher")		//why we used @Qualifier anno coz we have more than one implementations class and i want special one instead over all classes(For more check = spring-autowiring-qualifier project). 
	private Teacher teacher;			//here Teacher is a Class and need stuf like (Teacher teacher = new MathTeacher());
	
/*	@Autowired
	public void setTeacher(Teacher teacher) {	//setter mtdh for MathTeacher class of Teacher interface for Object Creation
		this.teacher = teacher;
	}*/

	
	//1st mtdh for using Principal object through Constr
	
	//here we are using constr for constr injection for Principal Class in CollegeConfig Class through College Class
	/*public College(Principal principal) {
		this.principal = principal;
	}*/

	//2st mtdh for using Principal object through Setter mtdh instead of constr of 1st mtdh
		
/*	@Autowired
	public void setPrincipal(Principal principal) {		//setter mtdh for Principal class for Object Creation
		this.principal = principal;
		System.out.println("Using setPrincipal method");
	 }*/


	public void test() {
		principal.principalInfo();
		teacher.teach(); 
		System.out.println("Testing this College class mtdh");
		System.out.println("My college Name is :  "+collegeName);
	}

}
