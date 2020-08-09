package com.springFrame.loadingFromPropertiesFile;


import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class Student {

		@Value("${student.name}")		//when we are putting the @Value anno before the field we not need the setter mtdh 
		private String name;
		
		@Value("${student.intrestedCourse}")	//when we are putting the @Value anno before the field we not need the setter mtdh 
		private String interestedCource;
		
		@Value("${student.hobby}")		//when we are putting the @Value anno before the field we not need the setter mtdh 
		private String hobby;
		
//		@Required
//		@Value("${student.name}")
		public void setName(String name) {
			this.name = name;
			System.out.println("Using the SetName mtdh");
		}
		
//		@Required
//		@Value("${student.intrestedCourse}")
		public void setInterestedCource(String interestedCource) {
			this.interestedCource = interestedCource;
			System.out.println("Using the setInterestedCource mtdh");
		}
		
//		@Required
//		@Value("${student.hobby}")
		public void setHobby(String hobby) {
			this.hobby = hobby;
			System.out.println("Using the setHobby mtdh");
		}
		
		 public void displayStudentInfo() {
			 System.out.println("Student name "+ name);
			 System.out.println("Student intrested Course "+ interestedCource);
			 System.out.println("Student hobby "+ hobby);
		 }
	
}
