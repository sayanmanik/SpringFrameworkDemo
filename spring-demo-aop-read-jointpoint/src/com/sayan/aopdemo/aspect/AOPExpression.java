package com.sayan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpression {

	@Pointcut("execution(* com.sayan.dao.*.*(..))")
	public void forDaoPackage(){}
	
	@Pointcut("execution(* com.sayan.dao.*.get*(..))")
	public void getter(){}
	
	@Pointcut("execution(* com.sayan.dao.*.set*(..))")
	public void setter(){}
	
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
