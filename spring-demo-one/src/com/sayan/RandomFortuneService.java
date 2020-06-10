package com.sayan;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	Random r = new Random();
	
	private String[] fortunes = {"Today is a good day",
	                    "You can do it",
	                    "Diligence is the key of success"};
	
	@Override
	public String getService() {
	
		Integer i = r.nextInt();
		String str = fortunes[i];
		return str;
	}
}