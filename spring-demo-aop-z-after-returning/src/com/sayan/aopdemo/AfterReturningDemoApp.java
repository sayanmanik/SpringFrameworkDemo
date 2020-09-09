package com.sayan.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sayan.dao.AccountDao;
import com.sayan.dao.MembershipDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
	
		AccountDao theAccountDAO = context.getBean("accountDao",AccountDao.class);
		
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		
		System.out.println("\n\n Main program: AfterReturningDemoApp");
		System.out.println("----");
		
		System.out.println(theAccounts);
		System.out.println("\n");
		

		context.close();
	}

}
