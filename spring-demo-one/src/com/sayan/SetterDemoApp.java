package com.sayan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CricketCoach c = ctx.getBean("myCricketCoach",CricketCoach.class);
	
		System.out.println(c.getWorkoutDetails());
		System.out.println(c.getFortuneDetails());
		
		ctx.close();
		
		System.out.println(c.getEmailAddress());
		System.out.println(c.getTeam());
		
	}

}