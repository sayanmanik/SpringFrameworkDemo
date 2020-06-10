package com.sayan.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

	private String[] coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		// TODO Auto-generated method stub
	
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, 
			ConstraintValidatorContext theConstraintValidatorContext) {
		// TODO Auto-generated method stub
	
		boolean result = false;
		
		if(theCode!=null){
		
		for(String tempPrefix:coursePrefix){
			
			result = theCode.startsWith(tempPrefix);
		
			if(result){
				break;
			}
		}
		}else{
			result = true;
		}
				
		return result;
	}

}