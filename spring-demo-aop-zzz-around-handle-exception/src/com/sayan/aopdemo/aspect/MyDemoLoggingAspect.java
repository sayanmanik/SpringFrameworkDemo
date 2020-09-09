package com.sayan.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sayan.aopdemo.Account;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.sayan.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
	{
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @AfterReturning on method: "+method);

		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		try{
			result = theProceedingJoinPoint.proceed();
		}catch(Exception e){
			myLogger.warning(e.getMessage());
			
			result = "Major accident! But no worries, "
					+ "your private AOP helicopter is on the way!";
			
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		myLogger.info("\n======> Duration: "+duration / 1000.0 + " seconds");
		
		return result;
	}
	
	
	
	
	
	
	
	@AfterReturning(
			pointcut="execution(* com.sayan.dao.AccountDao.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result){
		
	String method = theJoinPoint.getSignature().toShortString();
	myLogger.info("\n====>>> Executing @AfterReturning on method: "+method);
	
	
	myLogger.info("\n====>>> result is: "+result);
	
	
	convertAccountNamesToUpperCase(result);
	
	
	myLogger.info("\n====>>>> result is: "+result);
	
	
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result){
	
		for(Account tempAccount : result){
			
			String theUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
			
		}
		
	}
	
	
	@Before("com.sayan.aopdemo.aspect.AOPExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(){
		myLogger.info("\n====> Executing @Before advice on ");
	}
	
}
