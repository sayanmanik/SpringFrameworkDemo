package com.sayan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = ctx.getBean("myCoach",Coach.class);

		Coach alphaCoach = ctx.getBean("myCoach",Coach.class);
		
		boolean result = theCoach == alphaCoach;
		System.out.println("Result: "+result);
	
		System.out.println("Memory location of 1st bean:"+theCoach);
		
		System.out.println("Memory location of 2nd bean:"+alphaCoach);
	}

}
