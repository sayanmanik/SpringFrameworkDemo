package com.sayan.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sayan.aopdemo.service.TrafficFortuneService;
import com.sayan.dao.AccountDao;
import com.sayan.dao.MembershipDao;

public class AroundDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
	
		AccountDao theAccountDAO = context.getBean("accountDao",AccountDao.class);
	
		TrafficFortuneService theFortuneService =
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: "+data);
		
		System.out.println("Finished");
		 
		context.close();
	}

}
