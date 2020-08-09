package com.springFrame.college;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary			//If i have multiple(20-30) implementation classes of Teacher Interface and i used only one class as a primary then we used @primary anno just over the required primary class.
						//then we not need @Qualifier anno in dependency class just after @Autowired anno,So if we used @primary anno need and vice-versa same for @Qualifier
public class MathTeacher implements Teacher {

	@Override
	public void teach() {
		System.out.println("Hi I am your Math Teacher lalan");
		System.out.println("My name is Lalan");
		

	}

}
