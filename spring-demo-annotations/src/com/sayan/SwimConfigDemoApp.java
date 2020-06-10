package com.sayan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SportsConfig.class);
		
		SwimCoach c = ctx.getBean("swimCoach",SwimCoach.class);
		System.out.println(c.getDailyFortune());
		System.out.println(c.getDailyWorkout());
		
		System.out.println(c.getEmail());
		System.out.println(c.getTeam());
		
		ctx.close();
	}
}