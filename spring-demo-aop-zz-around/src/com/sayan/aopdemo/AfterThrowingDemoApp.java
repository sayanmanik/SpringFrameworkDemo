package com.sayan.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sayan.dao.AccountDao;
import com.sayan.dao.MembershipDao;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
	
		AccountDao theAccountDAO = context.getBean("accountDao",AccountDao.class);
		
		List<Account> theAccounts = null;
		
		try{
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
			
		}catch(Exception exec){
			System.out.println("\n\nMain Program... caught exception: "+exec);
		}
		
		
		
		
		System.out.println("\n\n Main program: AfterReturningDemoApp");
		System.out.println("----");
		
		System.out.println(theAccounts);
		System.out.println("\n");
		

		context.close();
	}

}
