package com.sayan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
//	@Before("execution(public void com.sayan.dao.AccountDao.addAccount())")  // Pointcut expression
//	public void beforeAddAccountAdvice(){
//		
//		System.out.println("\n======>>>> Executing @Before advice on addAccount");
//	
//	}
	
	
//	@Before("execution(public void add*())")  // Pointcut expression
//	@Before("execution(void add*())")
//	@Before("execution(* add*(com.sayan.aopdemo.Account, ..))")
//	@Before("execution(* add*(..))")
	@Before("execution(* com.sayan.dao.*.*(..))")
	
	
	public void beforeAddAccountAdvice(){
		
		System.out.println("\n======>>>> Executing @Before advice on method");
	
	}
	
}
