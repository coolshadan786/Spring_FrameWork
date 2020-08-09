package com.springFrame.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages ="com.springFrame.college")	//Remove the @ComponentScan coz there is no need of it we are not using @Component if we use @Bean anno for using Configuration instead of xml file  
@PropertySource("classpath:college-Info.properties")	//Here pass value from college-Info.properties File as Key & Value pair from it with @Value(key) and here it is used to define we path from we fetch the value of key.
public class CollegeConfig {
	
	  
	//If we use @Bean anno then no need to use any anno like @Component from required object (College Class) class (CollegeConfig Class) @ComponentScan plz remove or comment before use @Bean anno
	//So, if we need to use @Bean anno then we use @Configuration anno just over the (CollegeConfig) Config Class name


	//if we not used any @Bean anno over Object return mtdh then instead of it we used @Component(fix this tag on every class which required for object like Principal(Class),Teacher(Interface) and also on dependency class(College Class)),
		//@ComponentScan,@Autowired(Over Fields or setter mtdh),and @ComponentScan anno on Configration class(CollegeConfig) which is used to create Object of required class on dependency class like Principal(Class),Teacher(Interface).	
/*	
	@Bean								//Bean 1 mtdh
//	@Bean(name="colBean")				//Bean 2 mtdh 
//	@Bean(name= {"colBean" , "collegeBeanAnother"})				//Bean 3 mtdh = Giving multiple names to the same bean as in array of name if we use these name the we need to change name call in client class same  
	public College collegeBean() {		//Bean 1 mtdh = collegeBean - bean id
//		College college=new College();	//1st mtdh 
		
		
		//1st mtdh using constr for principal mtdh
		
		//here we are using constr injection for Principal Class through College Class
//		return new College(principalbean());			//2nd mtdh these both 1&2 are same for crate object of College Class
	
		
		//2nd mtdh using setter injection for principal mtdh
		
		College college=new College();
		college.setPrincipal(principalbean());
		college.setTeacher(mathTeacherBean());
		return college;
	}

	@Bean
	public Principal principalbean() {
		return new Principal();
	}
	
	@Bean
	public Teacher mathTeacherBean() {
		return new MathTeacher();
		
	}
*/	
}
