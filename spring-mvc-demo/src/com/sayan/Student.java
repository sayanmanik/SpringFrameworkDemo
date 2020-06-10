package com.sayan;

import java.util.LinkedHashMap;

public class Student {

	String firstName;
	String lastName;
	String country;
	LinkedHashMap<String,String> map;
	String favoriteLanguage;
	String[] operatingSystem;
	
	public Student(){
		
		map = new LinkedHashMap<String,String>();
		map.put("BR", "Brazil");
		map.put("FR", "France");
		map.put("DE", "Germany");
		map.put("IN","India");
		map.put("US","United States of America");
	}
	
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LinkedHashMap<String, String> getMap() {
		return map;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}


	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
		
}