package com.sayan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
//		Coach theCoach = ctx.getBean("thatSillyCoach",Coach.class);
		Coach theCoach = ctx.getBean("tennisCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		ctx.close();
	}
}