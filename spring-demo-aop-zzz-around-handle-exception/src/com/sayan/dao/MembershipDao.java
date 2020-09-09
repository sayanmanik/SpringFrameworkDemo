package com.sayan.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	
//	public void addAccount(){
//		System.out.print("\n"+getClass()+":DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
//	}
	
//	public void addSillyMember(){
//		System.out.print("\n"+getClass()+":DOING STUFF: ADDING A SILLY MEMBERSHIP ACCOUNT");
//	}
//	
	
	public boolean addSillyMember(){
		System.out.print("\n"+getClass()+":DOING STUFF: ADDING A SILLY MEMBERSHIP ACCOUNT");
	
		return true;
	}
	
	public void goToSleep(){
		
		System.out.print(getClass()+ ": I'm going to sleep now...");
	}
	
}
