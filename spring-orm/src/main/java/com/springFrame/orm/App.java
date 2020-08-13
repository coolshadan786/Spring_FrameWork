package com.springFrame.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springFrame.orm.dao.StudentDAO;
import com.springFrame.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "My CRUD Program Started Plz use it....." );
        
        
        ApplicationContext context =  new ClassPathXmlApplicationContext("com/springFrame/orm/config.xml");
        StudentDAO studentDAO = context.getBean("studentDAO",StudentDAO.class);
    
        
//        Student student=new Student(6,"Durga bhai","Gonda","Uttar Pradesh");
//        int r = studentDAO.insert(student);
//        	System.out.println("Insert = "+r);
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go) {
        	  System.out.println("PRESS 1 for add new student");
              System.out.println("PRESS 2 for display all student");
              System.out.println("PRESS 3 for get details of SINGLE student");
              System.out.println("PRESS 4 for delete students");
              System.out.println("PRESS 5 for update students");
              System.out.println("PRESS 6 for EXIT");
       
              try {
            	  
            	  int input = Integer.parseInt(br.readLine());
            	 
//            	  if(input==1) {
//            		  
//            		  //Add a new student
//            	  }else if{
//            		  //Display
//            	  }
            	  
            	  switch (input) {
            	  		case 1://Add a new student
            	  				//Taking inputs from users
            	  			
            	  			System.out.println("Enter user id :  ");
            	  			int uid=Integer.parseInt(br.readLine());
            	  			
            	  			System.out.println("Enter user name :  ");
            	  			String uName=br.readLine();
            	  			
            	  			System.out.println("Enter user city :  ");
            	  			String uCity=br.readLine();
            	  			
            	  			System.out.println("Enter user state :  ");
            	  			String uState=br.readLine();
            	  			
            	  			//Creating students object and setting values
            	  			Student s=new Student();
            	  			s.setStudentId(uid);
            	  			s.setStudentName(uName);
            	  			s.setStudentCity(uCity);
            	  			s.setStudentState(uState);
            	  			
            	  			//Saving student object to database by calling insert of student dao
            	  			int r = studentDAO.insert(s);
            	  				System.out.println("Student details added " + r + " = with their Id No.");
            	  				System.out.println("**************************");
            	  				System.out.println();
            	  				
            	  			break;

            	  		case 2://display all student
            	  			
            	  			System.out.println("**************************");
            	  			List<Student> allStudents = studentDAO.getAllStudents();
            	  			for(Student st:allStudents) {
            	  				System.out.println("Id : "+st.getStudentId());
            	  				System.out.println("Name : "+st.getStudentName());
            	  				System.out.println("City : "+st.getStudentCity());
            	  				System.out.println("State : "+st.getStudentState());
            	  				System.out.println("_______________________________");
            	  			}
            	  			
            	  			System.out.println("**************************");
            	  			break;
            	  			
            	  		case 3://get details of SINGLE student
            	  		
            	  			System.out.println("Enter user id :  ");
            	  			int userid=Integer.parseInt(br.readLine());
            	  			Student student=studentDAO.getStudent(userid);
            	  			
            	  			System.out.println("Id : "+student.getStudentId());
        	  				System.out.println("Name : "+student.getStudentName());
        	  				System.out.println("City : "+student.getStudentCity());
        	  				System.out.println("State : "+student.getStudentState());
        	  				System.out.println("_______________________________");
        	  				
        	  				break;
        	  			
            	  		case 4://delete students
            	  			
            	  			System.out.println("**************************");
            	  			System.out.println("Enter user id :  ");
            	  			int usid=Integer.parseInt(br.readLine());
            	  			studentDAO.deleteStudent(usid);
            	  			System.out.println("Student details deleted.... ");
            	  			System.out.println("_______________________________");
            	  		
            	  			break;
        	  			
            	  		case 5://update students
            	  			
            	  			System.out.println("Enter user id :  ");
            	  			int u_id=Integer.parseInt(br.readLine());
            	  			
            	  			System.out.println("Enter user name :  ");
            	  			String u_Name=br.readLine();
            	  		 	
            	  			System.out.println("Enter user city :  ");
            	  			String u_City=br.readLine();
            	  			
            	  			System.out.println("Enter user state :  ");
            	  			String u_State=br.readLine();
            	  			
            	  			Student std=new Student();
            	  			std.setStudentId(u_id);
            	  			std.setStudentName(u_Name);
            	  			std.setStudentCity(u_City);
            	  			std.setStudentState(u_State);
            	  			
            	  			studentDAO.updateStudent(std);
        	  				System.out.println("For Id No. = " +u_id + " Student details were upDated");
        	  				System.out.println("**************************");
        	  				System.out.println();
            	  			break;
            	  				         	  			
            	  		case 6://exit
            	  				go=false;
            	  			break;
				}
            	  
            	  
              }catch (Exception e) {
            	  System.out.println("InValid Input Try with another on !!!");
            	  System.out.println(e.getMessage());
			}
        
        }
        System.out.println("Thank u using my application");
        System.out.println("See you soon");
        
    }
}
