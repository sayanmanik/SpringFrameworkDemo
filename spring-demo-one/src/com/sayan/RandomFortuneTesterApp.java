package com.sayan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomFortuneTesterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		GolfCoach coach = ctx.getBean("golfCoach",GolfCoach.class);
		
		System.out.println(coach.getWorkoutDetails());
		System.out.println(coach.getFortuneDetails());

	}
}