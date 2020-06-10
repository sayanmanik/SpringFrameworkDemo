package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Student;

public class StudentCreation {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			System.out.println("Creating a new Student object...");
			Student s = new Student("prabhas","manik","prabhas.manik@gmail.com");
		
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			session.save(s);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
			factory.close();
		}
	}
}
