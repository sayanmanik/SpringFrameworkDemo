package com.sayan;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;
	String emailAddress;
	String team;
	
	public FortuneService getService() {
		return fortuneService;
	}

	public CricketCoach(){
		System.out.println("Cricket Coach:Inside constructor");
	}
	
	@Override
	public String getWorkoutDetails() {
		return "Practise fast bowling";
	}

	@Override
	public String getFortuneDetails() {
		return fortuneService.getService();
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach:Inside sertter method");
		this.fortuneService = fortuneService;
	}


	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket Coach emailAddress:Inside sertter method");
		this.emailAddress = emailAddress;
	}
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricket Coach team:Inside sertter method");
		this.team = team;
	}
	
	

}
