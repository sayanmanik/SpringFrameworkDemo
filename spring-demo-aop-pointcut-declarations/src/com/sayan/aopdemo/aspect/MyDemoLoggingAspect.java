package com.sayan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@Pointcut("execution(* com.sayan.dao.*.*(..))")
	private void forDaoPackage(){}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice(){
		System.out.println("\n====> Executing @Before advice on ");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics(){
		System.out.println("\n====> Performing API analytics ");
	}
	
}
