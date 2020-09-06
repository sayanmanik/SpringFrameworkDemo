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
	
	@Pointcut("execution(* com.sayan.dao.*.get*(..))")
	private void getter(){}
	
	@Pointcut("execution(* com.sayan.dao.*.set*(..))")
	private void setter(){}
	
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(){
		System.out.println("\n====> Executing @Before advice on ");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics(){
		System.out.println("\n====> Performing API analytics ");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void logToCloudAsync(){
		System.out.print("\n====> Logging to Cloud in async fashion");
	}
}
