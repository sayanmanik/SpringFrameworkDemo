package com.sayan.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sayan.aopdemo.service.TrafficFortuneService;
import com.sayan.dao.AccountDao;
import com.sayan.dao.MembershipDao;

public class AroundHandleExceptionDemoApp {

	
	private static Logger myLogger = 
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
	
		AccountDao theAccountDAO = context.getBean("accountDao",AccountDao.class);
	
		TrafficFortuneService theFortuneService =
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: "+data);
		
		myLogger.info("Finished");
		 
		context.close();
	}

}
