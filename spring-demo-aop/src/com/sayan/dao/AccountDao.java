package com.sayan.dao;

import org.springframework.stereotype.Component;

import com.sayan.aopdemo.Account;

@Component
public class AccountDao {

	public void addAccount(Account theAccount,boolean value){
		System.out.print("\n"+getClass()+":DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	
	public boolean doWork(){
		
		System.out.print(getClass()+": doWork()");
		return false;
	}
	
	
	
}
