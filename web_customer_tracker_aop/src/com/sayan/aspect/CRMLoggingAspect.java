package com.sayan.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	@Pointcut("execution(* com.sayan.controller.*.*(..))")
	private void forControllerPackage(){
		
	}
	
	
	@Pointcut("execution(* com.sayan.service.*.*(..))")
	private void forServicePackage(){
		
	}
	
	@Pointcut("execution(* com.sayan.dao.*.*(..))")
	private void forDaoPackage(){
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow(){
		
	}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint){
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>>>> in @Before: calling method: "+theMethod);
	
		Object[] args = theJoinPoint.getArgs();
		
		for(Object temp : args){
			myLogger.info("=====>>>> argument: " +temp);
		}
	
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult){
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>>> in @After Returning: from method: "+ method);
		
		myLogger.info("====>>>> result: "+theResult);
	}
	
	
	
	
	
}
