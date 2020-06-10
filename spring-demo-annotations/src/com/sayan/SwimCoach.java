package com.sayan;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

	FortuneService service;
	
	public SwimCoach(FortuneService theService){
		service = theService;
	}
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	@Override
	public String getDailyWorkout() {
		return "Swim 100 meters as a warm up...";
	}

	@Override
	public String getDailyFortune() {
		return service.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}