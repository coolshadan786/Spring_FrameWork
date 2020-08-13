package com.springFrame.spring_JDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springFrame.spring_JDBC.dao.StudentDAO;
import com.springFrame.spring_JDBC.dao.StudentDAOImple;
import com.springFrame.spring_JDBC.entities.Student;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started....." );
        
        //spring jdbc -> JdbcTemplate
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springFrame/spring_JDBC/config.xml");
        
        Scanner sc = new Scanner(System.in);
        
        	//If we  are create a class(StudentDAOImple class)an implements DAO class(StudentDAO) like (public class StudentDAOImple implements StudentDAO {)
        		//and this class having JdbcTemplate class for object thorugh object JdbcTemplate class we can call the  predefined mtdhs of template class there
        		//So no need to use all kind of stuf which  was using here like creating class object of JdbcTemplate class through getBean("jdbcTemplate",JdbcTemplate.class)
        		//context variable of ApplicationContext class of IOC.So there we only need to create object of StudentDAOImple class and call its mtdh.
        
/*      JdbcTemplate template =	context.getBean("jdbcTemplate",JdbcTemplate.class);
  
        //Insert Query
        String query="insert into student(id,name,city,state) values(?,?,?,?)";
        
        //Fire Query
        int result= template.update(query,6,"Arpit","Sitapur","Uttar Pradesh");
        System.out.println("Number of record inserted = "+result);*/
        
        StudentDAO studentDAO  =  context.getBean("studentDaoImple",StudentDAO.class);
    
        
        	//INSERT
//      Student student=new Student();
//        student.setId(7);
//        student.setName("Rohan");
//        student.setCity("Barabanki");
//        student.setState("Uttar Pradesh");
//        
//        int result = studentDAO.insert(student);
//        	System.out.println("Studetn added = "+result);
        
        
        	//UPDATE
/*      Student student=new Student();
        student.setId(6);
        student.setName("Arpit Jaiswal");
        student.setCity("Sitap");
        
        int result= studentDAO.change(student);
        		System.out.println("Data Cahnged = "+result);*/
        
        	//DELETE  //1st mtdh using default studentID pass.
//        int result = studentDAO.delete(7);
//        	System.out.println("Deleted rows = "+result);
        
        	//DELETE  //2nd mtdh using user input of studentID pass.
/*        System.out.println("Enter the id which is going to delete from the DataBase by u");
        int id=sc.nextInt();
        int result = studentDAO.delete(id);
      		System.out.println("Deleted rows = "+result);*/
        
        	//SELECT
/*        Student student = studentDAO.getStudent(5);
        	System.out.println(student);*/
        
        	//MULTIPLE SELECT
        List<Student> students = studentDAO.getAllStudent();
        for(Student s:students) {
        	System.out.println(s);
        }       
    }
}
