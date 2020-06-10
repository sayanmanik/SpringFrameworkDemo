package com.sayan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
@ComponentScan("com.sayan")
@PropertySource("classpath:sport.properties")
public class SportsConfig {
	
	@Bean
	public FortuneService sadFortuneService(){
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach(){
		return new SwimCoach(sadFortuneService());
	}	
}