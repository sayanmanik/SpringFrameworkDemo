package com.sayan.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sayan.aopdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;
	

	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList();
		
		Account temp1 = new Account("Sayan","Gold");
		Account temp2 = new Account("Manik","Silver");
		Account temp3 = new Account("Prabhas","Platinum");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount,boolean value){
		System.out.print("\n"+getClass()+":DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	
	public boolean doWork(){
		
		System.out.print(getClass()+": doWork()");
		return false;
	}


	public String getName() {
		System.out.println(getClass()+": in getName()");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass()+": in setName()");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass()+": in getServiceCode()");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
	
}
