package com.sayan.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sayan.dao.AccountDao;
import com.sayan.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
	
		AccountDao theAccountDAO = context.getBean("accountDao",AccountDao.class);
		
		
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		
		
		MembershipDao theMembershipDAO = context.getBean("membershipDao",MembershipDao.class);
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		context.close();
	}

}
