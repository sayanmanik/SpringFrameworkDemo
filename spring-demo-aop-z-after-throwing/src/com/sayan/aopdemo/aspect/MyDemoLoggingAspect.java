package com.sayan.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sayan.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.sayan.dao.AccountDao.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint){
		
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @After (finally) on method: "+method);
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.sayan.dao.AccountDao.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result){
		
	String method = theJoinPoint.getSignature().toShortString();
	System.out.println("\n====>>> Executing @AfterReturning on method: "+method);
	
	
	System.out.println("\n====>>> result is: "+result);
	
	
	convertAccountNamesToUpperCase(result);
	
	
	System.out.println("\n====>>>> result is: "+result);
	
	
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result){
	
		for(Account tempAccount : result){
			
			String theUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
			
		}
		
	}
	
	
	@Before("com.sayan.aopdemo.aspect.AOPExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(){
		System.out.println("\n====> Executing @Before advice on ");
	}
	
}
