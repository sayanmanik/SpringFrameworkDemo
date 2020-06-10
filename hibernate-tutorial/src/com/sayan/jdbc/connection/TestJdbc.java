package com.sayan.jdbc.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	
	public static void main(String[] args) {

		String jdbcUrl = 
				"jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "sayan";
		
		
		try{
			System.out.println("Connecting to JDBC");
			Connection con = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connected to :"+jdbcUrl);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
