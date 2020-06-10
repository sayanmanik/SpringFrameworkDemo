package com.sayan;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
public class TennisCoach implements Coach{

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	
//	@Autowired
//	public void setFortuneService(FortuneService service){
//		System.out.println("Inside setFortune() method");
//		fortuneService = service;
//	}
//	
	@Override
	public String getDailyWorkout() {
		return "Practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void doMyStartUpStaff(){
		System.out.println(">>TennisCoach: inside doStartUpStaff");
	}
	
	@PreDestroy
	public void doMyCleanUpStaff(){
		System.out.println(">>TennisCoach: inside doCleanUpStaff");
	}
	
	
	
	
}