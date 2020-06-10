package com.sayan;

public class BasketBallCoach implements Coach{

	FortuneService service;
	
	BasketBallCoach(){
		
	}
	
	BasketBallCoach(FortuneService service){
		this.service = service;
	}
	
	@Override
	public String getWorkoutDetails() {
		// TODO Auto-generated method stub
		return "Practice for 30 mins";
	}

	@Override
	public String getFortuneDetails() {
		// TODO Auto-generated method stub
		return service.getService();
	}

}
