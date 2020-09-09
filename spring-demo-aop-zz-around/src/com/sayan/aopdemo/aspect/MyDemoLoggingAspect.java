package com.sayan.aopdemo.aspect;

import java.util.List;

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
	
	
	@Around("execution(* com.sayan.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
	{
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @AfterReturning on method: "+method);

		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		System.out.println("\n======> Duration: "+duration / 1000.0 + " seconds");
		
		return result;
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
