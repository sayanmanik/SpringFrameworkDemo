package com.sayan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SportsConfig.class);
		
		Coach c = ctx.getBean("tennisCoach",Coach.class);
		System.out.println(c.getDailyFortune());
		System.out.println(c.getDailyWorkout());
		
		ctx.close();
	}
}