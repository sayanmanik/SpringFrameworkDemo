package com.sayan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach c = ctx.getBean("myCoach",Coach.class);
		System.out.println(c.getWorkoutDetails());
		
		System.out.println(c.getFortuneDetails());
		

		
		
	}

}
