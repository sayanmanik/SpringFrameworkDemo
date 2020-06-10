package com.sayan;

public class TrackCoach implements Coach{

	FortuneService service;
	TrackCoach(FortuneService service){
		this.service = service;
	}
	
	@Override
	public String getWorkoutDetails() {
		// TODO Auto-generated method stub
		return "Run for 5 kms";
	}

	@Override
	public String getFortuneDetails() {
		// TODO Auto-generated method stub
		return service.getService();
	}
	
	public void doMyStartUp(){
		System.out.println("In doMyStartUp method");
	}
	
	public void doMyCleanUp(){
		System.out.println("In doMyCleanUp method");
	}

}
