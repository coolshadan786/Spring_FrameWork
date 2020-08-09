package com.springFrame.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human {
	
	// 1st mtdh
	
	//here Autowired annot is used trough dependency variable call
	// How @Autowired works?
	//	1. First it try to inject the dependency with "byType"
	//  2. If "byType" fails then it goes with "byName"
	// So,i.e we write here before dependency to check is it work well or not if well then no need to go with "byName" of setter mtdh|
	// No need to write setter if you are using @Autowired before the dependency.
	
	@Autowired		
	@Qualifier("humanHeart")		//if any conflict(more than 1 of same type of dependency class name "com.springFrame.autowired.Heart") with byName,resolve that with @Qualifier
	private Heart heart;

	//2nd mtdh
	
/*	public Human() {
		
	}
	
//	@Autowired						//here Autowired annot is used for constr trough call
	public Human(Heart heart) {
		this.heart = heart;
		System.out.println("human constr is getting called which has Heart as agr");
	}

	
	
//	@Autowired						//here Autowired annot is used for setter mtdh trough call
//	@Qualifier("humanHeart")		//if any conflict(more than 1 of same type of dependency class name "com.springFrame.autowired.Heart") with byName,resolve that with @Qualifier
//	@Qualifier("octHeart")
	public void setHeart(Heart heart) {
		this.heart = heart;
		System.out.println("setter mtdh is called");
	}
*/
	public void startPumping() {
		if(heart != null) {
			heart.pump();
			System.out.println("name of the animal is :"+ heart.getNameOfAnimal() +" "+ " no of Heart present : " +heart.getNoOfHeart());
		}else {
			System.out.println("you are dead");
		} 
	}
	
}
