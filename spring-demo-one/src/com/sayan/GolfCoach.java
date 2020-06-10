package com.sayan;

public class GolfCoach implements Coach{

	private FortuneService fortuneService;

	public GolfCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getWorkoutDetails() {
		return "Practise 2 hour workout";
	}

	@Override
	public String getFortuneDetails() {		
		return fortuneService.getService();
	}
	
}